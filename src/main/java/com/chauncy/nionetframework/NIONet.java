package com.chauncy.nionetframework;

import com.chauncy.niochet.entity.StatusSession;
import com.chauncy.nionetframework.action.IMessageActions;
import com.chauncy.nionetframework.entity.MessageNode;
import com.chauncy.nionetframework.entity.NetMessage;
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
	private ConnectDaemonService connectDaemonService;
	private MessageQueueService messageQueueService;
	private StatusSessionService statusSessionService;
	private int port;

	public NIONet(int port, IMessageActions actions) {
		this.port = port;
		messageQueueService = new MessageQueueService(actions);
		statusSessionService = new StatusSessionService();
		connectDaemonService = new ConnectDaemonService(statusSessionService);
		new Thread(this, "主NIO处理线程").start();
	}

	@Override
	public void run() {
		logger.info(Thread.currentThread().getName() + "开启...");
		connectDaemonService.start();
		Thread thread = new Thread(this, "消息队列服务线程");
		thread.start();
		Selector selector = null;
		ServerSocketChannel serverChannel = null;
		try {
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.socket().bind(new InetSocketAddress(port));
			selector = Selector.open();
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			logger.info("在" + port + "端口开启监听服务!");
			while (selector.select() > 0) {
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey readyKey = it.next();
					if (readyKey.isAcceptable()) {
						acceptHandle(readyKey);
					} else if (readyKey.isReadable()) {
						readHandle(readyKey);
					}
					it.remove();
				}
			}
		} catch (IOException e) {
			logger.info("在" + port + "端口开启监听服务发生了未知错误!" + e.getMessage());
			connectDaemonService.interrupt();
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

	@Override
	public void acceptHandle(SelectionKey selectionKey) {
		Selector selector = selectionKey.selector();

		try {
			ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
			SocketChannel socketChannel = serverSocketChannel.accept();
			Socket socket = socketChannel.socket();

			//注册会话
			StatusSession session = statusSessionService.addSession(socket.getInetAddress().getHostName(), socket.getPort(), socketChannel);
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
			messageQueueService.add(node);

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
}
