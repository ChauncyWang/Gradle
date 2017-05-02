package com.chauncy.thread.chapter1;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * 线程工厂
 * Created by chauncy on 17-3-14.
 */
public class MyThreadFactory implements ThreadFactory {
	private String name;
	private int counter;
	private List<String> state = new LinkedList<>();
	public MyThreadFactory(String name) {
		counter = 0;
		this.name = name;
	}
	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable,name+"_Thread--"+counter);
		counter++;
		state.add(String.format("Created thread %d with name %s on %s",thread.getId(),thread.getName(),new Date()));
		return thread;
	}

	public String getState() {
		StringBuffer sb = new StringBuffer();
		for(String it:state){
			sb.append(it);
			sb.append("\n");
		}
		return new String(sb);
	}
}
