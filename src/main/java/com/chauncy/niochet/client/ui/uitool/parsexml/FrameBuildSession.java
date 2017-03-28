package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by chauncy on 17-3-20.
 */
public class FrameBuildSession {
	private Element root = null;
	private static Map<String, IParseable> parses = new HashMap<>();

	FrameBuildSession(Element root) {
		this.root = root;

		parses.put("JTextComponent", new ParseTextComponent());
		parses.put("JTextArea", new ParseTextArea());
		parses.put("JScrollPane", new ParseScrollPane());
		parses.put("JPanel", new ParsePanel());
		parses.put("JLabel", new ParseLabel());
		parses.put("JFrame", new ParseFrame());
		parses.put("JButton", new ParseButton());
		parses.put("JTextField", new ParseTextField());
	}

	public JFrame build() throws Exception {
		JFrame jFrame = null;
		if (root != null) {
			if (!root.getName().equals("JFrame")) {
				throw new Exception("根元素+<" + root.getName() + ">不是<JFrame>...");
			} else {
				jFrame = (JFrame) parse(root);
			}
		}
		return jFrame;
	}

	/**
	 * 从节点中提取一个 Container 并进行递归
	 *
	 * @param element 要读取的节点
	 * @return 读取到的component, 没读到返回空值
	 */
	private Container parse(Element element) throws Exception {
		Container container;
		String name = element.getName();

		IParseable iParseable = parses.get(name);

		container = iParseable.parse(element);

		//进行迭代,找出所有容器中的控件
		Iterator iterator = element.elementIterator();
		while (iterator.hasNext()) {
			Element e = (Element) iterator.next();
			Container sub = parse(e);
			if (sub != null) {
				String child = e.attributeValue("child");
				if(child==null || Boolean.getBoolean(child)) {
					container.add(sub);
				}
				sub.repaint();
			}
		}

		container.repaint();
		return container;
	}
}
