package com.chauncy.niochet.client;

import com.chauncy.niochet.entity.User;
import com.chauncy.niochet.entity.UserInfo;
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
			UserInfo userInfo = new UserInfo("114100016", "王冲", "我真帅");
			User user = new User(userInfo.getId(), "pw", userInfo);

			NetMessage netMessage = new NetMessage(NetMessageType.REGISTER, user);
			writeObject(socket, netMessage);
			netMessage = (NetMessage) readObject(socket);
			System.out.println(netMessage);

			Thread.sleep(200000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
