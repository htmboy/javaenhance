package cn.itcast.day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String scrPath = args[0];
		String destPath = args[1];
		FileInputStream fis = new FileInputStream(scrPath);
		FileOutputStream fos = new FileOutputStream(destPath);
		cypher(fis, fos);
		fis.close();
		fos.close();
	}
	
	private static void cypher(InputStream ips, OutputStream ops) throws Exception {
		int b = -1;
		while((b = ips.read()) != -1) {
			ops.write(b ^ 0xff);
		}
	}
	
	private String classDir;
	
	@Override
	protected Class<?> findClass(String name) throws Exception{
		String classFileName = classDir + "\\" + name + ".class";
		FileInputStream fis = new FileInputStream(classFileName);
		return super.findClass(name);
	}

}
