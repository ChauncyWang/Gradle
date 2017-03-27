package com.chauncy.mychet.server;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chauncy on 17-3-17.
 */
public class Main {
	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws InterruptedException {
		try (ServerSocket serverSocket = new ServerSocket(10000)) {
			while (true) {
				Socket socket = serverSocket.accept();
				logger.info(socket.getInetAddress().getHostName() + " connection on port " + socket.getPort());
				ServerAutoDisconnectSocket serverAutoDisconnectSocket =
						new ServerAutoDisconnectSocket(socket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
