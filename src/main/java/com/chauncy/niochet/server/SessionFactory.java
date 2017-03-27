package com.chauncy.niochet.server;

import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 会话工厂
 * Created by chauncy on 17-3-21.
 */
public class SessionFactory {
	private ConcurrentHashMap<String, Session> map = null;

	public SessionFactory() {
		map = new ConcurrentHashMap<>();
	}

	public synchronized Session openSession(String ip, int port, SocketChannel socketChannel) {
		Session session = new Session(ip, port, socketChannel, 0);
		map.put(ip + port, session);
		return session;
	}

	public Session getSession(String ip, int port) {
		return map.get(ip + port);
	}

	public void closeSession(Session session) {
		map.remove(session.getIp() + session.getPort());
	}

	public ConcurrentHashMap<String, Session> getMap() {
		return map;
	}
}
