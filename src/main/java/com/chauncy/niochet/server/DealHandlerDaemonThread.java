package com.chauncy.niochet.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * 守护线程不停的查看DealHandler中消息队列的状态，如果为空就进行删除
 * Created by chauncy on 17-3-19.
 */
public class DealHandlerDaemonThread extends Thread {
	private Logger logger = Logger.getLogger(DealHandlerDaemonThread.class);
	private SelectHandlerImpl dealHandler = null;

	public DealHandlerDaemonThread(SelectHandlerImpl dealHandler) {
		super("消息守护线程");
		this.dealHandler = dealHandler;
		this.setDaemon(true);
	}

	@Override
	public void run() {
		logger.info(getName() + "开启...");
		while (true) {
			Iterator<Map.Entry<String, Session>> entrys = dealHandler.getSessionFactory().getMap().entrySet().iterator();
			while (entrys.hasNext()) {
				Map.Entry<String, Session> entry = entrys.next();
				Session session = entry.getValue();
				try {
					session.getSocketChannel().socket().sendUrgentData(0xFF);
				} catch (IOException e) {
					logger.info(String.format("[%s:%d]已掉线!",session.getIp(),session.getPort()));
					dealHandler.getSessionFactory().closeSession(session);
				}
			}
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				logger.warn(e);
			}
		}
	}
}
