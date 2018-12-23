package itcastlib;

public class ClassLoaderTest {
	
	// java系统默认三个主要类加载器, 每个类负责加载特定位置的类:
	// BootStrap, ExtClassLoader, AppClassLoader
	// 类加载器也是java类, 因为其他事java类的类加载器本身也要被类加载器加载, 显然有一个类加载器不是java类, 这个是BootStrap, 它是C++写的二进制代码
	
	// BootStrap 加载JRE/lib/rt.jar 
	// ExtClassLoader 加载JRE/lib/ext/*.jar
	// AppClassLoader 加载ClassPath指定的所有jar或目录
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// getClassLoader()加载器本身也是个类, 
		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName()); // 类加载器的名字 : AppClassLoader
		System.out.println(System.class.getClassLoader()); // 为一个特殊的类加载器 所以是null System是由BootStrap 加载进来的
		// BootStrap, ExtClassLoader, AppClassLoader 之间的关系
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while(loader != null) {
			System.out.println(loader.getClass().getName());
			loader = loader.getParent(); // $PlatformClassLoader java9开始将ExtClassLoader改为PlatformClassLoader
		}
		System.out.println(loader);
	}

}
