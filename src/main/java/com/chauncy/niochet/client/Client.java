package com.chauncy.niochet.client;

import com.chauncy.nionetframework.entity.NetMessageType;
import com.chauncy.nionetframework.entity.NetMessage;

import java.net.Socket;

import static com.chauncy.nionetframework.util.NetTools.*;

/**
 *
 * Created by chauncy on 17-3-18.
 */
public class Client {
	public Client(String ip, int port) {

		try {
			Socket socket = new Socket(ip, port);

			while(true) {
				NetMessage netMessage = new NetMessage(NetMessageType.LOGIN, new String[]{"110", "110"});
				System.out.println(System.currentTimeMillis());
				writeObject(socket, netMessage);
				netMessage = (NetMessage) readObject(socket);
				System.out.println(netMessage);
				System.out.println(System.currentTimeMillis());

				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
