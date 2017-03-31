package com.chauncy.nionetframework.util;

import java.io.*;

/**
 * 将int和byte[] object和byte[]互相转换的工具类
 * Created by chauncy on 17-3-18.
 */
public class ByteArrayTools {
	public static int bytesToInt(byte[] bytes) {
		int value = 0;
		//由高位到低位
		for (int i = 0; i < 4; i++) {
			int shift = i * 8;
			value += (bytes[i] & 0x000000FF) << shift;//往高位游
		}
		return value;
	}

	public static byte[] intToBytes(int i) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (i & 0xFF);
		bytes[1] = (byte) ((i >> 8) & 0xFF);
		bytes[2] = (byte) ((i >> 16) & 0xFF);
		bytes[3] = (byte) ((i >> 24) & 0xFF);
		return bytes;
	}

	public static Object bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException {
		Object obj = null;
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		obj = ois.readObject();

		bais.close();
		ois.close();

		return obj;
	}

	public static byte[] objectToBytes(Object o) throws IOException {
		byte[] bytes = null;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.flush();
		baos.flush();
		bytes = baos.toByteArray();

		baos.close();
		oos.close();

		return bytes;
	}
}
