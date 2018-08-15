package Util.List;

import java.util.ArrayList; //

public class ArrayListDemo02 {

	public static void main(String[] args) {
		 //可以在ArrayList中指定容量的大小，默认为10
	  ArrayList al = new ArrayList();  //创建一个人ArrayList集合对象
	 
      al.add("c") ;
      al.add("ci") ;
      al.add("cin") ;
      al.add("cind") ;
      al.add("cindy") ;
//      System.out.println("al的数据个数" + al.size());//al.size():取到集合对象中存放的数据个数
    
      //如果需要在集合中只存在一种类型的数据，可以使用泛型 “<指定泛型>”
      ArrayList<String> name = new ArrayList(); //使用泛型创建只能存储字符串的数据的集合
      name.add("cindy");
//      name.add(1);    //当指定了只能存储字符串数据，添加其他类型的数据后会报错
      String names = name.get(1);
      
      //不可以使用基本类型作为存放对象，因为集合只能存放对象
      //   ArrayList<int>  nums = new ArrayList<int>();
      ArrayList<Integer>  nums = new ArrayList<Integer>() ;
      nums.add(12) ;
      
	}
}
