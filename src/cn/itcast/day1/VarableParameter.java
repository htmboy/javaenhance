package cn.itcast.day1;

public class VarableParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add(2,3,4,5);
	}
	
	public static int add(int x, int ... args) { // 三个点表示参数数组, 必须写在参数的最尾
		int sum = 0;
		System.out.println(x);
		System.out.println(args.length);
		return sum;
	}

}
