package cn.itcast.day1;

import java.util.Date;
// 枚举类, 当枚举只有一个成员时, 可以作为一种单例的实现方式.
// 要实现单例, 可以用枚举
public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WeekDay2 weekDay2 = WeekDay2.SUN;
		System.out.println(weekDay2); // 自动调用toString方法
		
		WeekDay weekDay = WeekDay.FRI;
		System.out.println(weekDay.values().length);
		
		new Date(300) { }; // 调用父类的有参构造方法
	}
	
	public enum WeekDay{ // 最简单的枚举
			
		SUN(2),MON,TUE,WED,THI,FRI,SAT; //如果枚举里面有方法, 必须放在枚举列表的后面 
		// 初始化枚举列表时, 调用构造方法. 有7个就调用7次. 枚举后面添加括号, 是表示要传构造方法的参数
		private WeekDay() {
			System.out.println("first");
		}
		private WeekDay(int day) {
			System.out.println("second");
		}
	}
	
	public enum TrafficLamp{
		RED(30){ // 调用有参构造方法

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
		}; // 这三个都是TrafficLamp 的子类对象
		
		public abstract TrafficLamp nextLamp();
		private int time;
		private TrafficLamp(int time) {
			this.time = time;
		}
	}

}
