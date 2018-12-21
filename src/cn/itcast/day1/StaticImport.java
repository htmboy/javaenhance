package cn.itcast.day1;

import static java.lang.Math.*; // 静态导入Math下的所有方法
/** 
 * @author aooled-laptop
 *	导入静态类
 */
public class StaticImport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1;
		try {
			x++;
			
		}finally {
			System.out.println("template");
		}
		System.out.println(x);
		System.out.println(Math.max(3, 6)); 
		
		System.out.println(max(3, 6)); // 静态导入
		
		System.out.println(Math.abs(3 - 6));
	}

}
