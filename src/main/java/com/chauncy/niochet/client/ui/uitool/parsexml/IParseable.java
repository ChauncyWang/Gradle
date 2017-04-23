package com.chauncy.niochet.client.ui.uitool.parsexml;

import org.dom4j.Element;

import java.awt.*;

/**
 * Created by chauncy on 17-3-20.
 */
public interface IParseable {
	public Container parse(Element element) throws Exception;
}
