package IO.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//磁盘上的文件用file描述，也就是磁盘上的文件和文件夹的类型
public class FileDemo02 {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\text.txt"); // 创建文件或文件夹对象
		Scanner input = new Scanner(System.in);
		if(file.exists()){
			if(file.isDirectory()){
				deleteDir(file);           //是文件夹则删除
				System.out.println("删除文件" + file.getName());
				file.createNewFile() ;     //再创建文件
				System.out.println("创建文件" + file.getName());
			}else{
				file.createNewFile();
				System.out.println("创建文件" + file.getName());
			}
		}
		//文件内容的操作
	 //从内存程序到磁盘文件的操作
		//1.增 //2.删//3.改 
		FileOutputStream out = new FileOutputStream(file , true);  //创建文件输出流对象。输出数据到文件的数据流
		String str = "\r\nHello Bob!" ;  //要流出 的数据内容  记事本中\r\n为换行
		out.write(str.getBytes());    //把字符串转换成字节数组。以字节的方式流出数据到文件中
		out.flush();  //清理缓存
		out.close();  //写入后及时关闭通道
		System.out.println("---------------------------------");
		FileInputStream in = new FileInputStream(file);
		byte[] bs = new byte[1024];
    //从磁盘到内存的操作
		//4.查
		int len = 0;//以字节的方式从文件中流入程序中，以字节数组bs接收数据,返回的值是存放多个数据到bs中
		//如果返回值是-1 ，表示没有数据存放到bs中
		StringBuilder sb = new StringBuilder();
		while((len = in.read(bs)) != -1){
			sb.append(new String(bs , 0 , len)) ;    //取出存放的数据的字节然后拼接成字符串
		}
 		System.out.println("输出的数据" + sb.toString());
   
	}
	private static void deleteDir(File dir) {
		File[] fs = dir.listFiles(); // 取到文件的所有子文件
		if (fs.length == 0) {
			dir.delete(); // 删除空的文件夹
		}
		for (File f : fs) { // 取出一个个子文件
			if (f.isFile()) { // 判断子文件是否是文件
				f.delete();
			} else {
				deleteDir(f); // 递归 扫描子文件是否是文件
			}
		}
		dir.delete();
	}
}
