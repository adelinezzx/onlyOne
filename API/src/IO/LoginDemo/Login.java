package IO.LoginDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
	public static Map<String , String> loginDatas = new HashMap<String,String>(); 
	//存储登录数据的集合，key存放登录用户名，value存放登录密码
	 Scanner input = new Scanner(System.in);
   public void login(){
	   System.out.print("是否有注册？(y/n)");
	   if("y".equals(input.next())){
		   System.out.print("请输入用户名：");
	       String name = input.next() ;
	       System.out.print("请输入密码：");
	       String password = input.next() ;
	       
	       String loginPassword = IOUtil.loginDatas.get(name);//根据输入的用户名在存储登录数据的集合取出对应的value
	       if(password.equals(loginPassword)){
	    	   System.out.print("登录成功...............");
	       }else{
	    	   System.out.print("登录失败！用户名或密码错误");
	       }
	   }else{
		   Register reg = new Register() ;
		   while(!reg.register()){
			   System.out.println("注册失败,两次密码输入不一致");
		   }
		   System.out.println("注册成功！");
		   login();
	   }
   }
}
