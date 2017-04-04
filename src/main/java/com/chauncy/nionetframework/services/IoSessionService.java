package com.chauncy.nionetframework.services;

import com.chauncy.nionetframework.entity.IoSession;

import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 状态会话 服务
 * 为ip socketChannel 的状态回话提供服务
 * Created by chauncy on 17-3-21.
 */
public class IoSessionService {
	/**
	 * 存储 回话信息的Map,用ip+":"+port作为Key
	 */
	private ConcurrentHashMap<String, IoSession> map = null;

	public IoSessionService() {
		map = new ConcurrentHashMap<>();
	}

	/**
	 * 添加回话
	 *
	 * @param ip            会话的ip
	 * @param port          会话的端口
	 * @param socketChannel 会话的socketChannel
	 * @return 返回生成的StatusSession对象
	 */
	public synchronized IoSession addSession(String ip, int port, SocketChannel socketChannel) {
		IoSession session = new IoSession(ip, port, socketChannel);
		//以ip+port为主键添加
		map.put(key(ip, port), session);
		return session;
	}

	/**
	 * 根据ip地址和端口获取会话
	 *
	 * @param ip   IP地址
	 * @param port 端口
	 * @return 获取到的会话, 如果没有返回null
	 */
	public IoSession getSession(String ip, int port) {
		return map.get(key(ip, port));
	}

	/**
	 * 关闭会话
	 *
	 * @param session 要关闭的会话
	 */
	public void closeSession(IoSession session) {
		closeSession(session.getIp(), session.getPort());
	}

	/**
	 * 关闭会话
	 *
	 * @param ip   要关闭会话的ip地址
	 * @param port 要关闭会话的源端口
	 */
	public void closeSession(String ip, int port) {
		map.remove(key(ip, port));
	}

	/**
	 * 这个地方不安全 暂时不管用 类似友元的办法实现最好
	 *
	 * @return getter map
	 */
	public ConcurrentHashMap<String, IoSession> getMap() {
		return map;
	}

	public String getAll() {
		Iterator<Map.Entry<String,IoSession>> iterator = map.entrySet().iterator();
		StringBuffer sb = new StringBuffer();

		while (iterator.hasNext()){
			Map.Entry<String,IoSession> entry = iterator.next();
			sb.append(entry.getValue().toString());
			sb.append("\n");
		}

		return new String(sb);
	}

	/**
	 * 生成Map的键
	 *
	 * @param ip   IP地址
	 * @param port 端口号
	 * @return 生成的键
	 */
	private String key(String ip, int port) {
		return ip + ":" + port;
	}
}
