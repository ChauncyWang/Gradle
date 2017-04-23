package com.chauncy.thread.chapter2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock模拟打印队列
 * Created by chauncy on 17-3-14.
 */
public class PrintQueue {
	private final Lock queueLock = new ReentrantLock();
	public void printJob(Object document) {
		queueLock.lock();
		try {
			Long duratioon = (long)(Math.random()*10000);
			System.out.println(Thread.currentThread().getName()+":PrintQueue:Printing " +
					"a Job during "+ (duratioon/1000)+" seconds");
			Thread.sleep(duratioon);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			queueLock.unlock();
		}
	}
}
