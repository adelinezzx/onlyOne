package IO.File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//磁盘上的文件用file描述，也就是磁盘上的文件和文件夹的类型
public class FileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\text.txt"); // 创建文件或文件夹对象
		Scanner input = new Scanner(System.in);
		if (file.exists()) { // 判断文件是否在磁盘上
			System.out.println("存在");
			if (file.isDirectory()) { // 判断是否是文件夹
				System.out.println("是文件夹");
				System.out.println("删除文件夹选1，修改文件夹选2");
				switch (input.nextInt()) {
				case 1:
					// 2.删除
					deleteDir(file);
					System.out.println("删除文件夹成功");
					break;
				case 2:
					// 3.修改
					System.out.println("请输入一个新的文件夹名：");
					String newName = input.next();
					File newfile = new File(file.getParentFile(), newName); // 新的文件对象
					file.renameTo(newfile); // 文件重命名
					System.out.println("创建文件夹成功");
				}
			}

			if (file.isFile()) { // 判断是否是文件
				// 对文件的操作
				System.out.println("是文件");
				System.out.println("删除文件选1，修改文件选2");
				switch (input.nextInt()) {
				case 1:
					// 2.删除
					file.delete();
					System.out.println("删除文件成功");
					break;
				case 2:
					// 3.修改
					System.out.println("请输入一个新的文件名：");
					String newName = input.next();
					File newfile = new File(file.getParentFile(), newName); // 新的文件对象
					file.renameTo(newfile); // 文件重命名
					System.out.println("修改文件成功");
				}
				// 4.查询
			}
		} else {
			System.out.println("不存在");
			// Scanner input =new Scanner(System.in);
			System.out.println("创建文件选1，创建文件夹选2");
			switch (input.nextInt()) {
			case 1:
				file.createNewFile();
				System.out.println("创建文件成功");
				break;
			case 2:
				file.mkdirs();
				System.out.println("创建文件夹成功");
			}
		}
	
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
