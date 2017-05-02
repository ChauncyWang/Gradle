package com.chauncy.nionetframework.util;

import org.apache.log4j.Logger;

/**
 * 带logger的Runnable抽象类
 * Created by chauncy on 17-4-4.
 */
public abstract class LoggerRunnable implements Runnable {
	private static Logger logger = Logger.getLogger("G");

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		logger.info(thread.getName() + "启动...");
		while (!thread.isInterrupted()) {
			execute();
		}
		logger.info(thread.getName() + "结束!");
	}

	public abstract void execute();
}
