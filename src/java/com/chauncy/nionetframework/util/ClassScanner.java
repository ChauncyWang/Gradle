package com.chauncy.nionetframework.util;

import java.io.File;
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
				// 如果是以文件的形式保存
				if ("file".equals(protocol)) {
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					findAndAddClassesInPackageByFile(
							pack, filePath, classes);
				} else if ("jar".equals(protocol)) {
					// 如果是jar包文件
					findAndAddClassesInPackageByJar(
							packageDir, url, classes);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes;
	}

	private static void findAndAddClassesInPackageByFile(
			String packageName, String packagePath, Set<Class<?>> classes) {
		//获取此包的目录,建立一个File
		File dir = new File(packagePath);

		//如果文件不存在 或是 不是目录
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}

		File[] dirfiles = dir.listFiles(file ->
				file.isDirectory() || (file.getName().endsWith(".class")));

		for (File file : dirfiles) {
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(
						packageName + "." + file.getName(),
						file.getAbsolutePath(), classes);
			} else {
				String className = file.getName()
						.substring(0, file.getName().length() - 6);

				try {
					classes.add(Thread.currentThread().getContextClassLoader()
							.loadClass(packageName+"."+className));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void findAndAddClassesInPackageByJar(
			String packageDir, URL url, Set<Class<?>> classes) {
		JarFile jar;
		try {
			// 获取jar
			jar = ((JarURLConnection) url.openConnection()).getJarFile();
			Enumeration<JarEntry> entries = jar.entries();

			while (entries.hasMoreElements()) {
				JarEntry entry = entries.nextElement();
				String name = entry.getName();
				//以'/'开头
				if (name.charAt(0) == '/') {
					name = name.substring(1);
				}
				if (name.startsWith(packageDir)) {
					int index = name.lastIndexOf('/');
					if (index != -1) {
						if (name.endsWith(".class") && !entry.isDirectory()) {
							String className = name.substring(
									packageDir.length() + 1,
									name.length() - 6);
							try {
								classes.add(Thread.currentThread().getContextClassLoader()
										.loadClass(className));
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

		} catch (IOException e) {
			//获取jar失败
			e.printStackTrace();
		}
	}
}

