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

		Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class); // 一般拿到代理, 接口和加载器是成对;
		// 一般看见clazz 就知道这个是字节码, 国际惯例
		System.out.println(clazzProxy1.getName());
		System.out.println("------------begin constructor list------------");
		Constructor[] constructors = clazzProxy1.getConstructors();
		for(Constructor constructor : constructors) {
			String name = constructor.getName();
			StringBuilder sBuilder = new StringBuilder(name); // 不需要考虑到线程安全的问题, 就使用StringBuilder, 所以效率高
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
			StringBuilder sBuilder = new StringBuilder(name); // 不需要考虑到线程安全的问题, 就使用StringBuilder, 所以效率高
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
		
		
		// 动态创建实例对象
		System.out.println("------------begin create instance list------------");
		// Object obj = clazzProxy1.newInstance(); // 你不知道是由有无参构造方法
		Constructor constructor= clazzProxy1.getConstructor(InvocationHandler.class);
		class MyInvocationHandler1 implements InvocationHandler{

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		}
		Collection proxy1 = (Collection) constructor.newInstance(new MyInvocationHandler1()); // 要准备InvocationHandler是实现类
		System.out.println(proxy1.toString()); // 这里返回null
		proxy1.clear();
//		proxy1.size();
		
		constructor.newInstance(new InvocationHandler() { // 可以用匿名内部类的写法

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		Collection proxy3 = (Collection) Proxy.newProxyInstance(
				Collection.class.getClassLoader(), 
				new Class[] {Collection.class}, 
				new InvocationHandler() { // 可以用匿名内部类的写法
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
		System.out.println(proxy3.size()); // 为什么是0 每次调用一个add, 就会动态调用invoke方法, 所以要把target 放在外面变成全局变量
	}
	
	
	
}
