package com.chauncy.niochet.entity;

import java.util.List;

/**
 * 朋友关系类
 * Created by chauncy on 17-3-29.
 */
public class Friend {
	/**
	 * 分组
	 */
	private List<FriendGroup> groups;

	public Friend() {
	}

	public Friend( List<FriendGroup> groups) {
		this.groups = groups;
	}

	public List<FriendGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<FriendGroup> groups) {
		this.groups = groups;
	}
}

/**
 * 分组类
 */
class FriendGroup {
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
}