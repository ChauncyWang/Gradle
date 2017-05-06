package cc.chauncy.hoi4.tools;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载资源
 * Created by Chauncy on 2017/5/6.
 */
public class ResourcesTools {
	private static Map modifiers = new HashMap();
	private static String modifiersFile = "res/modifiers.txt";
	public static void load() {
		loadModifiers();
	}

	private static void loadModifiers() {
		File file = new File(modifiersFile);
		System.out.println(file.getAbsolutePath());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] strs = line.split(" ");
				modifiers.put(strs[0],strs[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Map getModifiers() {
		return modifiers;
	}
}
