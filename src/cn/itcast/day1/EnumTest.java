package cn.itcast.day1;

import java.util.Date;
// ö����, ��ö��ֻ��һ����Աʱ, ������Ϊһ�ֵ�����ʵ�ַ�ʽ.
// Ҫʵ�ֵ���, ������ö��
public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WeekDay2 weekDay2 = WeekDay2.SUN;
		System.out.println(weekDay2); // �Զ�����toString����
		
		WeekDay weekDay = WeekDay.FRI;
		System.out.println(weekDay.values().length);
		
		new Date(300) { }; // ���ø�����вι��췽��
	}
	
	public enum WeekDay{ // ��򵥵�ö��
			
		SUN(2),MON,TUE,WED,THI,FRI,SAT; //���ö�������з���, �������ö���б�ĺ��� 
		// ��ʼ��ö���б�ʱ, ���ù��췽��. ��7���͵���7��. ö�ٺ����������, �Ǳ�ʾҪ�����췽���Ĳ���
		private WeekDay() {
			System.out.println("first");
		}
		private WeekDay(int day) {
			System.out.println("second");
		}
	}
	
	public enum TrafficLamp{
		RED(30){ // �����вι��췽��

			@Override
			public TrafficLamp nextLamp() {
				// TODO Auto-generated method stub
				return GREEN;
			}
			
		}, 
		GREEN(45){
			public TrafficLamp nextLamp() {
				return YELLOW;
			}
		}, 
		YELLOW(5){
			public TrafficLamp nextLamp() {
				return RED;
			}
		}; // ����������TrafficLamp ���������
		
		public abstract TrafficLamp nextLamp();
		private int time;
		private TrafficLamp(int time) {
			this.time = time;
		}
	}

}
