package com.chauncy.nionetframework.services;

import com.chauncy.nionetframework.NIOServer;
import com.chauncy.nionetframework.entity.MessageNode;
import com.chauncy.nionetframework.util.LoggerRunnable;

import java.io.IOException;

import static com.chauncy.nionetframework.util.NetTools.writeObject;

/**
 * 从写入消息队列取出消息进行发送
 * Created by chauncy on 17-4-4.
 */
public class WriteService extends LoggerRunnable {
	private MessageQueueService messageQueueService;
	private IoSessionService statusSessionService;

	public WriteService(NIOServer nioNet) {
		messageQueueService = nioNet.getMq();
		statusSessionService = nioNet.getSession();
	}

	@Override
	public void execute() {
		MessageNode messageNode = messageQueueService.removeToWMQ();
		if (messageNode != null) {
			try {
				writeObject(
						statusSessionService.getSession(messageNode.getIp(), messageNode.getPort()).getSocketChannel(),
						messageNode.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
