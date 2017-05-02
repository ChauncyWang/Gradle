package com.chauncy.thread.chapter2;

/**
 * 章节2
 * Created by chauncy on 17-3-14.
 */
public class Main {
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread[] thread = new Thread[10];
		for(int i = 0;i < 10;++i) {
			thread[i] = new Thread(new Job(printQueue),"Thread "+i);
		}
		for(int i = 0;i < 10;++i) {
			thread[i].start();
		}

		/* 在同步代码中使用条件
		EventStorage storage = new EventStorage();
		Producer producer = new Producer(storage);
		Thread producerThread = new Thread(producer);
		Consumer consumer = new Consumer(storage);
		Thread comsumerThread = new Thread(consumer);

		producerThread.start();
		comsumerThread.start();
		*/

		//事件同步
		/*Account account = new Account();
		account.setBlance(0);
		Company company = new Company(account);
		Bank bank = new Bank(account);
		Thread companyThread = new Thread(company);
		Thread backThread = new Thread(bank);

		companyThread.start();
		backThread.start();

		try {
			//等待线程执行完毕
			companyThread.join();
			backThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(account.getBlance());*/
	}
}
