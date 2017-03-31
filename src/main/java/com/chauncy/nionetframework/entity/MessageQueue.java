package com.chauncy.nionetframework.entity;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 消息队列 (原子操作)
 * Created by chauncy on 17-3-19.
 */
public class MessageQueue extends ConcurrentLinkedQueue<MessageNode> {
}