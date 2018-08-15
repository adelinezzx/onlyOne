package IO.LoginDemo;

import java.util.Scanner;

public class Register {
	 Scanner input = new Scanner(System.in);
	 public boolean register() {
	        System.out.print("请输入注册用户名：");
	        String name = input.next() ;
	        System.out.print("请输入注册密码：");
	        String password = input.next() ;
	        
	        System.out.print("请确认注册密码：");
	        String repassword = input.next() ;
	       if(password.equals(repassword)){
	    	   IOUtil.save(name, repassword); //注册成功，把数据存放到数据文件中
                return true ;
	       }else{
	    	   return false ;
	       }
	}

}
