package Util.List;

import java.util.Arrays;
import java.util.Random;

public class ArrayDemo { // 工具类util包中的类都是抽象的类，不需要创建新对象

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int[] nums = { rand.nextInt(1000), rand.nextInt(1000),
				rand.nextInt(1000), rand.nextInt(1000), rand.nextInt(1000) };
		System.out.println(Arrays.toString(nums)); // 把数组转换成字符串
		System.out.println("排序后：");
		Arrays.sort(nums); // 数组进行排序
		System.out.println(Arrays.toString(nums));
	}

}
