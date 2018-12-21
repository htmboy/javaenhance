package cn.itcast.day1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
	public static void main(String)
}
