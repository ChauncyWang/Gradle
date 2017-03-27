package com.chauncy.mychet.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by chauncy on 17-3-17.
 */
public class LoginFrame extends JFrame {
	public LoginFrame() {
		super();
		this.setSize(400,200);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)size.getWidth()/3,(int)size.getHeight()/3);
		this.setResizable(false);
		this.add(new LoginJPanel());
	}
}
