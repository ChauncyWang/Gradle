package com.chauncy.niochet.client.ui.loginModule;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义账号输入框
 * Created by chauncy on 17-3-22.
 */
public class LoginAccountTextField extends JTextField {
	private LoginInputFocusListener loginInputFocusListener;

	public LoginAccountTextField(int x, int y, int w, int h) {
		super();
		this.setOpaque(false);
		this.setBounds(x, y, w, h);
		loginInputFocusListener = new LoginInputFocusListener(this, "请输入账号");
		this.addFocusListener(loginInputFocusListener);
	}

	@Override
	public void paint(Graphics graphics) {
		loginInputFocusListener.paint(graphics);
		super.paint(graphics);
	}
}
