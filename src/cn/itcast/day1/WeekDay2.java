package cn.itcast.day1;

// ö����
public class WeekDay2 {
	private WeekDay2() {
		
	}
	
	public final static WeekDay2 SUN = new WeekDay2() {
		public WeekDay2 nextDay() { // ��һ��if else ת���ڲ���
			return SUN; 
		}
	};
	public final static WeekDay2 MON = new WeekDay2();
	public final static WeekDay2 TUE = new WeekDay2();
	public final static WeekDay2 WED = new WeekDay2();
	public final static WeekDay2 FOR = new WeekDay2();
	public final static WeekDay2 FIR = new WeekDay2();
	public final static WeekDay2 SET = new WeekDay2();
	
//	public WeekDay nextDay() {
//		if(this == SUN)
//			return MON;
//		else
//			return SUN;
//	}
	
	public String toString() {
		return this == SUN ? "sunday" : "monday";
	}
}
