package com.chauncy.thread.chapter2;

/**
 * Created by chauncy on 17-3-14.
 */
public class Account {
	private double blance;

	/**
	 * 添加资金到账户
	 *
	 * @param amount 要添加的资金
	 */
	//如果未使用synchronized关键字就会出现错误
	//public void addAmount(double amount) {
	public synchronized void addAmount(double amount) {
		double tmp = blance;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp += amount;
		blance = tmp;
	}

	/**
	 * 从账户扣除资金
	 *
	 * @param amount 要扣除的资金
	 */
	//如果未使用synchronized关键字就会出现错误
	//public void subtractAmmount(double amount) {
	public synchronized void subtractAmmount(double amount) {
		double tmp = blance;
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp -= amount;
		blance = tmp;
	}

	///getter and setter
	public double getBlance() {
		return blance;
	}

	public void setBlance(double blance) {
		this.blance = blance;
	}
}
