package com.chauncy.niochet.client;

import com.chauncy.niochet.util.NetMessageType;
import com.chauncy.niochet.util.NetMessage;

import java.io.IOException;
import java.net.Socket;

import static com.chauncy.niochet.util.NetTools.*;

/**
 * Created by chauncy on 17-3-18.
 */
public class Client {
	public Client(String ip, int port) {

		try {
			Socket socket = new Socket(ip, port);
			NetMessage netMessage = new NetMessage(NetMessageType.LOGIN, "登陆信息");
			writeObject(socket, netMessage);
			netMessage = new NetMessage(NetMessageType.LOGIN, "登陆信息");
			writeObject(socket, netMessage);
			netMessage = new NetMessage(NetMessageType.LOGIN, "登陆信息");
			writeObject(socket, netMessage);
			netMessage = new NetMessage(NetMessageType.LOGIN, "登陆信息");
			writeObject(socket, netMessage);

			Thread.sleep(200000);
		} catch (IOException e) {
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
