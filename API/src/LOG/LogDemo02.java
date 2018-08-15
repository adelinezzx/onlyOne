package LOG;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class LogDemo02 {
	private static Logger LOG = Logger.getLogger(LogDemo02.class);

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("输入两个数，用逗号隔开：");
		do {
			try {
				int num1 = input.nextInt();
				int num2 = input.nextInt();
				LOG.debug("输入两个数是：num1 = " + num1 + ", num2 = " + num2);
				int result = num1 / num2;
				System.out.println("两个数的运算结果是：" + num1 + "/" + num2 + " = "
						+ result);
				break ;
			} catch (InputMismatchException e) {
				LOG.error("输入的数据类型不是整数！" + e);
				input.nextLine();
			} catch (ArithmeticException e) {
				LOG.error("除数不能为零！" + e);
			}
		} while (true);
		input.close();
		LOG.error("程序结束");
//		input.close();
	}
}
