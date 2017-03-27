package com.chauncy.thread.chapter2;

/**
 * Created by chauncy on 17-3-14.
 */
public class Consumer implements Runnable {
	private EventStorage storage;
	public Consumer(EventStorage storage) {
		this.storage = storage;
	}
	@Override
	public void run() {
		for(int i = 0;i < 100;++i) {
			storage.get();
		}
	}
}
