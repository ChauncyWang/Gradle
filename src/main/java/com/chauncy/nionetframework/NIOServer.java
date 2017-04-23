package com.chauncy.nionetframework;

import com.chauncy.nionetframework.event.SelectEvent;
import com.chauncy.nionetframework.event.SelectListener;
import com.chauncy.nionetframework.services.ConnectDaemonService;
import com.chauncy.nionetframework.services.MessageQueueService;
import com.chauncy.nionetframework.services.IoSessionService;
import com.chauncy.nionetframework.services.WriteService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;


/**
 * 这个自定义小框架的主要类 所有服务都集成在这里
 * Created by chauncy on 17-3-31.
 */
public class NIOServer implements Runnable {
	private static Logger logger = Logger.getLogger(NIOServer.class);
	/**
	 * 连接守护服务
	 */
	private ConnectDaemonService connectDaemon;
	/**
	 * 消息队列 服务，
	 */
	private MessageQueueService mq;
	/**
	 * 所有连接的会话服务
	 */
	private IoSessionService session;
	/**
	 * 消息写入服务
	 */
	private WriteService writeService;
	/**
	 * select 监听
	 */
	private SelectListener selectListener = new SimpleSelectListener();
	/**
	 * 服务器开启的端口
	 */
	private int port;

	public NIOServer(int port) {
		this.port = port;
		session = new IoSessionService();
		connectDaemon = new ConnectDaemonService(session);
		mq = new MessageQueueService();
		writeService = new WriteService(this);
		//开启主线程
		//new Thread(this, "主NIO处理线程").start();
	}

	@Override
	public void run() {
		connectDaemon.start();
		new Thread(writeService, "消息写入线程").start();
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
						SelectEvent selectEvent = new SelectEvent(mq, getSession(), readyKey);
						selectListener.accept(selectEvent);
					} else if (readyKey.isReadable()) {//如果是读取事件
						SelectEvent selectEvent = new SelectEvent(mq, getSession(), readyKey);
						selectListener.read(selectEvent);
					}
					it.remove();
				}
			}
		} catch (IOException e) {
			logger.info("在" + port + "端口开启监听服务发生了未知错误!" + e.getMessage());
		}
	}

	public ConnectDaemonService getConnectDaemon() {
		return connectDaemon;
	}

	public MessageQueueService getMq() {
		return mq;
	}

	public IoSessionService getSession() {
		return session;
	}
}