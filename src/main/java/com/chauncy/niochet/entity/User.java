package com.chauncy.niochet.entity;

/**
 * 用户类
 * Created by chauncy on 17-3-24.
 */
public class User {
	/**
	 * 用户 id
	 */
	private String id;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户信息
	 */
	private UserInfo userInfo;

	public User() {
	}

	public User(String id, String password, UserInfo userInfo) {
		this.id = id;
		this.password = password;
		this.userInfo = userInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", password='" + password + '\'' +
				", userInfo=" + userInfo +
				'}';
	}
}
