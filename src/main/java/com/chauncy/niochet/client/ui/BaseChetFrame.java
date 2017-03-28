package com.chauncy.niochet.client.ui;


import javax.swing.*;
import java.awt.*;

import static com.chauncy.niochet.client.ui.uitool.ImageTool.load;


/**
 * 客户端的主要框架
 * Created by chauncy on 17-3-22.
 */
public class BaseChetFrame extends JFrame {
	/**
	 * 自定义的TitleBar
	 */
	protected TitleBar titleBar;
	/**
	 * 设置背景图片
	 */
	protected BackGroundPanel blackGroundPanel;
	/**
	 * 主面板添加其他组件到这里
	 */
	protected JPanel mainPanel;

	public BaseChetFrame(int w, int h) {
		super();
		setIconImage(load("1.jpg").getImage());
		//禁用系统默认的窗口修饰
		this.setUndecorated(true);
		//实用绝对布局
		this.setLayout(null);
		//关闭就退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		titleBar = new TitleBar(this, 0, 0, getWidth(), 30);
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setOpaque(false);
		mainPanel.setBounds(0, 0, getWidth(), getHeight());
		this.add(titleBar);
		this.add(mainPanel);
	}

	public void setBackGroundImage(String url, int w, int h) {
		blackGroundPanel = BackGroundPanel.buildBlackGroundPanel(url, w, h);
		this.getContentPane().add(blackGroundPanel);
	}
}
