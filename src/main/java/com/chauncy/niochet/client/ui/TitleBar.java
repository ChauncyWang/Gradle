package com.chauncy.niochet.client.ui;


import com.chauncy.niochet.client.ui.uitool.ImageTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.chauncy.niochet.client.ui.uitool.ImageTool.load;

/**
 * 自定义的标题框
 * Created by chauncy on 17-3-22.
 */
public class TitleBar extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	/**
	 * 最小化按钮
	 */
	private JButton minimizeButton;
	/**
	 * 关闭按钮
	 */
	private JButton closeButton;
	/**
	 * parent框架
	 */
	private JFrame parentFrame;
	/**
	 * 按钮高度
	 */
	private int H;

	public TitleBar(JFrame frame, int x, int y, int width, int height) {
		super();
		H = height;

		this.parentFrame = frame;
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		initUI();
	}

	private void initUI() {
		ImageIcon minIcon = ImageTool.load("minButton.png", H - 5, H - 5);
		ImageIcon closeIcon = ImageTool.load("closeButton.png", H - 5, H - 5);

		minimizeButton = new JButton();
		minimizeButton.setIcon(minIcon);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.setBounds(getWidth() - H * 2, 0, H, H);
		minimizeButton.setActionCommand("minimize");
		minimizeButton.addActionListener(this);

		closeButton = new JButton();
		closeButton.setIcon(closeIcon);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setBounds(getWidth() - H, 0, H, H);
		closeButton.setActionCommand("close");
		closeButton.addActionListener(this);

		this.add(minimizeButton);
		this.add(closeButton);
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.setColor(new Color(0, 0, 0, 127));
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		super.paint(graphics);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		switch (actionEvent.getActionCommand()) {
			case "close":
				System.exit(0);
				break;
			case "minimize":
				//JFrame jFrame = (JFrame)( this.getParent().getParent().getParent());
				parentFrame.setExtendedState(JFrame.ICONIFIED);
				break;
		}
	}

	private Point origin;

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {

	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		origin = new Point(mouseEvent.getX(), mouseEvent.getY());
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		setCursor(new Cursor(Cursor.MOVE_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		Point location = parentFrame.getLocation();
		location = new Point((int) (location.getX() + mouseEvent.getX() - origin.getX()),
				(int) (location.getY() + mouseEvent.getY() - origin.getY()));
		parentFrame.setLocation(location);
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {

	}
}
