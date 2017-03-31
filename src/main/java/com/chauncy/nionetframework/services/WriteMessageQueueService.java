package com.chauncy.nionetframework.services;


import com.chauncy.nionetframework.entity.MessageNode;
import com.chauncy.nionetframework.entity.MessageQueue;
import org.apache.log4j.Logger;
import static com.chauncy.nionetframework.util.NetTools.*;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * 写 消息队列服务
 * Created by Chauncy on 2017/4/1.
 */
public class WriteMessageQueueService implements Runnable {
	private static Logger logger = Logger.getLogger(WriteMessageQueueService.class);
	/**
	 * 写的消息队列
	 */
	private volatile MessageQueue messageQueue;
	/**
	 * 会话服务
	 */
	private StatusSessionService statusSessionService;

	public WriteMessageQueueService(StatusSessionService statusSessionService) {
		this.statusSessionService = statusSessionService;
		messageQueue = new MessageQueue();
	}

	@Override
	public void run() {
		logger.info(Thread.currentThread().getName()+"启动...");
		while (!Thread.currentThread().isInterrupted()) {
			if(messageQueue.size()!=0){
				try{
					MessageNode messageNode = messageQueue.remove();
					SocketChannel socketChannel = statusSessionService
							.getSession(messageNode.getIp(),messageNode.getPort()).getSocketChannel();

					writeObject(socketChannel,messageNode.getMessage());
				}catch (IOException e){
					logger.warn(e.getMessage());
				}
			}
		}
	}

	/**
	 * 向消息队列添加 消息
	 *
	 * @param message 待添加的消息
	 */
	public synchronized void add(MessageNode message) {
		messageQueue.add(message);
		logger.debug(String.format("MQ[%d] 添加一条消息[%s:%d]",
				messageQueue.size(), message.getIp(), message.getPort()));
	}

}
