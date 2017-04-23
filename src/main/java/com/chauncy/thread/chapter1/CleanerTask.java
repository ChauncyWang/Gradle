package com.chauncy.thread.chapter1;

import java.util.Date;
import java.util.Deque;

/**
 * 守护线程.在程序中只剩下守护线程时，程序自动退出
 * Created by chauncy on 17-3-11.
 */
public class CleanerTask extends Thread {
	private Deque<Event> deque;
	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		setDaemon(true);
	}

	@Override
	public void run() {
		while(true) {
			clear(new Date());
		}
	}

	private void clear(Date date) {
		long difference;
		boolean delete;
		if(deque.isEmpty()) {
			return;
		}
		delete = false;
		do {
			Event e = deque.getLast();
			difference = date.getTime() - e.getDate().getTime();
			if(difference > 10000) {
				System.out.println("Cleaner:"+e.getEvent());
				deque.removeLast();
				delete = true;
			}
		}while (difference > 10000);
		if(delete) {
			System.out.println("Cleaner:Size of the quene:"+deque.size());
		}
	}
}
