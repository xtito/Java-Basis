package cn.zy.base.x14_date;

import java.text.DateFormat;
import java.util.Date;

/**
 * 将毫秒值转成本地格式。Date DateFormat
 */
public class DateDemo1 {
	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();
//		System.out.println(time);//1382837734218
		//【怎么能将这个时间转成我们所熟悉的时间呢？】
		//通过另请参阅找到Date类。发现日期对象一初始化可以传递一个毫秒值。
		
		
		time = 1382837734218l;
		//创建了一个日期对象,将已有的毫秒值进行封装。通过日期对象的方法获取其中的相关信息。比如年月日。
		Date date = new Date(time);
		System.out.println(date.toString());//Sun Oct 27 09:35:34 CST 2013

		//对象的方法已过时。通过toString获取了国际化的信息。如何让信息本土化。
		//toLocaleString() 已过时，通过查阅信息发现替代从 JDK 1.1 开始，由 DateFormat.format(Date date) 取代。
		//要格式化一个当前语言环境下的日期，可使用某个静态工厂方法：myString = DateFormat.getDateInstance().format(myDate);

		//在获取格式器对象时可以明确风格。 FULL、LONG、MEDIUM(默认风格)和 SHORT
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		//调用format方法对日期对象进行格式化。用默认风格。
		String str_date = dateFormat.format(date);
		System.out.println(str_date);
		
	}
}
