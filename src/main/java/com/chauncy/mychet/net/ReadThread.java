package com.chauncy.mychet.net;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The network read thread
 * Created by chauncy on 17-3-17.
 */
public class ReadThread implements Runnable {
	private Logger logger = Logger.getLogger(ReadThread.class);
	private InputStream is;
	private volatile Queue<NetMessage1> messageQueue = new LinkedList<>();
	private ObjectInputStream ois;
	public ReadThread(ObjectInputStream ois) {
		this.ois = ois;
	}

	public NetMessage1 nextMessage() {
		logger.debug(messageQueue.size());
		return messageQueue.poll();
	}

	@Override
	public void run() {
		logger.info(Thread.currentThread().getName()+" started!");
		while (!Thread.currentThread().isInterrupted()) {
			try {
				NetMessage1 netMessage = (NetMessage1) ois.readObject();
				if (messageQueue.offer(netMessage)) {
					logger.debug("A network message is enter message queue of network read thread...");
				} else {
					logger.warn("Network message queue is full,try later!");
					Thread.sleep(100);
				}
			} catch (IOException | ClassNotFoundException|InterruptedException e) {
				if (Thread.currentThread().isInterrupted()) {
					logger.warn("The network is interrupted!");
				}
				break;
			}
		}
		logger.info(Thread.currentThread().getName()+" stopped");
	}
}
