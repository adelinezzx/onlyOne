package String;

import java.util.Scanner;

public class StringDemo01 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// System.out.println("请输入你要提交的Java作业文件的名称：");
		// String workFile = input.next() ;
		// if(!workFile.endsWith(".java")){
		// System.out.println("你提价的不是Java作业");
		// }
		// System.out.println("提交完成");

		// System.out.println("请输入采集到的内容：");
		// // 采集的内容与赚钱有关，内容要有赚钱这个子子字符串
		// String content = input.next();
		// if(content.contains("赚钱")){
		// System.out.println("这正是我想要的内容");
		// }
		// else{
		// System.out.println("这不是我想要的内容");
		// }
		// int PIndex = content.indexOf("赚钱");
		// 从前向后 检索第一个子字符串在字符串中的位置，位置从0开始，如果没有则返回-1

		// int LIndex = content.lastIndexOf("赚钱");
		// 从后往前，检索最后一个子字符串在字符串中的位置，位置0从开始，如果没有则返回-1
		// System.out.println(PIndex);

		// System.out.println(LIndex);

		String url = "https://www.baidu.com/s?wd=java&rsv_spt=1&rsv_iqid=0xcfd106790015f110&issp=1&f=8&"
				+ "rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=5&rsv_sug1=1"
				+ "&rsv_sug7=100&rsv_t=99f4q6VriUjZi07fCFzHv%2F95WinFS%2BedbOCfRX9p0QYrAcAy8ccZLAATRKnLRuwKqbvE"
				+ "&rsv_sug2=0&inputT=1318&rsv_sug4=3111&rsv_sug=2";
		// 地址是否带参数，就是判断有没有“？”
		if (url.contains("?")) {
			System.out.println("带参数");
		} else {
			System.out.println("没有带参数");
		}
		// 是否搜索了内容，就是判断有没有 "？wd=" 或者 "&wd="
		int index = url.indexOf("&wd=") > 0 ? url.indexOf("&wd=") : url
				.indexOf("?wd=");
		if (index > 0) {
			System.out.print("有搜索内容：");
			String content = url.substring(index); // subString(index)表示从指定位置切取到最后位置
			content = content.replace("&wd=", "").replace("?wd=", ""); // 替换掉字符串中的指定子字符串
            
				
            	int endIndex = content.indexOf("&");
    			content = content.substring(0, endIndex);// 从指定开始位置（包含）到指定结束位置（不包含）
    			System.out.println(content);
    			
		} else {
			System.out.println("没有搜索内容");
		}
		// 搜索的内容是什么？

	}
}
