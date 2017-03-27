package com.chauncy.thread.chapter2;

/**
 * 公司类负责为账户添加资金
 * Created by chauncy on 17-3-14.
 */
public class Company implements Runnable {
	private Account account;
	public Company(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		for(int i = 0;i < 100;++i) {
			account.addAmount(1000);
		}
	}
}
