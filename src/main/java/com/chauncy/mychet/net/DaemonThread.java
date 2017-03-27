package com.chauncy.mychet.net;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

/**
 * 守护线程
 * Created by chauncy on 17-3-18.
 */
public class DaemonThread extends Thread {
	private Logger logger = Logger.getLogger(DaemonThread.class);
	private AbstractSocket abstractSocket;
	private Socket socket;
	private int interval = 1000;
	private DisconnectToDo iDaemonThread;

	public DaemonThread(AbstractSocket abstractSocket, DisconnectToDo iDaemonThread, String name) {
		super(name);
		this.abstractSocket = abstractSocket;
		this.iDaemonThread = iDaemonThread;
		//this.setDaemon(true);
		this.socket = abstractSocket.socket;
		logger.debug(getName() + " constructed!");
	}

	@Override
	public void run() {
		logger.debug(getName() + " start...");
		while (true) {
			try {
				sleep(interval);
				socket.sendUrgentData(0xff);
				logger.debug(getName() + " try send urgent data...");
				throw new IOException("测试");
			} catch (InterruptedException | IOException e) {
				if (e instanceof IOException) {
					logger.debug(getName() + " send urgent data failed!");
					iDaemonThread.todo(abstractSocket);
				} else {
					break;
				}
			}
			logger.debug(getName() + " send urgent data successed!");
		}
		logger.debug(getName() + " stop...");
	}
}
