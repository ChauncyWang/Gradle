package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 组装 Container 组件
 * Created by chauncy on 17-3-20.
 */
public class ParseContainer implements IParseable {
	public static Map<String, Container> components = new HashMap<>();

	@Override
	public Container parse(Element element) throws Exception {
		Container container = null;
		Class<?> clazz = null;
		//得到全类名
		String name = "javax.swing." + element.getName();
		//生成新控件
		clazz = Class.forName(name);
		container = (Container) clazz.newInstance();

		if (!(container instanceof JScrollPane))
			container.setLayout(null);
		//获取各种属性
		String x = element.attributeValue("x");
		String y = element.attributeValue("y");
		String width = element.attributeValue("width");
		String height = element.attributeValue("height");
		String visible = element.attributeValue("visible");
		String enabled = element.attributeValue("enabled");
		String background = element.attributeValue("background");
		String foreground = element.attributeValue("foreground");

		//组装各种属性
		if (x != null && y != null) {
			container.setLocation(Integer.parseInt(x), Integer.parseInt(y));
		}
		if (width != null && height != null) {
			container.setSize(Integer.parseInt(width), Integer.parseInt(height));
		}
		if (visible != null) {
			container.setVisible(Boolean.parseBoolean(visible));
		} else {
			//默认显示
			container.setVisible(true);
		}
		if (enabled != null) {
			container.setEnabled(Boolean.parseBoolean(enabled));
		}
		if (background != null) {
			Color color = new Color(Integer.parseInt(background, 16));
			container.setBackground(color);
		}
		if (foreground != null) {
			Color color = new Color(Integer.parseInt(foreground, 16));
			container.setForeground(color);
		}

		//System.out.println(String.format("添加组件%s[%d,%d,%d,%d]", element.getName(),
		//		container.getX(), container.getY(),
		//		container.getWidth(), container.getHeight()));

		components.put(element.attributeValue("id"), container);

		return container;
	}
}
