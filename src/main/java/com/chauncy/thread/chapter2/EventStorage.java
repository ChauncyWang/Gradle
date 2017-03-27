package com.chauncy.thread.chapter2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 在同步代码中使用条件
 * Created by chauncy on 17-3-14.
 */
public class EventStorage {
	private int maxSize;
	private List<Date> storage = new LinkedList<Date>();;
	public EventStorage() {
		maxSize = 10;
	}
	public synchronized void set() {
		while(storage.size() == maxSize) {
			try{
				System.out.println("set wait\n");
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(new Date());
		System.out.printf("Set:%d\n",storage.size());
		notifyAll();
	}
	public synchronized void get() {
		while (storage.size() == 0) {
			try{
				System.out.println("get wait\n");
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get:%d:%s\n",storage.size(),((LinkedList<?>)storage).poll());
		notifyAll();
	}
}
