package String;

public class StringDemo {

	public static void main(String[] args) {
           String name = "admin" ;
           String name1 =new  String("admin") ; 
           //name和name1共创建了二个对象  name在直接指向admin，
           //name1会在方法区中new一个空间后在指向admin，常量名admin不允许重复
           
           System.out.println(name.intern() == name1.intern());
           //intern()方法是将name和name1中的最终数值进行比较，如果相等返回TRUE
           System.out.println(name.intern());
           //同样，用name来调用intern（）时得到的为name的数值
           System.out.println(name);  //得到的也是admin，但与intern（）方法不同，举例如下
           System.out.println(name  == name.intern());  //两者结果相同 name会默认调用toString 方法，打印出name的值
           System.out.println(name1 == name1.intern());  //两者结果不同，因为name1  new了一个空间后才指向admin
	       System.out.println(name1);  //实际上是调用name1 的地址，name1的地址再指向name1的最终数值
	       
	       int[] nums = new int[10] ;
	       System.out.println(nums.length); // 数组的长度是属性
	       
	       System.out.println(name.length());  //计算一个字符串的长度是方法
	       
	       //比较两个对象的数值是否相等用equals
	       //比较两个对象的数值大小用compareTo() ,返回int类型 0 、1 
	}

}
