package LOG;

import org.apache.log4j.*;

/*
 * 日志处理     log4j    4对应for    2对应to
 * 记录程序的运行过程
 * 程序异常处理
 * 分等级输出
 */
public class logDemo {
	private static Logger LOG = Logger.getLogger(logDemo.class);

	public static void main(String[] args) {

		// 使用日志处理框架log4j
		// 1.引入日志处理包-----》log4j-1.2.17.jar
		// 2.引入日志处理文件------>log4j.properties
		// 3.创建日志记录器------>private static logger LOG =
		// logger.getLogger(类名.class);
		// 4.进行日志记录操作
		LOG.debug("debug文件");
		LOG.info("info文件");
        LOG.warn("warn文件");
        LOG.error("error文件");
        
       new logTest().fun();
	}
}
