package com.chauncy.niochet.client.ui.loginModule;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * 登陆界面的输入监听
 * Created by chauncy on 17-3-23.
 */
public class LoginInputFocusListener implements FocusListener {
    /**
     * 输入框默认显示的 字符串
     */
    private String defaultText;
    /**
     * 监听对象
     */
    private JTextField textField;

    public LoginInputFocusListener(JTextField jTextField, String defaultText) {
        this.textField = jTextField;
        this.defaultText = defaultText;
        //如果是密码框,先不设置回显
        if (textField instanceof JPasswordField) {
            JPasswordField jPasswordField = (JPasswordField) textField;
            jPasswordField.setEchoChar((char) 0);
        }
        textField.setText(defaultText);

        Font font = new Font("宋体", Font.BOLD, 16);
        textField.setFont(font);
        textField.setForeground(new Color(0, 216, 255));
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        textField.setBorder(new LineBorder(new Color(255, 0, 142, 255), 3));
        if (textField.getText().equals(defaultText)) {
            textField.setText("");
            if (textField instanceof JPasswordField) {
                JPasswordField jPasswordField = (JPasswordField) textField;
                jPasswordField.setEchoChar('●');
            }
        }
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        textField.setBorder(null);
        if (textField.getText() == null || textField.getText().equals("")) {
            textField.setText(defaultText);
            if (textField instanceof JPasswordField) {
                JPasswordField jPasswordField = (JPasswordField) textField;
                jPasswordField.setEchoChar((char) 0);
            }
        }
    }

    public void paint(Graphics graphics) {
        graphics.setColor(new Color(55, 55, 55, 150));
        graphics.fillRect(0, 0, textField.getWidth(), textField.getHeight());
    }
}
