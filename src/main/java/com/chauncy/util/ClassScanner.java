package com.chauncy.util;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 扫描某包下的所有类
 * Created by chauncy on 17-3-29.
 */
public class ClassScanner {
	public static Set<Class<?>> getClasses(String pack) {
		//Class类的集合
		Set<Class<?>> classes = new LinkedHashSet<>();
		//对包名进行替换
		String packageDir = pack.replace('.', '/');
		//定义一个枚举集合,并进行循环处理这个目录下的things
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader()
					.getResources(packageDir);

			//查看每一个元素
			while (dirs.hasMoreElements()) {
				//获取下一个元素
				URL url = dirs.nextElement();
				//得到协议名称
				String protocol = url.getProtocol();

				System.out.println(protocol + ":" + url.getFile());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes;
	}
}
