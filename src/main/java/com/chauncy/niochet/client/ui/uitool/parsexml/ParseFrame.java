package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import javax.swing.*;
import java.awt.*;

/**
 * 组装 JFrame 组件
 * Created by chauncy on 17-3-20.
 */
public class ParseFrame extends ParseContainer {
	@Override
	public Container parse(Element element) throws Exception {
		JFrame jFrame = (JFrame) super.parse(element);
		String resizable = element.attributeValue("resizable");
		if (resizable != null)
			jFrame.setResizable(Boolean.getBoolean(resizable));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		return jFrame;
	}
}
