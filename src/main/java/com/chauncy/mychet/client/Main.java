package com.chauncy.mychet.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by chauncy on 17-3-17.
 */
public class Main {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 10000);
			ClientKeepAliveSocket clientKeepAliveSocket = new
					ClientKeepAliveSocket(socket);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
