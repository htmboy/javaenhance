package cn.itcast.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;

public class ReflectTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//		InputStream ips = new FileInputStream("config.properties");
		// InputStream ips = ReflectTest2.class.getClassLoader().getResourceAsStream("cn/itcast/day1/config.properties");
		InputStream ips = ReflectTest2.class.getResourceAsStream("config.properties");
		Properties props = new Properties();
		props.load(ips);
		ips.close();
		String className = props.getProperty("className");
		Collection collections = (Collection) Class.forName(className).getConstructor().newInstance();
		
		// Collection collections = new ArrayList(); // 4
		// Collection collections = new HashSet(); // 3
		
		ReflectPoint pt1 = new ReflectPoint(3, 3);
		ReflectPoint pt2 = new ReflectPoint(5, 5);
		ReflectPoint pt3 = new ReflectPoint(3, 3);
		collections.add(pt1);
		collections.add(pt2);
		collections.add(pt3);
		collections.add(pt1);
		
		// pt1.y = 7; // y值更改, 导致hashcode值改变
		collections.remove(pt1); // pt1 的hashcode值找不到, 以致删不了
		// 所以, 对象频繁的修改, 导致出现内存泄露
		
		System.out.println(collections.size());
		
		// 反射的作用 -> 实现框架功能
	}

}
