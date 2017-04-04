package com.chauncy.nionetframework;

import com.chauncy.nionetframework.entity.IoSession;
import com.chauncy.nionetframework.entity.MessageNode;
import com.chauncy.nionetframework.entity.NetMessage;
import com.chauncy.nionetframework.event.SelectEvent;
import com.chauncy.nionetframework.event.SelectListener;
import com.chauncy.nionetframework.services.MessageQueueService;
import com.chauncy.nionetframework.services.IoSessionService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import static com.chauncy.nionetframework.util.NetTools.readObject;

/**
 * 简单的select事件监听器
 * Created by chauncy on 17-4-4.
 */
public class SimpleSelectListener implements SelectListener {
	private static Logger logger = Logger.getLogger(SimpleSelectListener.class);

	@Override
	public void accept(SelectEvent event) {
		SelectionKey readyKey = event.getReadyKey();
		Selector selector = readyKey.selector();

		try {
			ServerSocketChannel serverSocketChannel = (ServerSocketChannel) readyKey.channel();
			SocketChannel socketChannel = serverSocketChannel.accept();
			Socket socket = socketChannel.socket();

			//注册会话
			IoSession session = event.getSession().addSession(socket.getInetAddress().getHostName(), socket.getPort(), socketChannel);
			logger.info(String.format("[%s:%d]连接了...", socket.getInetAddress(), socket.getPort()));

			//设置非阻塞并注册selector选择器,监听输入和输出事件
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			logger.debug(e);
		}
	}

	@Override
	public void read(SelectEvent event) {
		SelectionKey readyKey = event.getReadyKey();
		MessageQueueService mq = event.getMq();
		IoSessionService session = event.getSession();
		SocketChannel socketChannel = (SocketChannel) readyKey.channel();
		Socket socket = null;

		try {
			socket = socketChannel.socket();
			NetMessage msg = (NetMessage) readObject(socketChannel);

			MessageNode node = new MessageNode(socket.getInetAddress().getHostName(),
					socket.getPort(), msg);
			mq.addToRMQ(node);

			logger.debug(String.format("%s:%d的消息队列添加一条消息.", socket.getInetAddress(), socket.getPort()));
		} catch (IOException e) {
			logger.debug(e);
			//e.printStackTrace();
			logger.info(String.format("[%s:%d]断开了连接!", socket.getInetAddress(), socket.getPort()));

			//关闭会话
			session.closeSession(session.getSession(
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
