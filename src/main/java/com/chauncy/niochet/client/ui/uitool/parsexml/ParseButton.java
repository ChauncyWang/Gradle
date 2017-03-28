package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import javax.swing.*;
import java.awt.*;

/**
 * 组装 JButton 组件
 * Created by chauncy on 17-3-20.
 */
public class ParseButton extends ParseContainer {
	@Override
	public Container parse(Element element) throws Exception {
		JButton jButton = (JButton) super.parse(element);

		jButton.setText(element.attributeValue("text"));

		return jButton;
	}
}
