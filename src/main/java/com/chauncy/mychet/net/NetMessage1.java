package com.chauncy.mychet.net;

import java.io.Serializable;

/**
 * The message what socket send
 * Created by chauncy on 17-3-17.
 */
public class NetMessage1 implements Serializable{
	public int what;//message type
	public Object obj;//Carry information

	public NetMessage1() {
	}

	public NetMessage1(int what, Object obj) {
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
	 * @return the null message
	 */
	public static NetMessage1 getNullMessage() {
		return new NetMessage1(NetMessageType1.NULL,null);
	}
}
