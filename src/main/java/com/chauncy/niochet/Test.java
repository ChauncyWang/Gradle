package com.chauncy.niochet;

import com.chauncy.niochet.services.UserService;


/**
 * Created by chauncy on 17-3-20.
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(
				new UserService().login("110", "1100"));

		System.out.println(
				new UserService().getUserInfo("110"));
	}
}
