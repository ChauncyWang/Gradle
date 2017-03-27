package com.chauncy.mychet.client;

import java.net.Socket;

/**
 * Created by chauncy on 17-3-18.
 */
public class ClientThread implements Runnable {
	private ClientKeepAliveSocket clientKeepAliveSocket;

	public ClientThread() {

	}
	@Override
	public void run() {
		try {
			Socket socket = new Socket("127.0.0.1", 10000);
			clientKeepAliveSocket = new ClientKeepAliveSocket(socket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
