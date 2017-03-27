package com.chauncy.mychet.net;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by chauncy on 17-3-18.
 */
public abstract class AbstractSocket {
	private Logger logger = Logger.getLogger(AbstractSocket.class);
	protected Socket socket;
	protected Thread daemonThread;//守护线程，对客户端和服务端做不同的事情
	protected ReadThread readRunnable;//读取线程的Runnable对象
	protected Thread readThread;//读取线程
	protected SendTool sendTool;//发送工具
	protected ObjectInputStream ois;//对象输入流
	protected ObjectOutputStream oos;//对象输出流

	public void setSocket(Socket socket) throws Exception {
		this.socket = socket;
		if (socket != null && socket.isConnected()) {
			logger.warn("The socket is stall connected,changing socket...");
		}
		init();
	}

	private void init() throws Exception {
		if (socket != null) {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			readRunnable = new ReadThread(ois);
			readThread = new Thread(readRunnable,Thread.currentThread().getName()+"_Read");
			sendTool = new SendTool(oos);
			setDaemonThread();
		} else {
			throw new Exception("the socket is not exist!");
		}
		start();
	}

	public void start() {
		readThread.start();
		daemonThread.start();
	}

	public ReadThread getReadRunnable() {
		return readRunnable;
	}

	public SendTool getSendTool() {
		return sendTool;
	}

	public abstract void setDaemonThread();

	public void destroy() {
		readThread.interrupt();
		daemonThread.interrupt();
		try {
			oos.close();
			ois.close();
		} catch (IOException ignored) {

		}
		logger.info(socket.getInetAddress().getHostName() + "[" + socket.getPort() + "] disconnection!");
	}
}
