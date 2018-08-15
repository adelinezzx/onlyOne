package Util.Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import Util.Set.Student;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 存储键值对数据使用Map接口，HashMap 实现类
		// 存储学生信息：key：存储姓名方便查找，value：对应学生的全部信息
		HashMap<String, Student> hm = new HashMap<String, Student>();

		// hm.put(key, value);
		Student hm1 = new Student("Cindy", "女", 18, "121543");
		hm.put(hm1.getName(), hm1);

		Student hm2 = new Student("Bob", "男", 20, "4654532");
		hm.put(hm2.getName(), hm2);   //把hm2的学生信息存储带hm 中 
		// @
		/*
		 * System.out.println(hm); //Map的取值 String name = "Cindy1" ; Student stu
		 * = hm.get(name); if(stu == null){ System.out.println("没有改学生的信息"); }
		 * else{ System.out.println(name + "Cindy的信息为：" + stu); }
		 */
		// @
		// Map遍历数据 key ：set类型， value ： Collection类型
		/*
		 * System.out.println("Map遍历数据："); Set<String> keys = hm.keySet() ;
		 * //取到所有的key值 for(String key : keys){ //String 元素变量 ： 要遍历的对象 快捷键：for +
		 * alt + / // System.out.println(key); Student value =
		 * hm.get(key);//取到key对应的值 System.out.println(key + "--->" + value); }
		 * 
		 * System.out.println("---------------------------------------------");
		 * Iterator<String> iters = keys.iterator() ; //创建迭代器对象
		 * while(iters.hasNext()){ //迭代器中是否有下一个 String key = iters.next() ;
		 * //取到迭代器的下一个数据 System.out.println(key); }
		 * 
		 * //Map取到所有的值 System.out.println("Map 取值"); Collection<Student> values
		 * = hm.values(); ArrayList<Student> stu = new
		 * ArrayList<Student>(values); for (Student student : stu) {
		 * System.out.println(student); }
		 */
		// @
		// Set<Entry<String, Student>> keyValues = hm.entrySet() ;
		// //取到所有的key和value
		// //entry 是Map接口下的一个内部接口 提供了getKey、getValue、SetValue的功能
		// for (Entry<String, Student> entry : keyValues) {
		// System.out.println(entry.getKey() + "-->" + entry.getValue());
		// }

		// @
		// 更新数据与增加数据操作一样
		System.out.println("修改前：" + hm);
		hm.put("Cindy", new Student("Cindy", "女", 20, "7895456")); // 更新数据与增加数据操作一样
		System.out.println("修改后：" + hm);

		// 删除数据
		Student delstu = hm.remove("Bob");
		System.out.println("删除的学生：" + delstu);
		System.out.println("删除后：" + hm);
		// @
		// ArrayList<Student> stu = new ArrayList<Student>() ;
		// stu.add(hm1);
		// stu.add(hm2);
		// System.out.println("-------------------------------------------------------");
		// System.out.println(stu);
		// System.out.println("-------------------------------------------------------");
		// //如果取到 Cindy的信息
		// String name = "Cindy1" ;
		// boolean isExist = true ;
		// for(Student stu1 : stu ){
		// if(name.equals(stu1.getName())){
		// System.out.println(name + "Cindy的信息为：" + stu1);
		// isExist = false ;
		// }
		// }
		// if(isExist){
		// System.out.println("没有改学生的信息");
		// }
	}

}
