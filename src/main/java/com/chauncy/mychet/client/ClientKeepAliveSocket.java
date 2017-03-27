package com.chauncy.mychet.client;

import com.chauncy.mychet.net.AbstractSocket;
import com.chauncy.mychet.net.DaemonThread;
import com.chauncy.mychet.net.UtilTool;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Socket;

/**
 * 可以保持长连接的客户端套接字
 * Created by chauncy on 17-3-18.
 */
public class ClientKeepAliveSocket extends AbstractSocket {
	private static Logger logger = Logger.getLogger(ClientKeepAliveSocket.class);

	public ClientKeepAliveSocket(Socket socket) throws Exception {
		setSocket(socket);
	}

	@Override
	public void setDaemonThread() {
		daemonThread = new DaemonThread(this,
				ClientKeepAliveSocket::disconnectToDo, "Client_Daemon");
	}

	public static void disconnectToDo(AbstractSocket abstractSocket) {
		UtilTool.reConnection(abstractSocket);
	}
}