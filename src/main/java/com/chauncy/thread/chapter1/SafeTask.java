package com.chauncy.thread.chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程中局部变量的声明
 * Created by chauncy on 17-3-14.
 */
public class SafeTask implements Runnable {
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		@Override
		protected Date initialValue() {
			return new Date();
		}
	};
	@Override
	public void run() {
		System.out.printf("Starting Thread:%s : %s %n",Thread.currentThread().getId(),startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished:%s:%s%n",Thread.currentThread().getId(),startDate.get());
	}
}
