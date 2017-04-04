package com.chauncy.nionetframework;

import com.chauncy.nionetframework.entity.MessageNode;
import com.chauncy.nionetframework.entity.NetMessage;
import com.chauncy.nionetframework.entity.Session;
import com.chauncy.nionetframework.services.ConnectDaemonService;
import com.chauncy.nionetframework.services.MessageQueueService;
import com.chauncy.nionetframework.services.StatusSessionService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static com.chauncy.nionetframework.util.NetTools.readObject;

/**
 * 这个自定义小框架的主要类 所有服务都集成在这里
 * Created by chauncy on 17-3-31.
 */
public class NIONet implements Runnable, SelectHandler {
	private static Logger logger = Logger.getLogger(NIONet.class);
	/**
	 * 连接守护服务
	 */
	private ConnectDaemonService connectDaemonService;
	/**
	 * 消息队列 服务，
	 */
	private MessageQueueService messageQueueService;
	/**
	 * 所有连接的会话服务
	 */
	private StatusSessionService statusSessionService;
	/**
	 * 服务器开启的端口
	 */
	private int port;

	public NIONet(int port) {
		this.port = port;
		statusSessionService = new StatusSessionService();
		connectDaemonService = new ConnectDaemonService(statusSessionService);
		messageQueueService = new MessageQueueService();
		//开启主线程
		//new Thread(this, "主NIO处理线程").start();
	}

	@Override
	public void run() {
		logger.info(Thread.currentThread().getName() + "开启...");
		//开启守护线程
		connectDaemonService.start();
		//进行NIO处理
		Selector selector = null;
		ServerSocketChannel serverChannel = null;
		try {
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.socket().bind(new InetSocketAddress(port));
			//打开选择器
			selector = Selector.open();
			//在serverChannel上注册该选择器
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			logger.info("在" + port + "端口开启监听服务!");
			//有消息准备就绪
			while (selector.select() > 0) {
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				//遍历所有准备好的消息
				while (it.hasNext()) {
					SelectionKey readyKey = it.next();
					//如果是连接事件
					if (readyKey.isAcceptable()) {
						acceptHandle(readyKey);
					} else if (readyKey.isReadable()) {//如果是读取事件
						readHandle(readyKey);
					}
					it.remove();
				}
			}
		} catch (IOException e) {
			logger.info("在" + port + "端口开启监听服务发生了未知错误!" + e.getMessage());
		}
		logger.info(Thread.currentThread().getName()+"结束!");
	}


	@Override
	public void acceptHandle(SelectionKey selectionKey) {
		Selector selector = selectionKey.selector();

		try {
			ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
			SocketChannel socketChannel = serverSocketChannel.accept();
			Socket socket = socketChannel.socket();

			//注册会话
			Session session = statusSessionService.addSession(socket.getInetAddress().getHostName(), socket.getPort(), socketChannel);
			logger.info(String.format("[%s:%d]连接了...", socket.getInetAddress(), socket.getPort()));

			//设置非阻塞并注册selector选择器,监听输入和输出事件
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			logger.debug(e);
		}
	}

	@Override
	public void readHandle(SelectionKey selectionKey) {
		SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
		Socket socket = null;

		try {
			socket = socketChannel.socket();
			NetMessage msg = (NetMessage) readObject(socketChannel);

			MessageNode node = new MessageNode(socket.getInetAddress().getHostName(),
					socket.getPort(), msg);
			messageQueueService.addToRMQ(node);

			logger.debug(String.format("%s:%d的消息队列添加一条消息.", socket.getInetAddress(), socket.getPort()));
		} catch (IOException e) {
			logger.debug(e);
			//e.printStackTrace();
			logger.info(String.format("[%s:%d]断开了连接!", socket.getInetAddress(), socket.getPort()));

			//关闭会话
			statusSessionService.closeSession(statusSessionService.getSession(
					socket.getInetAddress().getHostName(), socket.getPort()));
			//关闭连接
			try {
				socketChannel.close();
			} catch (IOException e1) {
				logger.debug(e);
			}
		} catch (ClassNotFoundException e) {
			logger.debug(e);
		}

	}

	public ConnectDaemonService getConnectDaemonService() {
		return connectDaemonService;
	}

	public MessageQueueService getMessageQueueService() {
		return messageQueueService;
	}

	public StatusSessionService getStatusSessionService() {
		return statusSessionService;
	}
}