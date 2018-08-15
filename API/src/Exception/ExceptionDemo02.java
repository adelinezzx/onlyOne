package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo02 {
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
		int num2;
		do {
			try { // 使用try、catch来捕获异常
				num2 = input.nextInt();
				System.out.println(num1 / num2); // 除零产生异常
				break;

			} catch (Exception e) {
				// e.printStackTrace(); 显示异常
				// 对异常的处理
				System.out.println("b输入的数据有异常,请重新输入");
//				if (input.hasNext()) {
//					input.next();
//				}
//				InputMismatchException e1 = (InputMismatchException) e;
				if(e instanceof InputMismatchException){  
					//当输入不符合int规则时，会出现该异常，故判断异常e是否为输入异常，是的话接收数据
					input.next();
				}
			}
		} while (true);

		System.out.println("程序结束");
	}
}
