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
		// ָ��ͬһ���ֽ���
		
		//������, 
		// 1, ��.class
		// 2, Obj.getClass()
		// 3, Class.forName() ������Ҫ������
		
		String str1 = "abc";
		Class cls1 = str1.getClass();
		Class cls2 = String.class;
		Class cls3 = Class.forName("java.lang.String");
		//System.out.println(cls1 == cls2);
		//System.out.println(cls2 == cls3);
		
		//System.out.println(cls1.isPrimitive()); // �Ƿ�ԭʼ����
		//System.out.println(int.class == Integer.class);
		//System.out.println(int.class.isPrimitive());
		//System.out.println(int.class == Integer.TYPE); // TYPE �����װ�������͵��ֽ���
		// ��������
		// Boolean.TYPE Character.TYPE Byte.TYPE Short.TYPE 
		// Integer.TYPE Long.TYPE Float.TYPE Double.TYPE Void.TYPE
		
		//System.out.println(int[].class.isArray());
		
		Constructor constructor1 = String.class.getConstructor(StringBuffer.class); // ��ù��캯��
		String str2 = (String) constructor1.newInstance(new StringBuffer("abc")); // ��õĹ��캯����������
		
		ReflectPoint pt1 = new ReflectPoint(3, 5);
		Field fieldY = pt1.getClass().getField("y"); // ֻ�ܻ�ȡ���б���
		Field fieldX = pt1.getClass().getDeclaredField("x"); // ���Ի�ȡ˽�й��б���
		System.out.println(fieldY.get(pt1)); // ȡ���ϵı���
		System.out.println(fieldX);// ���Ի�ȡ˽�й��б���, ���ǻ�ȡ����ֵ
		
		changeStringValue(pt1);
		System.out.println(pt1);
		
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		System.out.println(methodCharAt.invoke(str1, 1));
		System.out.println(methodCharAt.invoke(str1, new Object[] {2}));
		
		// TestArguments.main(new String[] {"111", "222", "333"}); // ֱ�ӵ���main����
		
		// Ϊʲô�÷������? ��Ϊ��֪���������, ��֪��Ҫִ���ĸ���
		String startingClassName = args[0];
		// ������֪�������������һ���෽��
		Method mainMethod = Class.forName(startingClassName).getMethod("main", String[].class);
		
		mainMethod.invoke(null, (Object)new String[] {"111", "222", "333"}); // ��̬���಻��Ҫ���ݶ���, ����дnull
		mainMethod.invoke(null, new Object[]{new String[] {"111", "222", "333"}});
		
		// ���鷴��
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
		// Object[] aObj3 = a1; // ������벻ͨ�� int[] ����Ҳ��Object[]
		Object[] aObj4 = a3;
		Object[] aObj5 = a4;
		System.out.println(a1);
		System.out.println(a4); // �뿴����, ����ת����List
		System.out.println(Arrays.asList(a1));
		System.out.println(Arrays.asList(1,2,3)); // asList ����Object[] ����
 		System.out.println(Arrays.asList(a4)); // ת����List
 		
 		Object obj = null;
 		printObject(a1);
	}

	private static void printObject(Object obj) { // ����ķ���
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
			// if(field.getType().equals(String.class)) // ��equalsҲ����, ���ǲ�׼ȷ
			if(field.getType() == String.class) { // �ֽ�����  == ����equals
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
