package com.chauncy.nionetframework.event;


/**
 * 处理已经准备好的SelectionKey的接口
 * 处理 网络连接 NIO 的各种状态
 * Created by chauncy on 17-3-18.
 */
public interface SelectListener {
	/**
	 * 处理准备的 Socket 的 accept()
	 *
	 * @param event 事件消息
	 */
	void accept(SelectEvent event);

	/**
	 * 处理准备的 Socket 的 read()
	 *
	 * @param event 事件消息
	 */
	void read(SelectEvent event);

	/**
	 * 处理准备的 Socket 的 write()
	 *
	 * @param selectionKey 准备好的 SelectionKey
	 */
	//void writeHandle(SelectionKey selectionKey);

}
