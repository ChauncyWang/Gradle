package com.chauncy.nionetframework.services;

import com.chauncy.nionetframework.entity.IoSession;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * 连接守护服务(守护线程) 处理用户掉线
 * Created by chauncy on 17-3-19.
 */
public class ConnectDaemonService extends Thread {
	private Logger logger = Logger.getLogger(ConnectDaemonService.class);
	private IoSessionService statusSessionService = null;

	public ConnectDaemonService(IoSessionService statusSessionService) {
		super("连接守护服务");
		this.statusSessionService = statusSessionService;
		this.setDaemon(true);
	}

	@Override
	public void run() {
		logger.info(getName() + "开启...");
		while (true) {
			Iterator<Map.Entry<String, IoSession>> entrys =
					statusSessionService.getMap().entrySet().iterator();
			while (entrys.hasNext()) {
				Map.Entry<String, IoSession> entry = entrys.next();
				IoSession session = entry.getValue();
				try {
					session.getSocketChannel().socket().sendUrgentData(0xFF);
				} catch (IOException e) {
					logger.info(String.format("[%s:%d]已掉线!", session.getIp(), session.getPort()));
					statusSessionService.closeSession(session);
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
