package LangPackage;

public class LangDemo {
       //java.lang包中的类默认加载，所以不需要手动加载(import xxx.xxx.xxx;)
	public static void main(String[] args) {
		//变量类型： 应用类型 ： 将基本类型进行包装  、  基本类型 ：在栈中开辟空间
		Integer num = new Integer(12345679);
		Boolean.parseBoolean(null);   //包装类
		
		int num0 = 10;
		Integer num1 = num0 ;   //自动装箱过程:基本类型变量自动装换为对应的包装类对象
		
		Integer num3  = new Integer("100");
		int num4 = num3 ;     //自动拆箱过程：包装类对象自动转换为对应的基本类型变量
	}
}
