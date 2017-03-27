package com.chauncy.mychet.net;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by chauncy on 17-3-17.
 */
public class UtilTool {
	private static Logger logger = Logger.getLogger(UtilTool.class);

	public static void reConnection(AbstractSocket abstractSocket) {
		logger.debug("Try reconnection ...");
		for (int i = 0; i < 10; ++i) {
			logger.debug("Try reconnection the " + i + "th...");
			try {
				Socket socket = abstractSocket.socket;
				abstractSocket.setSocket(new Socket(
						socket.getInetAddress(), socket.getPort()));
				return;
			} catch (IOException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.debug("Try reconnection failed!");
	}
}
