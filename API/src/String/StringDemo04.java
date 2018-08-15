package String;

import java.io.UnsupportedEncodingException;

public class StringDemo04 {

	public static void main(String[] args) throws UnsupportedEncodingException {
           String fileEncoding = System.getProperty("file.encoding") ;   //获取到文件的字符编码集
           System.out.println(fileEncoding);   
		    
           String str = "å­ç¬¦" ;
           //UTF-8 3byte;  GBK 2byte ;  ISO-8859-1  1byte 
           byte[] bs = str.getBytes("ISO-8859-1") ;    //按指定字符编码集拆分  字符串  成  字节数组
           str = new String(bs, fileEncoding);  //按指定字符编码集组装  字节数组  成  字符串
           System.out.println(str);
	}
}
