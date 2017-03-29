package com.chauncy.niochet.entity;

/**
 * 朋友关系类
 * Created by chauncy on 17-3-29.
 */
public class Friend {
	private String uId;
	private String fId;

	public Friend() {
	}

	public Friend(String uId, String fId) {
		this.uId = uId;
		this.fId = fId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}
}
