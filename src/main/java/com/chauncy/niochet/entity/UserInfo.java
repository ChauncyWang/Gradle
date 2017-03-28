package com.chauncy.niochet.entity;

import java.io.Serializable;

/**
 * 用户信息
 * Created by chauncy on 17-3-26.
 */
public class UserInfo implements Serializable {
	/**
	 * id
	 */
	private String id;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 签名
	 */
	private String signature;

	public UserInfo() {
	}

	public UserInfo(String id, String nickName, String signature) {
		this.id = id;
		this.nickName = nickName;
		this.signature = signature;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id='" + id + '\'' +
				", nickName='" + nickName + '\'' +
				", signature='" + signature + '\'' +
				'}';
	}
}
