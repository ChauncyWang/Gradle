package com.chauncy.niochet.util;

import java.io.*;

/**
 * 将int和byte[] object和byte[]互相转换的工具类
 * Created by chauncy on 17-3-18.
 */
public class ByteArrayTools {
	public static int bytesToInt(byte[] bytes) {
		int value;
		value = (int) ((bytes[0] & 0xFF) | (bytes[1] & 0xFF00) |
				(bytes[2] & 0xFF0000) | (bytes[3] & 0xFF000000));
		return value;
	}

	public static byte[] intToBytes(int i) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (i & 0x000000FF);
		bytes[1] = (byte) ((i & 0x0000FF00) >> 8);
		bytes[2] = (byte) ((i & 0x00FF0000) >> 16);
		bytes[3] = (byte) ((i & 0xFF000000) >> 24);
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
