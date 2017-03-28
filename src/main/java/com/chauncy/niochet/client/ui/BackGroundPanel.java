package com.chauncy.niochet.client.ui;

import com.chauncy.niochet.client.ui.uitool.ImageTool;

import javax.swing.*;
import java.awt.*;

/**
 * 做背景 用的Panel
 * Created by chauncy on 17-3-22.
 */
public class BackGroundPanel extends JPanel {
	private Image image;

	/**
	 * 根据位置 或是生成一个背景panel 宽x,高h
	 *
	 * @param url 位置
	 * @param w   宽
	 * @param h   高
	 * @return
	 */
	public static BackGroundPanel buildBlackGroundPanel(String url, int w, int h) {
		Image image = ImageTool.load(url).getImage();
		return new BackGroundPanel(image, w, h);
	}

	private BackGroundPanel(Image image, int w, int h) {
		this.image = image;
		//实用绝对布局
		this.setLayout(null);
		//不透明透明
		this.setOpaque(false);
		//设置大小
		this.setSize(w, h);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
