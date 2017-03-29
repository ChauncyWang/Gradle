package com.chauncy.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import static com.chauncy.util.ByteArrayTools.*;

/**
 * 在socket通道中帮助读取和写入对象的类
 * Created by chauncy on 17-3-18.
 */
public class NetTools {

	/**
	 * 从套接字中读取一个对象
	 *
	 * @param socket 要读取的套接字
	 * @return 读取到的对象
	 * @throws IOException 发生IO错误
	 */
	public static Object readObject(Socket socket) throws IOException, ClassNotFoundException {
		InputStream is = socket.getInputStream();
		byte[] lengths = new byte[4];
		is.read(lengths);
		int length = bytesToInt(lengths);
		byte[] objs = new byte[length];
		is.read(objs);
		return bytesToObject(objs);
	}

	/**
	 * 向套接字中写入一个对象
	 *
	 * @param socket 要写入的套接字
	 * @throws IOException 发生IO错误
	 */
	public static void writeObject(Socket socket, Object object) throws IOException {
		OutputStream os = socket.getOutputStream();
		byte[] objects = objectToBytes(object);
		byte[] length = intToBytes(objects.length);
		os.write(length);
		os.write(objects);

		os.flush();
	}


	/**
	 * 从管道中读取一个对象
	 *
	 * @param socketChannel 管道
	 * @throws IOException 发生IO错误
	 * @return读取的对象
	 */
	public static Object readObject(SocketChannel socketChannel) throws IOException, ClassNotFoundException {
		ByteBuffer bb = ByteBuffer.allocate(4);
		socketChannel.read(bb);
		int length = bytesToInt(bb.array());
		bb = ByteBuffer.allocate(length);
		while (bb.hasRemaining()) {
			socketChannel.read(bb);
		}
		Object obj = bytesToObject(bb.array());
		return obj;
	}

	/**
	 * 向通道中写入对象
	 *
	 * @param socketChannel 管道
	 * @param obj           要写入的对象
	 * @throws IOException 出现IO错误
	 */
	public static void writeObject(SocketChannel socketChannel, Object obj) throws IOException {
		byte[] bytes = objectToBytes(obj);
		int length = bytes.length;
		byte[] lengths = intToBytes(length);
		ByteBuffer bb = ByteBuffer.allocate(length + 4).put(lengths).put(bytes);
		bb.flip();
		while (bb.hasRemaining()) {
			socketChannel.write(bb);
		}
	}
}