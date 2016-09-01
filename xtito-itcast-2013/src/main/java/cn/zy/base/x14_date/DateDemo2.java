package cn.zy.base.x14_date;

import java.util.Calendar;

/**
 * 获取日期中的指定日期信息比如获取年，月，日Calendar。
 */
public class DateDemo2 {
	public static void main(String[] args) {
		
		//需求2：基于需求1，获取到了日期和时间的字符串信息(本地)。
		//如何获取字符串中指定的日期信息呢？比如获取年，并判断。
		//1,获取日期对象。Date
//		Date date = new Date();
		
		//jdk1.1开始 Calendar。//获取日历对象。
		Calendar c = Calendar.getInstance();//
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		String week = getCnWeek(c.get(Calendar.DAY_OF_WEEK));
		
		//打印信息中年月日等相关信息都在这里。获取指定字段的值就哦了。
		System.out.println(year+"年"+month+"月"+day+"日  "+week);
		
	}
	//让星期字段对应的中文的星期。查表。数组。

	public static String getCnWeek(int i) {
		if(i<0 || i>7){
			throw new RuntimeException(i+"没有对应的星期");
		}
		//定义表。
		String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		
		return weeks[i];
	}
}
