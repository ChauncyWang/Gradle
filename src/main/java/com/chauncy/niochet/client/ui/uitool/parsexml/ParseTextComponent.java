package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import javax.swing.text.JTextComponent;
import java.awt.*;

/**
 * 组装 JTextComponent 组件
 * Created by chauncy on 17-3-20.
 */
public class ParseTextComponent extends ParseContainer {
	@Override
	public Container parse(Element element) throws Exception {
		JTextComponent jTextComponent = (JTextComponent) super.parse(element);

		String var1 = element.attributeValue("text");
		String var2 = element.attributeValue("selectedTextColor");
		String var3 = element.attributeValue("selectionColor");
		String var4 = element.attributeValue("disabledTextColor");

		jTextComponent.setText(var1);
		if (var2 != null)
			jTextComponent.setSelectedTextColor(new Color(Integer.parseInt(var2, 16)));
		if (var3 != null)
			jTextComponent.setSelectionColor(new Color(Integer.parseInt(var3, 16)));
		if (var4 != null)
			jTextComponent.setDisabledTextColor(new Color(Integer.parseInt(var4, 16)));

		return jTextComponent;
	}
}
