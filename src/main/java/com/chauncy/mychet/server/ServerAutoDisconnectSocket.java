package com.chauncy.mychet.server;

import com.chauncy.mychet.net.AbstractSocket;
import com.chauncy.mychet.net.DaemonThread;
import com.chauncy.mychet.net.UtilTool;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

/**
 * 为可以保持长连接的套接字做准备，如果断连就删除改套接字等待新的连接
 * Created by chauncy on 17-3-18.
 */
public class ServerAutoDisconnectSocket extends AbstractSocket {
	private static Logger logger = Logger.getLogger(ServerAutoDisconnectSocket.class);
	public ServerAutoDisconnectSocket(Socket socket) throws Exception {
		setSocket(socket);
	}

	@Override
	public void setDaemonThread() {
		daemonThread = new DaemonThread(this,
				ServerAutoDisconnectSocket::disconnectToDo,"Server_Daemon");
	}
	public static void disconnectToDo(AbstractSocket abstractSocket) {
		logger.debug("Auto disconnection ...");
		abstractSocket.destroy();
	}
}