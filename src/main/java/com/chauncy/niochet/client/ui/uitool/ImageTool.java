package com.chauncy.niochet.client.ui.uitool;

import javax.swing.*;
import java.awt.*;

/**
 * 图像处理工具
 * Created by chauncy on 17-3-23.
 */
public class ImageTool {
	/**
	 * 加载图片
	 *
	 * @param url
	 * @return
	 */
	public static ImageIcon load(String url) {
		String dir = "com/chauncy/niochet/client/ui/res/";
		url = dir + url;
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource(url));

		return imageIcon;
	}

	/**
	 * 加载图片
	 * @param url
	 * @param w
	 * @param h
	 * @return
	 */
	public static ImageIcon load(String url, int w, int h) {
		ImageIcon imageIcon = load(url);
		Image image = imageIcon.getImage().getScaledInstance(w, h, Image.SCALE_AREA_AVERAGING);

		return new ImageIcon(image);
	}
}
