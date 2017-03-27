package com.chauncy.niochet;

import com.chauncy.niochet.ui.uitool.parsexml.FrameBuildSession;
import com.chauncy.niochet.ui.uitool.parsexml.FrameFactory;
import org.apache.log4j.PropertyConfigurator;

import javax.swing.*;


/**
 * Created by chauncy on 17-3-20.
 */
public class Test {
	public static void main(String[] args) {
		String url = "com/chauncy/niochet/xml/test.xml";
		FrameBuildSession session = FrameFactory.openSession(url);

		try {
			JFrame jFrame = session.build();
			jFrame.repaint();

			PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
			//NIOSocketThread nioServer = new NIOSocketThread(10000);
			//new Thread(nioServer,"服务器主线程").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
