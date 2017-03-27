package com.chauncy.niochet.server;

import com.chauncy.niochet.ui.GUIPrintStream;
import org.junit.Test;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Created by chauncy on 17-3-19.
 */
public class ServerFrame extends JFrame implements IMessageToUI {
	private JPanel mainPanel;
	private JTextArea msgTextArea;
	private JList userList;
	private JScrollPane jScrollPane;


	public ServerFrame() {
		super();
		NIOSocketThread nioSocketThread = new NIOSocketThread(10000);
		new Thread(nioSocketThread).start();
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		mainPanel.setSize(800, 450);
		mainPanel.setLocation(0, 0);


		msgTextArea = new JTextArea();
		msgTextArea.setLineWrap(true);
		msgTextArea.setDisabledTextColor(Color.RED);
		msgTextArea.setBackground(Color.BLACK);
		msgTextArea.setEnabled(false);
		//msgTextArea.setBorder(new MatteBorder(3, 3, 3, 3, Color.CYAN));

		jScrollPane = new JScrollPane(msgTextArea);
		jScrollPane.setSize(600, 450);
		jScrollPane.setLocation(0, 0);
		jScrollPane.setBorder(new MatteBorder(5, 5, 5, 5, Color.gray));
		mainPanel.add(jScrollPane);

		userList = new JList();
		userList.setSize(200, 450);
		userList.setLocation(600, 0);
		JLabel jLabel = new JLabel("GGGG");
		jLabel.setBackground(Color.GREEN);
		jLabel.setSize(100, 100);
		jLabel.setLocation(0, 0);
		mainPanel.add(userList);

		this.setLayout(null);
		//this.setResizable(false);
		this.setSize(800, 450);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainPanel);

		GUIPrintStream guiPrintStream =
				new GUIPrintStream(System.out, msgTextArea);
		System.setOut(guiPrintStream);
	}

	@Override
	public void add(Session session) {
		DefaultListModel listModel = new DefaultListModel();
		String str = session.getIp() + session.getPort();
		listModel.add(0, str);
		userList.setModel(listModel);
		repaint();
	}
}
