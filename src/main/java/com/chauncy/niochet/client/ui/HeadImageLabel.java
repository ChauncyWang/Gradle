package com.chauncy.niochet.client.ui;

import com.chauncy.niochet.client.ui.uitool.ImageTool;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import static com.chauncy.niochet.client.ui.uitool.ImageTool.load;

/**
 * Created by chauncy on 17-3-23.
 */
public class HeadImageLabel extends JLabel {
	private static HeadImageLabel[] heads;

	static {
		heads = new HeadImageLabel[10];
		for (int i = 1; i <= 10; ++i) {
			String url = String.format("headImages/head%d.jpg", i);
			ImageIcon imageIcon = ImageTool.load(url,90,90);
			heads[i - 1] = new HeadImageLabel(imageIcon);
		}
	}

	public static JLabel getHeadImageLabel(int index) {
		if (index <= 0 || index > 16) {
			index = 0;
		}
		return heads[index];
	}

	private HeadImageLabel(ImageIcon imageIcon) {
		super(imageIcon);
	}

	@Override
	public void paint(Graphics graphics) {
		//super.paint(graphics);

		graphics.setColor(new Color(7, 255, 0, 120));
		graphics.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
		RoundRectangle2D rect = new RoundRectangle2D.Double(2, 2, getWidth() - 4, getHeight() - 4, 20, 20);
		graphics.setClip(rect);
		graphics.drawImage(((ImageIcon) getIcon()).getImage(), 2, 2, getWidth() - 4, getHeight() - 4, this);
	}
}
