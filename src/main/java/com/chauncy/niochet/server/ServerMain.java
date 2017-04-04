package com.chauncy.niochet.server;

import com.chauncy.niochet.server.actions.MessageActions;
import com.chauncy.niochet.server.services.MybaitsTools;
import com.chauncy.nionetframework.NIONet;

import java.util.Scanner;

/**
 * 服务器主线程
 * Created by chauncy on 17-3-18.
 */
public class ServerMain implements Runnable{
	private NIONet nioNet;
	private Thread thread;
	public static void main(String[] args) throws ClassNotFoundException {
		new ServerMain();
	}

	private ServerMain() {
		//第一次连接会有延迟，不知道原因呢
		MybaitsTools.getSqlSession().getConnection();
		MessageActions messageActions = new MessageActions();
		nioNet = new NIONet(10001);
		thread = new Thread(nioNet,"主NIO线程");
		new Thread(this,"cmd线程").start();
	}
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(true){
			String cmd = scanner.nextLine();
			if(cmd.startsWith("/")){
				if(cmd.equals("/start")){
					thread.start();
					MessageHandleThread messageHandleThread = new MessageHandleThread(nioNet);
					new Thread(messageHandleThread).start();
				}if(cmd.equals("/user")){
					System.out.println(nioNet.getStatusSessionService().getAll());
				}
			}
		}
	}
}
