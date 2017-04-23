package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import javax.swing.*;
import java.awt.*;

/**
 * 组建 JLabel 组件
 * Created by chauncy on 17-3-20.
 */
public class ParseLabel extends ParseContainer {
	@Override
	public Container parse(Element element) throws Exception {
		JLabel jLabel = (JLabel) super.parse(element);

		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("com/chauncy/niochet/client/ui/res/1.jpg"));
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		jLabel.setIcon(imageIcon);

		return jLabel;
	}
}
