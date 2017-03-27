package com.chauncy.thread.chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 非局部变量
 * Created by chauncy on 17-3-14.
 */
public class UnsafeTask implements Runnable {
	private Date startDate;
	@Override
	public void run() {
			startDate = new Date();
			System.out.printf("Starting Thread:%s : %s %n",Thread.currentThread().getId(),startDate);
			try {
				TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.printf("Thread Finished:%s:%s%n",Thread.currentThread().getId(),startDate);
	}
}
