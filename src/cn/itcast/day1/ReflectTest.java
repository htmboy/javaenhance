package cn.itcast.day1;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 指向同一份字节码
		
		//有三种, 
		// 1, 类.class
		// 2, Obj.getClass()
		// 3, Class.forName() 反射主要用这种
		
		String str1 = "abc";
		Class cls1 = str1.getClass();
		Class cls2 = String.class;
		Class cls3 = Class.forName("java.lang.String");
		//System.out.println(cls1 == cls2);
		//System.out.println(cls2 == cls3);
		
		//System.out.println(cls1.isPrimitive()); // 是否原始类型
		//System.out.println(int.class == Integer.class);
		//System.out.println(int.class.isPrimitive());
		//System.out.println(int.class == Integer.TYPE); // TYPE 代表包装基本类型的字节码
		// 基本类型
		// Boolean.TYPE Character.TYPE Byte.TYPE Short.TYPE 
		// Integer.TYPE Long.TYPE Float.TYPE Double.TYPE Void.TYPE
		
		//System.out.println(int[].class.isArray());
		
		Constructor constructor1 = String.class.getConstructor(StringBuffer.class); // 获得构造函数
		String str2 = (String) constructor1.newInstance(new StringBuffer("abc")); // 获得的构造函数创建对象
		
		ReflectPoint pt1 = new ReflectPoint(3, 5);
		Field fieldY = pt1.getClass().getField("y"); // 只能获取共有变量
		Field fieldX = pt1.getClass().getDeclaredField("x"); // 可以获取私有共有变量
		System.out.println(fieldY.get(pt1)); // 取类上的变量
		System.out.println(fieldX);// 可以获取私有共有变量, 但是获取不了值
		
		changeStringValue(pt1);
		System.out.println(pt1);
		
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		System.out.println(methodCharAt.invoke(str1, 1));
		System.out.println(methodCharAt.invoke(str1, new Object[] {2}));
		
		// TestArguments.main(new String[] {"111", "222", "333"}); // 直接调用main方法
		
		// 为什么用反射调用? 因为不知道类的名字, 不知道要执行哪个类
		String startingClassName = args[0];
		// 但是我知道这个类里面有一个类方法
		Method mainMethod = Class.forName(startingClassName).getMethod("main", String[].class);
		
		mainMethod.invoke(null, (Object)new String[] {"111", "222", "333"}); // 静态的类不需要传递对象, 所以写null
		mainMethod.invoke(null, new Object[]{new String[] {"111", "222", "333"}});
		
		// 数组反射
		int[] a1 = new int[3];
		int[] a2 = new int [4];
		int[][] a3 = new int[2][3];
		String[] a4 = new String[4];
		System.out.println(a1.getClass() == a2.getClass());

		System.out.println(a1.getClass().getName());
		
		a1 = new int[] {1,2,3};
		a4 = new String[] {"a","b","c"};
		Object aObj1 = a1;
		Object aObj2 = a4;
		// Object[] aObj3 = a1; // 这个编译不通过 int[] 本身也是Object[]
		Object[] aObj4 = a3;
		Object[] aObj5 = a4;
		System.out.println(a1);
		System.out.println(a4); // 想看内容, 可以转换成List
		System.out.println(Arrays.asList(a1));
		System.out.println(Arrays.asList(1,2,3)); // asList 接收Object[] 数组
 		System.out.println(Arrays.asList(a4)); // 转换成List
 		
 		Object obj = null;
 		printObject(a1);
	}

	private static void printObject(Object obj) { // 数组的反射
		Class clazz = obj.getClass();
		if(clazz.isArray()) {
			int len = Array.getLength(obj);
			for(int i = 0; i < len; i++) {
				System.out.println(Array.get(obj, i));
			}
		} else {
			System.out.println(obj);
		}
		
	}

	private static void changeStringValue(Object obj) throws Exception {
		// TODO Auto-generated method stub
		
		Field[] fields = obj.getClass().getFields();
		for(Field field : fields) {
			// if(field.getType().equals(String.class)) // 用equals也可以, 但是不准确
			if(field.getType() == String.class) { // 字节码用  == 不用equals
				String oldValue = (String) field.get(obj);
				String newValue = oldValue.replaceAll("b", "a");
				field.set(obj, newValue);
			}
		}
	}

}

class TestArguments{
	public static void main(String[] args) {
		for(String arg : args) {
			System.out.println(arg);
		}
	}
}
