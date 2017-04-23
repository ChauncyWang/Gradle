package com.chauncy.niochet.entity;

import java.util.List;

/**
 * 分组类
 */
public class FriendGroup {
	/**
	 * 分组名
	 */
	private String name;
	/**
	 * 分组用户信息
	 */
	private List<UserInfo> friend;

	public FriendGroup() {
	}

	public FriendGroup(String name, List<UserInfo> friend) {
		this.name = name;
		this.friend = friend;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserInfo> getFriend() {
		return friend;
	}

	public void setFriend(List<UserInfo> friend) {
		this.friend = friend;
	}

	@Override
	public String toString() {
		return "FriendGroup{" +
				"name='" + name + '\'' +
				", friend=" + friend +
				'}';
	}
}
