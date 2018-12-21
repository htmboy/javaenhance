package cn.itcast.day1;

public class AutoBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer iObj = 3; // 以前是不行的 这个3自动转换成Integer 这个过程就叫自动装箱
		// Integer Obj = (Integer)3; // 以前的写法, 强制装箱
		System.out.println(iObj + 12); // iObj会自动转化为int型, 这个自动就叫自动拆箱
		
		Integer i1 = 13;
		Integer i2 = 13;
		System.out.println(i1 == i2);
		
		String j1 = new String("abc");
		String j2 = new String("abc");
		System.out.println(j1 == j2);
		
		Integer k1 = 137;
		Integer k2 = 137;
		System.out.println(k1 == k2); // Integer会判断值是否在  -128~127之间, 如果存在, 就引用.如果不在就重新创建一个新的对象. 137已经超出范围所以会创建新对象. 
		
		Integer l1 = Integer.valueOf(3);
		Integer l2 = Integer.valueOf(3); 
		System.out.println(l1 == l2); // 同一个
		
		Integer m1 = Integer.valueOf(333);
		Integer m2 = Integer.valueOf(333); 
		System.out.println(m1 == m2); // 不同
	}

}
