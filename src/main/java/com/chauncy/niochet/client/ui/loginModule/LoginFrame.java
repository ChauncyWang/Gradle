package com.chauncy.niochet.client.ui.loginModule;

import com.chauncy.niochet.client.ui.BaseChetFrame;
import com.chauncy.niochet.client.ui.HeadImageLabel;
import com.chauncy.nionetframework.entity.NetMessage;
import com.chauncy.nionetframework.entity.NetMessageType;
import com.chauncy.nionetframework.util.NetTools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

/**
 * 登录面板
 * Created by chauncy on 17-3-22.
 */
public class LoginFrame extends BaseChetFrame implements ActionListener {
	private JTextField account;
	private JPasswordField password;
	private JLabel jLabel;
	private JRadioButton rememberPassword;
	private JRadioButton autoLogin;
	private JButton loginButton;
	private JLabel stateLabel;
	private Socket socket;

	public LoginFrame() {
		super(400, 240);
		setBackGroundImage("bg.jpg", 400, 240);

		account = new LoginAccountTextField(150, 80, 180, 30);
		password = new LoginPasswordField(150, 115, 180, 30);

		jLabel = HeadImageLabel.getHeadImageLabel(7);
		jLabel.setBounds(45, 80, 90, 90);

		rememberPassword = new JRadioButton("记住密码");
		rememberPassword.setBounds(150, 150, 85, 25);
		rememberPassword.setOpaque(false);

		autoLogin = new JRadioButton("自动登录");
		autoLogin.setBounds(245, 150, 85, 25);
		autoLogin.setOpaque(false);

		loginButton = new JButton("登录");
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBackground(new Color(0, 116, 255, 127));
		loginButton.setBounds(150, 180, 180, 30);
		loginButton.setActionCommand("login");
		loginButton.addActionListener(this);

		mainPanel.add(account);
		mainPanel.add(password);
		mainPanel.add(jLabel);
		mainPanel.add(rememberPassword);
		mainPanel.add(autoLogin);
		mainPanel.add(loginButton);


		try {
			socket = new Socket("127.0.0.1", 10001);
		} catch (IOException e) {

		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getActionCommand().equals("login")) {
			NetMessage msg = new NetMessage(NetMessageType.LOGIN,
					new Object[] {account.getText(),password.getPassword()});
			try {
				NetTools.writeObject(socket,msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
