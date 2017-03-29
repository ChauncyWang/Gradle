package com.chauncy.niochet.server;

import com.chauncy.niochet.server.actions.MessageActions;
import com.chauncy.niochet.entity.NetMessageType;
import org.apache.log4j.Logger;

/**
 * 消息处理线程
 * Created by chauncy on 17-3-19.
 */
public class MessageHandlerThread implements Runnable {
    private Logger logger = Logger.getLogger(MessageHandlerThread.class);
    /**
     * 处理nio select 的对象,从其中得到 nio 的消息队列取出来进行 消息处理
     */
    private volatile SelectHandlerImpl dealHandler = null;

    private static MessageActions actions = new MessageActions();

    /**
     * 唯一的构造函数
     *
     * @param dealHandler 处理select的对象
     */
    public MessageHandlerThread(SelectHandlerImpl dealHandler) {
        this.dealHandler = dealHandler;
    }

    @Override
    public void run() {
        MessageQueue receives = dealHandler.getReceives();
        while (true) {
            if (receives.getSize() != 0) {
                try {
                    MessageNode node = receives.dequeue();
                    logger.info(String.format("开始处理[%s:%d]的消息:[%s]", node.getIp(), node.getPort(), node.getMessage()));
                    actions.getAction(node.getMessage().what).execute(node);
                    logger.info(String.format("处理完成[%s:%d]的消息:[%s]", node.getIp(), node.getPort(), node.getMessage()));
                } catch (Exception e) {
                    logger.warn(e);
                }
            }
        }
    }
}
