package cn.itcast.day1;

public class AutoBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer iObj = 3; // ��ǰ�ǲ��е� ���3�Զ�ת����Integer ������̾ͽ��Զ�װ��
		// Integer Obj = (Integer)3; // ��ǰ��д��, ǿ��װ��
		System.out.println(iObj + 12); // iObj���Զ�ת��Ϊint��, ����Զ��ͽ��Զ�����
		
		Integer i1 = 13;
		Integer i2 = 13;
		System.out.println(i1 == i2);
		
		String j1 = new String("abc");
		String j2 = new String("abc");
		System.out.println(j1 == j2);
		
		Integer k1 = 137;
		Integer k2 = 137;
		System.out.println(k1 == k2); // Integer���ж�ֵ�Ƿ���  -128~127֮��, �������, ������.������ھ����´���һ���µĶ���. 137�Ѿ�������Χ���Իᴴ���¶���. 
		
		Integer l1 = Integer.valueOf(3);
		Integer l2 = Integer.valueOf(3); 
		System.out.println(l1 == l2); // ͬһ��
		
		Integer m1 = Integer.valueOf(333);
		Integer m2 = Integer.valueOf(333); 
		System.out.println(m1 == m2); // ��ͬ
	}

}
