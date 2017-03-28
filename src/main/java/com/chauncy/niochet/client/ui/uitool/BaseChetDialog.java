package com.chauncy.niochet.client.ui.uitool;

import com.chauncy.niochet.client.ui.BackGroundPanel;

import javax.swing.*;
import java.awt.*;

import static com.chauncy.niochet.client.ui.uitool.ImageTool.load;

/**
 * 所有
 * Created by chauncy on 17-3-26.
 */
public class BaseChetDialog extends JDialog {
	/**
	 * 自定义背景
	 */
	private BackGroundPanel backGroundPanel;
	/**
	 * 主面板 添加其他组件到这里
	 */
	private JPanel mainPanel;

	public BaseChetDialog(int w, int h) {
		super();
		//实用绝对布局
		this.setLayout(null);
		//居中显示
		this.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
		//设置大小
		this.setSize(w, h);
		//禁止修改大小
		this.setResizable(false);

		initUI();

		//AWTUtilities.setWindowOpaque(this,false);
	}

	private void initUI() {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setOpaque(false);
		mainPanel.setBounds(0, 0, getWidth(), getHeight());
		this.add(mainPanel);
	}

	public void setBackGroundImage(String url, int w, int h) {
		backGroundPanel = BackGroundPanel.buildBlackGroundPanel(url, w, h);
		this.getContentPane().add(backGroundPanel);
	}
}
