package com.chauncy.thread.chapter2;

/**
 * 生产类,负责产生事件
 * Created by chauncy on 17-3-14.
 */
public class Producer implements Runnable {
	private EventStorage storage;
	public Producer(EventStorage storage) {
		this.storage = storage;
	}
	@Override
	public void run() {
		for(int i = 0;i < 100;++i) {
			storage.set();
		}
	}
}
