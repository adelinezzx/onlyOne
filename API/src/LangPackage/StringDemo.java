package LangPackage;

public class StringDemo {

	public static void main(String[] args) {
		  //创建字符串对象
		String str01 = "hello" ;
		String str02 = new String("hello");
		String srt03 = new String("hello"); 
		String str04 = new String("hello");    //str01 = str04,  str01不等于其他任何一个。Str02!= Str03,他们开辟了不同的空间
		
		//两个引用类型对象，如果使用“==”比较 相等，则他们表示的是同一对象
		//如果要比较两个引用类型对象相等，要使用equals来进行比较
		if(str01 == str02){
			System.out.println("相等");
		}
		else{
			System.out.println("不相等");
		}
         System.out.println(" \" " + str04  +"\" +字符串的长度为："  + str04.length());
         System.out.println("hello".equals("Hello") ? "相同"  :  "不相同");
         System.out.println("hello".equalsIgnoreCase("Hello") ? "相同"  :  "不相同");    //忽略大小写比较两个值是否相等
         //0表示相等，正数表示“hello”的ASCII码大于“Hello”的ASCII码，
         //负数表示“hello”的ASCII码小于“Hello”的ASCII码
         System.out.println("hello".compareTo("hello"));   
         
         //比较前缀是否相同
         System.out.println("hello Word".startsWith("hello") ? "前缀相同"  :  "前缀不相同");
         //比较后缀是否相同
         System.out.println("hello Word".endsWith("Word") ? "后缀相同"  :  "后缀不相同");
	}

}
