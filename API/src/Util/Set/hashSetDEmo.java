package Util.Set;

import java.util.HashSet;
import java.util.Iterator;

public class hashSetDEmo {

	public static void main(String[] args) {
          HashSet<String> hs = new HashSet<String>();
          //添加数据
          hs.add("admin") ;
          hs.add("cindy") ;
          hs.add("scott") ;
          System.out.println(hs);
          
          
          //HashSet为无序不可重复，故不能通过get方法取到数据
          Iterator<String> iter =  hs.iterator();  
          //取数据
          while(iter.hasNext()){
        	  String h = iter.next() ;   //取到Set集合中的一个数据
        	  System.out.println(h);
          }
          
          System.out.println("--------------------------------");
          hs.remove("admin") ;
          //取数据
          iter = hs.iterator() ;   //迭代器，对数据进行排序 ,排序后可对集合进行删除操作
          while(iter.hasNext()){
        	  String h = iter.next() ;   //取到Set集合中的一个数据
        	  System.out.println(h);
          }
          
         HashSet<String> users = new HashSet<String>();
//         users.add(new User("asmin",23)) ;
         
	}

}
