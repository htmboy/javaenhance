package cn.itcast.day3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class ProxyTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class); // һ���õ�����, �ӿںͼ������ǳɶ�;
		// һ�㿴��clazz ��֪��������ֽ���, ���ʹ���
		System.out.println(clazzProxy1.getName());
		System.out.println("------------begin constructor list------------");
		Constructor[] constructors = clazzProxy1.getConstructors();
		for(Constructor constructor : constructors) {
			String name = constructor.getName();
			StringBuilder sBuilder = new StringBuilder(name); // ����Ҫ���ǵ��̰߳�ȫ������, ��ʹ��StringBuilder, ����Ч�ʸ�
			sBuilder.append("(");
			Class[] clazzParams = constructor.getParameterTypes();
			for(Class clazzParam : clazzParams) {
				sBuilder.append(clazzParam.getName()).append(',');
				
			}
			if(clazzParams != null && clazzParams.length != 0)
				sBuilder.deleteCharAt(sBuilder.length() - 1);
			sBuilder.append(")");
			System.out.println(sBuilder.toString());
		}
		System.out.println("------------begin methods list------------");
		Method[] methods = clazzProxy1.getMethods();
		for(Method method : methods) {
			String name = method.getName();
			StringBuilder sBuilder = new StringBuilder(name); // ����Ҫ���ǵ��̰߳�ȫ������, ��ʹ��StringBuilder, ����Ч�ʸ�
			sBuilder.append("(");
			Class[] clazzParams = method.getParameterTypes();
			for(Class clazzParam : clazzParams) {
				sBuilder.append(clazzParam.getName()).append(',');
				
			}
			if(clazzParams != null && clazzParams.length != 0)
				sBuilder.deleteCharAt(sBuilder.length() - 1);
			sBuilder.append(")");
			System.out.println(sBuilder.toString());
		}
		
		
		// ��̬����ʵ������
		System.out.println("------------begin create instance list------------");
		// Object obj = clazzProxy1.newInstance(); // �㲻֪���������޲ι��췽��
		Constructor constructor= clazzProxy1.getConstructor(InvocationHandler.class);
		class MyInvocationHandler1 implements InvocationHandler{

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		}
		Collection proxy1 = (Collection) constructor.newInstance(new MyInvocationHandler1()); // Ҫ׼��InvocationHandler��ʵ����
		System.out.println(proxy1.toString()); // ���ﷵ��null
		proxy1.clear();
//		proxy1.size();
		
		constructor.newInstance(new InvocationHandler() { // �����������ڲ����д��

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		Collection proxy3 = (Collection) Proxy.newProxyInstance(
				Collection.class.getClassLoader(), 
				new Class[] {Collection.class}, 
				new InvocationHandler() { // �����������ڲ����д��
			ArrayList target = new ArrayList();
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				// ArrayList target = new ArrayList();
				long beginTime = System.currentTimeMillis();
				Object retVal = method.invoke(target, args);
				long endTime = System.currentTimeMillis();
				System.out.println(method.getName() + " runing time of " + (endTime - beginTime));
				return retVal;
			}
		});
		
		proxy3.add("lhm");
		proxy3.add("bxd");
		proxy3.add("zxx");
		System.out.println(proxy3.size()); // Ϊʲô��0 ÿ�ε���һ��add, �ͻᶯ̬����invoke����, ����Ҫ��target ����������ȫ�ֱ���
	}
	
	
	
}
