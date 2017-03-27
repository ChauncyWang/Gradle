package com.chauncy.thread.chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Chapter 1.6
 * Created by chauncy on 17-3-11.
 */
public class DataSourcesLoader implements Runnable {

	private int sleep;

	public DataSourcesLoader(int sleep) {
		this.sleep = sleep;
	}


	@Override
	public void run() {
		System.out.printf("%s开始加载资源...%n%s%n", Thread.currentThread().getName(), new Date());

		try {
			TimeUnit.SECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("%s加载资源完成！%n%s%n", Thread.currentThread().getName(), new Date());
	}
}