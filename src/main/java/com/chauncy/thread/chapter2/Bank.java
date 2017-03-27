package com.chauncy.thread.chapter2;

/**
 * 银行类，负责消耗账户资金
 * Created by chauncy on 17-3-14.
 */
public class Bank implements Runnable{
	private Account account;
	public Bank(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0;i < 100;++i) {
			account.subtractAmmount(1000);
		}
	}
}
