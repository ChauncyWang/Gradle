package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import javax.swing.*;
import java.awt.*;

/**
 * 组建 JPanel
 * Created by chauncy on 17-3-20.
 */
public class ParsePanel extends ParseContainer {
	@Override
	public Container parse(Element element) throws Exception {
		JPanel jPanel = (JPanel) super.parse(element);


		jPanel.setLayout(null);
		return jPanel;
	}
}
