package com.chauncy.nionetframework.entity;

import java.io.Serializable;

/**
 * The message what socket send
 * Created by chauncy on 17-3-17.
 */
public class NetMessage implements Serializable {
	public NetMessageType what;//message type
	public Object obj;//Carry information

	public NetMessage() {
	}

	public NetMessage(NetMessageType what, Object obj) {
		this.what = what;
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "NetMessage1{" +
				"what=" + what +
				", obj=" + obj +
				'}';
	}

	/**
	 * Get a message with no object
	 *
	 * @return the null message
	 */
	public static NetMessage getNullMessage() {
		return new NetMessage(NetMessageType.NULL, null);
	}
}
