package com.chauncy.nionetframework.event;

import com.chauncy.nionetframework.services.MessageQueueService;
import com.chauncy.nionetframework.services.IoSessionService;

import java.nio.channels.SelectionKey;

/**
 * 选择起准备就绪时触发事件,传递的事件
 * Created by chauncy on 17-4-4.
 */
public class SelectEvent {
	private MessageQueueService mq;
	private IoSessionService session;
	private SelectionKey readyKey;


	public SelectEvent() {
	}

	public SelectEvent(MessageQueueService mq, IoSessionService session, SelectionKey readyKey) {
		this.mq = mq;
		this.session = session;
		this.readyKey = readyKey;
	}

	public MessageQueueService getMq() {
		return mq;
	}

	public void setMq(MessageQueueService mq) {
		this.mq = mq;
	}

	public IoSessionService getSession() {
		return session;
	}

	public void setSession(IoSessionService session) {
		this.session = session;
	}

	public SelectionKey getReadyKey() {
		return readyKey;
	}

	public void setReadyKey(SelectionKey readyKey) {
		this.readyKey = readyKey;
	}
}
