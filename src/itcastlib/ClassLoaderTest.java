package itcastlib;

public class ClassLoaderTest {
	
	// javaϵͳĬ��������Ҫ�������, ÿ���ฺ������ض�λ�õ���:
	// BootStrap, ExtClassLoader, AppClassLoader
	// �������Ҳ��java��, ��Ϊ������java��������������ҲҪ�������������, ��Ȼ��һ�������������java��, �����BootStrap, ����C++д�Ķ����ƴ���
	
	// BootStrap ����JRE/lib/rt.jar 
	// ExtClassLoader ����JRE/lib/ext/*.jar
	// AppClassLoader ����ClassPathָ��������jar��Ŀ¼
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// getClassLoader()����������Ҳ�Ǹ���, 
		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName()); // ������������� : AppClassLoader
		System.out.println(System.class.getClassLoader()); // Ϊһ�������������� ������null System����BootStrap ���ؽ�����
		// BootStrap, ExtClassLoader, AppClassLoader ֮��Ĺ�ϵ
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		while(loader != null) {
			System.out.println(loader.getClass().getName());
			loader = loader.getParent(); // $PlatformClassLoader java9��ʼ��ExtClassLoader��ΪPlatformClassLoader
		}
		System.out.println(loader);
	}

}
