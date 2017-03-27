package com.chauncy.niochet.util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.swing.*;

/**
 * Created by chauncy on 17-3-19.
 */
public class Dom4lTool {
	private static Logger logger = Logger.getLogger(Dom4lTool.class);

	public static Element getRoot(String url) {
		//String url = "com/chauncy/niochet/xml/test.xml";
		Element root = null;
		try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(url)) {
			//创建SAXReader读取器,专门读取xml
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(inputStream);

			//获取根节点
			root = document.getRootElement();
		} catch (Exception e) {
			logger.warn(e);
		}
		return root;
	}
}
