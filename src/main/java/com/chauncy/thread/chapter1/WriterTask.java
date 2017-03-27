package com.chauncy.thread.chapter1;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by chauncy on 17-3-11.
 */
public class WriterTask implements Runnable{
	private Deque<Event> deque = null;
	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}

	@Override
	public void run() {
		for(int i = 0;i < 100;++i) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(Thread.currentThread().getName()+"has generated an event");
			deque.addFirst(event);
			try{
				TimeUnit.SECONDS.sleep(1);

			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
