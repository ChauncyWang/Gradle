package com.chauncy.niochet.server;

/**
 * Created by chauncy on 17-3-18.
 */
public class ServerMain {
	public static void main(String[] args) {
		NIOSocketThread nioSocketThread = new NIOSocketThread(10001);

		new Thread(nioSocketThread).start();
	}

}