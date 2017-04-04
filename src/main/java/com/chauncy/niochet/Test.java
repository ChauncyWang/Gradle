package com.chauncy.niochet;

import com.chauncy.niochet.entity.Friend;
import com.chauncy.niochet.server.services.MybaitsTools;
import org.apache.ibatis.session.SqlSession;

import java.util.Base64;


/**
 * 测试类
 * Created by chauncy on 17-3-20.
 */
public class Test {
	public static void main(String[] args) {

		/*
		SqlSession sqlSession = MybaitsTools.getSqlSession();

		Friend friend = sqlSession.selectOne(
				"niochet.FriendMapper.selectFriendGroup", "110");

		System.out.println(friend);
		*/
		Base64.getEncoder().encode("4D".getBytes());

	}
}
