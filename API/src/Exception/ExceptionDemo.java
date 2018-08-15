package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) {
		
		System.out.println("请输入一个密码：");
		Scanner input = new Scanner(System.in);
	    String password = input.next();
        try {
			vaildatePassword(password);
		} catch (PasswordException e) {
			System.err.println(e.getMessage());
		}  
       System.out.println("程序结束...");
	}

	private static void  vaildatePassword(String password) throws PasswordException{//声明异常
		if(password.length()<6){
			throw new PasswordException("密码长度至少为六位！");  //抛出异常
		}
	}
}
