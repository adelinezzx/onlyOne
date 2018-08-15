package Util.List;

import java.util.LinkedList;

public class LinkedDemo {

	public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<String>() ;
        names.add("cindy") ;
        names.add("Bob") ;
        names.add(1,"bettry") ;
        names.addFirst("pop"); //在首位置添加
        names.addLast("last");  //在末尾添加
        
        System.out.println(names.getClass());
        System.out.println(names);
        //LinkedList 方便查找和遍历数据
        //LinkedList 方便插入和删除数据
        
	}

}
