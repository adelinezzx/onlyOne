package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
  public static void main(String[] args) {
	 Date date = new Date() ;
	 
	 //显示中国时间的一般格式                                                         年-月-日    时-分-秒.毫秒   星期
//	 SimpleDateFormat  sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.sss E");
	 
	 //1. 把时间格式化
	 SimpleDateFormat  sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.sss E ");  //把时间格式化
	 String dateStr = sdf.format(date);  //2.把时间对象转换成字符串，
	 System.out.println(dateStr);
	 
	 String str01 = "2017-5-6";
	 String str02 = "2016-5-6";
	 try {
		Date date01 = sdf.parse(str01);    //把时间日期的字符串转换成时间对象
		Date date02 = sdf.parse(str02);
		System.out.println(date01.after(date02));  //3.比较两个时间对象的时间前后，对则输出TRUE否则输出FALSE
	} catch (ParseException e) {
		System.out.println("时间格式不正确");
//		e.printStackTrace();   显示错误信息
	}
}
}
