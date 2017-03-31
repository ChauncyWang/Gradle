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

	public Friend(List<FriendGroup> groups) {
		this.groups = groups;
	}

	public List<FriendGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<FriendGroup> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Friend{" +
				"groups=" + groups +
				'}';
	}
}

