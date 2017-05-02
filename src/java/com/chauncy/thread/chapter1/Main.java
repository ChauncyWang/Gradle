package com.chauncy.thread.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * 章节1.6
 * Created by chauncy on 17-3-11.
 */
public class Main {
	public static void main(String[] args) {
		SafeTask unsafeTask = new SafeTask();
		MyThreadFactory myThreadFactory = new MyThreadFactory("我的");
		for(int i = 0;i < 10;++i) {
			Thread thread = myThreadFactory.newThread(unsafeTask);
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}

		System.out.println(myThreadFactory.getState());
	}
}
