package com.chauncy.thread.chapter1;

/**
 * Created by chauncy on 17-3-11.
 */
public class ExcptionHandler implements Thread.UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		System.out.println(thread.getName()+"发生了异常!%n");
		throwable.printStackTrace(System.out);
	}
}
