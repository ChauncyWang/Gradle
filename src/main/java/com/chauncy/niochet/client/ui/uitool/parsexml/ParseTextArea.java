package com.chauncy.niochet.client.ui.uitool.parsexml;

import com.chauncy.niochet.client.ui.GUIPrintStream;
import org.dom4j.Element;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

/**
 * 组建 JTextArea
 * Created by chauncy on 17-3-20.
 */
public class ParseTextArea extends ParseTextComponent {
	@Override
	public Container parse(Element element) throws Exception {
		JTextArea jTextArea = (JTextArea) super.parse(element);

		//获取JTextArea特有属性
		String var1 = element.attributeValue("columns");
		String var2 = element.attributeValue("rows");
		String var3 = element.attributeValue("lineWrap");
		String var4 = element.attributeValue("wrapStyleWoed");

		//将JTextArea特有属性进行包装
		if (var1 != null)
			jTextArea.setColumns(Integer.parseInt(var1));
		if (var2 != null)
			jTextArea.setRows(Integer.parseInt(var2));
		if (var3 != null)
			jTextArea.setLineWrap(Boolean.parseBoolean(var3));
		if (var4 != null)
			jTextArea.setWrapStyleWord(Boolean.parseBoolean(var4));

		PrintStream ps = new GUIPrintStream(System.out,jTextArea);
		System.setOut(ps);

		return jTextArea;
	}
}
