package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo03 {
	public static void main(String[] args) {
		
		System.out.println("请输入一个数：");
		Scanner input = new Scanner(System.in);
		int num1 = 12;
		int num2 = 0;
		do {
			try { // 使用try、catch来捕获异常
				num2 = input.nextInt();
				System.out.println(num1 / num2); // 除零产生异常
				break;

			} catch (Exception e) {
				
				System.out.println("b输入的数据有异常,请重新输入");
				if(e instanceof InputMismatchException){  
					input.next();
				}
			}finally{
				System.out.println("num1 :" + num1 + ",num2 :" + num2 + ",num1/num2 "  );

			}
		} while (true);

		System.out.println("程序结束");
	}
}
