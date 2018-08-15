package String;

public class StringDemo06 {
       public static void main(String[] args) {
//		 String str = "admin" ;
//		 long start = System.currentTimeMillis() ;//取到当前系统的毫秒数
//		 for(int i = 0 ; i < 1000 ; i++){
//			 str += "admin" + i ;
//		 }
//		 long end = System.currentTimeMillis() ;//取到当前系统时间的毫秒数
//		 System.out.println(end - start);
    	 
    	 //用StringBuffer来提高代码效率
    	 StringBuffer str =  new StringBuffer("admin") ;
  		 long start = System.currentTimeMillis() ;//取到当前系统的毫秒数
  		 for(int i = 0 ; i < 1000 ; i++){
  			 str.append("admin" + i) ;
  		 }
  		 long end = System.currentTimeMillis() ;//取到当前系统时间的毫秒数
  		 System.out.println(end - start);
  		 
  		 //1、StringBuffer 是String的增强版，他们之间相互转换
  		 String name = "admin" ;
  		 StringBuffer sbName = new StringBuffer(name) ;//String转换StringBuffer
  		 
  		 StringBuffer sbName1 = new StringBuffer();
  		 sbName1.append(name);  //String 转换为StringBuffer
  		 
  		 String name1 = sbName.toString() ; //StringBuffer转换为String
  		 name1 = sbName.toString() ;   // StringBuffer转换为String
  		 
//  		 StringBuffer.setCharAt(2,'a');
  		 //2/String与StringBuffer的操作和区别
	}
}
