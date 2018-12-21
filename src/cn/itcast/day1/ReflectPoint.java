package cn.itcast.day1;

public class ReflectPoint {

	private int x;
	public int y;
	
	public String str1 = "ball";
	public String str2 = "basketball";
	public String str3 = "itcast";
	/**
	 * @param x
	 * @param y
	 */
	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return str1 +":" + str2;
	}

}
