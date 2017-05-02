package com.chauncy.niochet.client.ui.loginModule;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chauncy on 17-3-23.
 */
public class LoginPasswordField extends JPasswordField {
	private LoginInputFocusListener loginInputFocusListener;

	public LoginPasswordField(int x, int y, int w, int h) {
		super();
		this.setOpaque(false);
		this.setBounds(x, y, w, h);
		loginInputFocusListener = new LoginInputFocusListener(this, "请输入密码");
		this.addFocusListener(loginInputFocusListener);
	}

	@Override
	public void paint(Graphics graphics) {
		loginInputFocusListener.paint(graphics);
		super.paint(graphics);
	}
}
