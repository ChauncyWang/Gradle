package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import javax.swing.*;
import java.awt.*;

/**
 * 组建 JScrollPane
 * Created by chauncy on 17-3-20.
 */
public class ParseScrollPane extends ParseContainer {
	@Override
	public Container parse(Element element) throws Exception {
		JScrollPane jScrollPane = (JScrollPane) super.parse(element);
		String ref = element.attributeValue("ref");
		Component component = components.get(ref);

		if (component == null) {
			throw new Exception("JScrollPane:(ref=" + ref + ")不存在!");
		}
		jScrollPane.setViewportView(component);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		return jScrollPane;
	}
}
