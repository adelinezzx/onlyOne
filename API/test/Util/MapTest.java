package Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
    	//1.创建实例对象
		HashMap<String , stuTest> stu = new HashMap<String , stuTest>();
		//2.存入数据
		stuTest stu1 = new stuTest("Cindy" ,18,"女", "4567612");
		stu.put(stu1.getName(), stu1) ;  //存入stu1.getName()的值以及其映射对应的值
		
		stuTest stu2 = new stuTest("Bob",20,"男","89451321") ;
		stu.put(stu2.getName(), stu2);   //存入stu2.getName()的值以及其映射对应的值
		
//		System.out.println(stu);
		
		//map的取值
		System.out.println("Map取值");
		String name ="Cindy" ;
		stuTest stus = stu.get(name) ;
		if(stus == null){
			System.out.println("没有该学生信息");
		}
		else{
			System.out.println(name + "的信息为：" + stus);
		}
		//Map遍历数据
		System.out.println("Map遍历");
		Set<String> keys = stu.keySet() ;   //用set取到key的值
		for (String key : keys) { 
			stuTest value = stu.get(key) ;//取到key对应的数据     即存入key所映射的值
			System.out.println(key + "-->" + value);
		}
		
		//使用迭代器取到key的值
		Iterator<String> iter = keys.iterator() ;    
		while(iter.hasNext()){
			String key = iter.next() ;
			System.out.println(key);
		}
		System.out.println("排序后使用ArrayList：");
		Collection<stuTest> values = stu.values() ;
		ArrayList<stuTest> stu11 = new ArrayList<stuTest>(values);
		for (stuTest stutest : stu11) {
			System.out.println(stutest);
		}
		//使用entry
		System.out.println("使用entry");
		Set<Entry<String,stuTest>> keyValues = stu.entrySet(); //取到所有的key和value
		//即  返回此映射所包含的映射关系的 collection视图
		for (Entry<String, stuTest> entry : keyValues) {
			System.out.println(entry);
		}
		//更新数据
		System.out.println("修改前：" + stu);
		stu.put("Cindy", new stuTest("Cindy",24,"女","45798451")) ;
		System.out.println("修改后：" + stu);
		
		//删除数据
		stuTest delStu = stu.remove("Bob");
		System.out.println("删除后：" + stu);
		
	}
}
