package Object;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.Test;

import String.User;

public class UserTest {

	@Test
	public void testUser() {
		User user01 = new User("admin",2);
		User user02 = new User("admin",5);
		if(user01.equals(user02)){   //通过User类调用hashCode来决定你要比较的值
	    	 System.out.println("两个对象相等");
	     }
	     else{
	    	 System.out.println("两个对象不相等");
	     }
	}
	
	@Test
	public void testUser01() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		//类的类对象.Class就是类的类（对类抽象的类 
		//方法1
		//Class userClass = User.class ; 
		//方法2
		Class userClass = Class.forName("Object.User");
		//方法3
//		User user = new User() ;   
//		Class userClass = user.getClass() ;
		//全类名：包名加类名
		System.out.println(userClass.getName());
		System.out.println(userClass.getSuperclass().getName());
		System.out.println(Modifier.toString(userClass.getModifiers()));
		
		User user1 = (User) userClass.newInstance() ; //通过反射，使用类的类对象.newInstance()创建类的实例对象
		
		
	}
	

}
