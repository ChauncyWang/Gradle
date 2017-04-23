package com.chauncy.niochet.client.ui.uitool.parsexml;

import static com.chauncy.nionetframework.util.Dom4lTool.getRoot;

/**
 * Created by chauncy on 17-3-20.
 */
public class FrameFactory {
	public static FrameBuildSession openSession(String url) {
		return new FrameBuildSession(getRoot(url));
	}
}
