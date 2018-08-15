package Util.List;

import java.util.Vector;

public class VectorDemo {
	public static void main(String[] args) {
         Vector<String> vector = new Vector<String>();
         vector.add("admin") ;
         vector.addElement("cindy");
         System.out.println(vector);
         
         //Vector和ArrayList，LinkedList的区别在于Vector是线程安全
	}

}
