package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map.Entry;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class MyCMD {
	private Scanner input = new Scanner(System.in);
	private String currentPath;
	private File File;

	public static void main(String[] args) {
		new MyCMD().start();
	}

	private void start() {
		System.out.println("Microsoft Windows [版本 6.1.7601]\n"
				+ "版权所有 (c) 2009 Microsoft Corporation。保留所有权利。");
		// Properties是key和value都是String类型的Map
		Properties props = System.getProperties();// 取到JVM的环境变量

		/*
		 * Set<Entry<Object,Object>> ps = props.entrySet(); for (Entry<Object,
		 * Object> p : ps) { System.out.println(p.getKey() + "-->" +
		 * p.getValue()); }
		 */
		currentPath = System.getProperty("user.home");
		String commandStr = null;
		do {
			System.out.print("\n" + currentPath + ">");
			commandStr = input.nextLine(); // 取一行控制台输入数据
		} while (opertorCommand(commandStr));

	}

	private boolean opertorCommand(String commandStr) {
		// 1、取到符号 .trim() 表示去掉字符串前后空格 split() 表示以什么字符拆分字符串
		String[] commandStrs = commandStr.trim().split("\\s+"); // \\s+ 空格
																// +表示至少有一个空格
		switch (commandStrs[0].toUpperCase()) { // commandStrs[0]表示命令字符
												// .toUpperCase()表示忽略大小写
		case "CD":
			doCD(commandStrs);
			break;
		case "COPY":
			doCopy(commandStrs);
			break;
		case "DATE":
			doDate();
			break;
		case "DEL":
			doDel(commandStrs);
			break;
		case "DIR":
			doDir(commandStrs);
			break;
		case "EXIT":
			return false;
		case "FIND":
			break;
		case "HELP":
			doHelp();
			break;
		case "MD":
			doMD(commandStrs);
			break;
		case "MKDIR":
			break;
		default:
			System.out.println("‘" + commandStrs[0]
					+ "’不是内部或外部命令，也不是可运行的程序\n或批处理文件。");
		}
		return true;
	}

	private void doMD(String[] commandStrs) {
         if(commandStrs.length==2){
        	 File file = new File(currentPath+"\\"+commandStrs[1]);
        	// System.out.println(file.getPath());
        	 if(file.exists()){
        		 System.out.println("子目录或者文件" + file.getName() + "已存在");
        	 }else{
        		 try {
     				file.createNewFile();
     			} catch (IOException e){
     			}
        	 }
         }else{
        	 System.out.println("命令语法不正确。");
         }
	}

	// dir的方法
	private void doDir(String[] commandStrs) {
		System.out.println(currentPath + "的目录\n");

		try {
			if (commandStrs.length == 2) {
				File file = getFile(commandStrs[1]);
				getDir(file);
			}
		} catch (NullPointerException e) {
		}
	}

	// 获取到文件的格式并输出文件的大小，文件名，可用空间
	private void getDir(File file) {
		// File[] file = files.listFiles();
		int count = 0; // 文件的个数记录
		int countj = 0; // 文件夹的个数记录
		if (file.isFile()) { // 是文件，直接输出
			count++;
			getLastModified(file);
			System.out.println("   " + file.length() + " " + file.getName());
			System.out.println(count + "个文件          " + file.length() + "字节");
			System.out.println(countj + "个目录  " + file.getUsableSpace()
					+ " 可用字节");
		}
		if (file.isDirectory()) { // 文件夹，先获取子目录
			File[] file1 = file.listFiles();
			for (File file2 : file1) {
				if (file2.isFile()) {
					count++;
					getLastModified(file2);
					System.out.println("   " + file2.length() + " "
							+ file2.getName());
				} else {
					countj++;
					getLastModified(file2);
					System.out.println("   " + " <DIR> " + file2.length() + " "
							+ file2.getName());
				}
			}
			System.out.println(count + "个文件          " + file.length() + "字节");
			System.out.println((countj ) + "个目录  "
					+ file.getUsableSpace() + " 可用字节");
		}
	}

	// 获取文件最晚修改时间
	private void getLastModified(java.io.File file2) {
		long last = file2.lastModified();
		Date date = new Date(last);
		SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd  hh:mm"); // 把时间格式化
		String dateStr = sdf.format(date); // 2.把时间对象转换成字符串，
		System.out.print(dateStr);

	}

	// 删除文件1
	private void doDel(String[] commandStrs) {
		if (commandStrs.length == 2) {
			File file = getFile(commandStrs[1]);
			deleteDir(file);
			file.delete();
		} else {
			System.out.println("找不到" + currentPath + "\\" + commandStrs[1]);
		}
	}

	// 删除文件2
	private void deleteDir(File dir) {
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

	// 输出时间
	private void doDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd E "); // 把时间格式化
		String dateStr = sdf.format(date); // 2.把时间对象转换成字符串，
		System.out.println(dateStr);
		System.out.println("输入新日期：（年/月/日）");

	}

	// 复制文件
	private void doCopy(String[] commandStrs) {
		if (commandStrs.length == 3) {
			File srcFile = getFile(commandStrs[1]);// 要拷贝的文件
			if (srcFile != null) {
				File destFile = getFile(commandStrs[2]);// 拷贝的文件路径
				if (destFile != null) {
					try {
						// 输入字节缓存流
						BufferedInputStream in = new BufferedInputStream(
								new FileInputStream(srcFile));
						// 输出字节缓存流
						BufferedOutputStream out = new BufferedOutputStream(
								new FileOutputStream(new File(destFile,
										srcFile.getName())));

						byte[] bs = new byte[1024];
						int len = 0;
						while ((len = in.read(bs)) != -1) { // 读取要拷贝的文件
							out.write(bs, 0, len);// 把读取到的文件内容写到要拷贝的文件中
						}
						in.close();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	// 读取文件获取文件
	private File getFile(String pathStr) {
		File f = new File(pathStr);
		if (f.exists()) { // 判断
			return f;
		} else {
			// 相对路径切换处理
			f = new File(currentPath, pathStr);
			if (f.exists()) { // 判断
				return f;
			} else {
				System.out.println("找不到指定路径。");
			}
		}
		return null;
	}

	// CD
	private void doCD(String[] commandStrs) {
		if (commandStrs.length != 2) {
			System.out.println("找不到指定路径。");
		} else {
			// 绝对路径处理
			File f = new File(commandStrs[1]);
			if (f.exists()) { // 判断
				if (f.isDirectory()) {
					currentPath = Character.toUpperCase(f.getAbsolutePath()
							.charAt(0)) + f.getAbsolutePath().substring(1);// .charAt(0)取出首字母
																			// 把首字母变成大写
				} else { // .substring(1) 取到下标为1的字母后面的字母
					System.out.println("目录名无效。");
				}
			} else {
				// 相对路径切换处理
				f = new File(currentPath, commandStrs[1]);
				if (f.exists()) { // 判断
					if (f.isDirectory()) {
						currentPath = Character.toUpperCase(f.getAbsolutePath()
								.charAt(0)) + f.getAbsolutePath().substring(1);// .charAt(0)取出首字母
																				// 把首字母变成大写
					} else { // .substring(1) 取到下标为1的字母后面的字母
						System.out.println("目录名无效。");
					}
				} else {
					f = new File(currentPath, commandStrs[1]);
					System.out.println("找不到指定路径。");
				}
			}
		}
	}

	public void doHelp() {

		File helpFile = new File(System.getProperty("user.dir"), "help.txt"); // 创建帮助文件对象
		/*
		 * System.out.println(System.getProperty("user.dir")); File helpFile =
		 * new File(System.getProperty("user.dir"), "help.txt"); // 创建帮助文件对象
		 * FileInputStream in = new FileInputStream(helpFile);// 创建与指定文件的输入流对象
		 * byte[] bs = new byte[1024]; //以字节读取文件上的数据放入bs中 int len = 0; //读取数据的长度
		 * while ((len = in.read(bs)) != -1) { System.out.println(new String(bs,
		 * 0, len)); } in.close();
		 */
		// BufferedInputStream in = new BufferedInputStream(in); 缓存流
		// 字符流：主要针对文本文件的读取，不能图片，音乐，视频读取，这个只能使用字节读取
		// 字节流的父类是InputStream / OutputStream
		// 字符流的父类是Reader / Writer
		/*
		 * FileReader in = new FileReader(helpFile); char[] cs = new char[1024]
		 * ; int len = 0; //读取数据的长度 while ((len = in.read(cs)) != -1) {
		 * System.out.println(new String(cs, 0, len)); } in.close();
		 */
		try {
			Scanner in = new Scanner(helpFile);
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
