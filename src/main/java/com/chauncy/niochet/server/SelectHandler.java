package com.chauncy.niochet.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * 处理已经准备好的SelectionKey的接口
 * 处理 网络连接 NIO 的各种状态
 * Created by chauncy on 17-3-18.
 */
public interface SelectHandler {
	/**
	 * 处理准备的 Socket 的 accept()
	 *
	 * @param selectionKey 准备好的 SelectionKey
	 */
	void acceptHandle(SelectionKey selectionKey);

	/**
	 * 处理准备的 Socket 的 read()
	 *
	 * @param selectionKey 准备好的 SelectionKey
	 */
	void readHandle(SelectionKey selectionKey);

	/**
	 * 处理准备的 Socket 的 write()
	 *
	 * @param selectionKey 准备好的 SelectionKey
	 */
	//void writeHandle(SelectionKey selectionKey);

}
