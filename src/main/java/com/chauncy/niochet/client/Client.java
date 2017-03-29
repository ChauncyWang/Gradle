package com.chauncy.niochet.client;

import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;
import com.chauncy.niochet.entity.NetMessageType;
import com.chauncy.niochet.entity.NetMessage;

import java.net.Socket;

import static com.chauncy.util.NetTools.*;

/**
 *
 * Created by chauncy on 17-3-18.
 */
public class Client {
	public Client(String ip, int port) {

		try {
			Socket socket = new Socket(ip, port);

			NetMessage netMessage = new NetMessage(NetMessageType.LOGIN, new String[]{"110","110"});
			writeObject(socket, netMessage);
			netMessage = (NetMessage) readObject(socket);
			System.out.println(netMessage);

			Thread.sleep(200000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
