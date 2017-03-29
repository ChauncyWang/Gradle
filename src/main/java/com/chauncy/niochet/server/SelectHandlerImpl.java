package com.chauncy.niochet.server;

import com.chauncy.niochet.entity.NetMessage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.*;

import static com.chauncy.util.NetTools.readObject;
import static com.chauncy.util.NetTools.writeObject;

/**
 * 处理 网络连接 NIO 的各种状态
 * Created by chauncy on 17-3-18.
 */
public class SelectHandlerImpl implements SelectHandler {
	private Logger logger = Logger.getLogger(SelectHandlerImpl.class);
	private DealHandlerDaemonThread daemonThread;
	private MessageHandlerThread dealHandlerThread;
	private MessageQueue receives = new MessageQueue();
	private MessageQueue sends = new MessageQueue();
	private SessionFactory sessionFactory;

	public SelectHandlerImpl() {
		daemonThread = new DealHandlerDaemonThread(this);
		dealHandlerThread = new MessageHandlerThread(this);
		sessionFactory = SessionFactory.getSessionFactory();
		daemonThread.start();
		new Thread(dealHandlerThread, "消息处理线程").start();
	}

	@Override
	public void acceptHandle(SelectionKey readyKey) {
		Selector selector = readyKey.selector();

		try {
			ServerSocketChannel serverSocketChannel = (ServerSocketChannel) readyKey.channel();
			SocketChannel socketChannel = serverSocketChannel.accept();
			Socket socket = socketChannel.socket();

			//注册会话
			Session session = sessionFactory.openSession(socket.getInetAddress().getHostName(), socket.getPort(), socketChannel);
			logger.info(String.format("[%s:%d]连接了...", socket.getInetAddress(), socket.getPort()));

			//设置非阻塞并注册selector选择器,监听输入和输出事件
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			logger.debug(e);
		}
	}

	@Override
	public void readHandle(SelectionKey readyKey) {
		SocketChannel socketChannel = (SocketChannel) readyKey.channel();
		Socket socket = null;

		try {
			socket = socketChannel.socket();
			NetMessage msg = (NetMessage) readObject(socketChannel);

			MessageNode node = new MessageNode(socket.getInetAddress().getHostName(),
					socket.getPort(), msg);
			receives.enqueue(node);

			logger.debug(String.format("%s:%d的消息队列添加一条消息.", socket.getInetAddress(), socket.getPort()));
		} catch (IOException e) {
			logger.debug(e);
			//e.printStackTrace();
			logger.info(String.format("[%s:%d]断开了连接!", socket.getInetAddress(), socket.getPort()));

			//关闭会话
			sessionFactory.closeSession(sessionFactory.getSession(
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

	public MessageQueue getReceives() {
		return receives;
	}

	public MessageQueue getSends() {
		return sends;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
