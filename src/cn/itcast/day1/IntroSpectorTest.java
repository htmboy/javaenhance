package cn.itcast.day1;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntroSpectorTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ReflectPoint pt1 = new ReflectPoint(3, 5);
		
		
		String propertyName = "x";
		
		// "x" --> "X" --> "getX" --> MethodGetX -->
		// ��pt1��, ��ȡ����**
		Object retVal = getProperty(pt1, propertyName);
		System.out.println(retVal);
		// setX
		
		Object value = 7;
		setProperties(pt1, propertyName, value); // ����pt1 �е� set *** ���� �� �������
		
		System.out.println(pt1.getX());
		
	}

	private static void setProperties(ReflectPoint pt1, String propertyName, Object value)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyName, pt1.getClass()); 
		Method methodSetX = pd.getWriteMethod(); // ��ȡ set***����
		methodSetX.invoke(pt1, value);
	}

	private static Object getProperty(ReflectPoint pt1, String propertyName)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		// �򵥵ķ�ʽ
//		PropertyDescriptor pd = new PropertyDescriptor(propertyName, pt1.getClass()); 	
//		// getX
//		Method methodGetX = pd.getReadMethod(); // ��ȡ get***����
//		return methodGetX.invoke(pt1); // ����pt1 �е� get *** ����
		
		// ���ӵķ�ʽ
		BeanInfo beanInfo = Introspector.getBeanInfo(pt1.getClass());
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		Object retVal = null;
		for(PropertyDescriptor pd : pds) {
			if(pd.getName().equals(propertyName)) {
				Method methodGetX = pd.getReadMethod();
				retVal = methodGetX.invoke(pt1);
				break;
			}
		}
		return retVal;
		
	}

}
