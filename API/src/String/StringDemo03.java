package String;

import java.util.Scanner;

public class StringDemo03 {

	public static void main(String[] args) {

		String url = "https://www.baidu.com/s?wd=java&rsv_spt=1&rsv_iqid=0xcfd106790015f110&issp=1&f=8&"
				+ "rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=5&rsv_sug1=1"
				+ "&rsv_sug7=100&rsv_t=99f4q6VriUjZi07fCFzHv%2F95WinFS%2BedbOCfRX9p0QYrAcAy8ccZLAATRKnLRuwKqbvE"
				+ "&rsv_sug2=0&inputT=1318&rsv_sug4=3111&rsv_sug=2";
		// “？” 后接的是参数，参数与参数之间以“&”隔开，参数名与参数值以“ = ”隔开
		// 取到所有的参数
		// 取到所有参数的字符串
		int beginParamIndex = url.indexOf("?");
		if (beginParamIndex > 0) {
			String paramStr = url.substring(beginParamIndex + 1);
			// 取到每一个参数的字符串
			String[] paramStrs = paramStr.split("&");
			// 分离参数名和参数值
			for (String pStr : paramStrs) {
				String[] nv = pStr.split("=", 2);
				System.out.println("参数名：" + nv[0] + ",参数值：" + nv[1]);
			}
		}
	}
}
