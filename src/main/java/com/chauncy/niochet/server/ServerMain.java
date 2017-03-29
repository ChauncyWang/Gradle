package com.chauncy.niochet.server;

import com.chauncy.niochet.server.services.MybaitsTools;

/**
 * 服务器主线程
 * Created by chauncy on 17-3-18.
 */
public class ServerMain {
	public static void main(String[] args) throws ClassNotFoundException {
	    //第一次连接会有延迟，不知道原因呢
        MybaitsTools.getSqlSession();
		NIOSocketThread nioSocketThread = new NIOSocketThread(10001);

		new Thread(nioSocketThread).start();
	}

}
