package com.chauncy.niochet.client.ui;

import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by chauncy on 17-3-19.
 */
public class GUIPrintStream extends PrintStream {
	private JTextArea jTextArea;
	private StringBuffer sb = new StringBuffer();
	public GUIPrintStream(OutputStream out, JTextArea jTextArea) {
		super(out);
		this.jTextArea = jTextArea;
	}

	@Override
	public void write(byte[] bytes, int i, int i1) {
		String message = new String(bytes,i,i1);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				jTextArea.append(message);
			}
		});
	}
}
