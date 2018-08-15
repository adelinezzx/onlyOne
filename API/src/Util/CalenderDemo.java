package Util;

import java.util.Calendar;
public class CalenderDemo {     //抽象类，不能直接new对象，只能通过调用getInstance的方法来调用

	public static void main(String[] args) {
       Calendar c  = Calendar.getInstance() ;
//       System.out.println(c);
       
       int year = c.get(Calendar.YEAR);
       int month = c.get(Calendar.MONTH) + 1;  //默认月份从0开始
       int date = c.get(Calendar.DATE);
       
       int hour = c.get(Calendar.HOUR_OF_DAY) ;   //二十四小时制。如果是Calendar.HOUR则是12小时制
       int minute = c.get(Calendar.MINUTE) ;
       int second = c.get(Calendar.SECOND) ;
       
       System.out.println(year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second );
	}

}
