package Util.List;

import java.util.ArrayList; //

public class ArrayListDemo {

	public static void main(String[] args) {
		// 可以在ArrayList中指定容量的大小，默认为10
		ArrayList al = new ArrayList(); // 创建一个人ArrayList集合对象
		// 增
		al.add("cindy");
		al.add(20);
		al.add(1, "Bob"); // 在指定位置之间插入指定元素
		al.add("c");
		al.add("ci");
		al.add("cin");
		al.add("cind");
		al.add("cindy");
		System.out.println("al的数据个数" + al.size());// al.size():取到集合对象中存放的数据个数

		// 改
		al.set(2, "betty");
		// 查
		System.out.println("打印toString：" + al.toString()); // 需要在调用的构造方法中重写toString方法后才能直接打印输出

		// 删
		System.out.println("要删除的数：" + al.remove(1)); // 移除集合中指定位置的数据
		System.out.println("删除指定位置数据后：" + al);
		// 集合排序
		// System.out.println(al.sort());
		// 删除集合中偶数位置的值
		for (int i = al.size() - 1; i >= 0; i--) {
			// 集合从后往前删。如果从前面删，每删除一个数集合都会重新报排序，不能达到删除后偶数的效果
			if (i % 2 == 0) {
				al.remove(i);
			}
		}
		System.out.println("删除偶数位置的数据后：" + al);

		// for(int i = 0; i<al.size() ; i++){
		// Object value = al.get(i); //取到集合指定位置的数据，注意下标的位置从0开始
		// System.out.println(value); //用Object来取到数据，Object为所有对象直接或者间接的父类
		// }
		// System.out.println(al.contains("cindy")); //判断集合中是否有某个数据
		// System.out.println(al.containsAll(al)); //判断集合中是否有某个子集合
		// System.out.println(al.isEmpty()); //判断集合是否为空
		// System.out.println(al.remove(1)); //移除集合中指定位置的数据

	}

}
