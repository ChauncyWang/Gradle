package com.chauncy.niochet.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * 开启nio套接字的线程 并监听accept 和 read 事件
 * Created by chauncy on 17-3-18.
 */
public class NIOSocketThread implements Runnable {
	private Logger logger = Logger.getLogger(NIOSocketThread.class);
	private int port;
	private SelectHandlerImpl selectHandler;

	public NIOSocketThread(int port) {
		this.port = port;
		selectHandler = new SelectHandlerImpl();
	}

	@Override
	public void run() {
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
						selectHandler.acceptHandle(readyKey);
					} else if (readyKey.isReadable()) {
						selectHandler.readHandle(readyKey);
					}
					it.remove();
				}
			}
		} catch (IOException e) {
			logger.info("在" + port + "端口开启监听服务发生了未知错误!" + e.getMessage());
		}
	}
}
