package Exception;

import java.util.Scanner;

public class ExceptionDemo01 {
	public static void main(String[] args) {
		/*
		 * String name = " " ; boolean reasult = name.equals("admin") ; int[]
		 * num = {45,90} ;
		 */

		// Scanner input = new Scanner(System.in);
		// int num1 = 12 ;
		// int num2 = input.nextInt();
		// if (num2!= 0){ //通过判断语句来减少异常的发生
		// System.out.println(num1/num2); //除零产生异常
		// }
		// System.out.println("程序结束");

		System.out.println("请输入一个数：");
		Scanner input = new Scanner(System.in);
		int num1 = 12;
		int num2 ;
		do {
			try { // 使用try、catch来捕获异常
				num2 = input.nextInt();
				try {
					System.out.println(num1 / num2); // 除零产生异常
					break;
				} catch (Exception e) {
					System.out.println("a输入的数据有异常,请重新输入");
				}
			} catch (Exception e) {
				// e.printStackTrace(); 显示异常
				//对异常的处理
				System.out.println("b输入的数据有异常,请重新输入");
				input.next();
			}
		}while (true);
		

		System.out.println("程序结束");
	}
}
