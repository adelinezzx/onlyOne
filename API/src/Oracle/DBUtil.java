package Oracle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DBUtil {
	private static final Logger LOG = Logger.getLogger(DBUtil.class);
	public static void main(String[] args) {
		// oracle.jdbc.OracleDriver
		try {
			Class.forName("oracle.jdbc.OracleDriver");// 加载操作数据库驱动
			LOG.error("加载数据库驱动成功......");
		} catch (ClassNotFoundException e) {
			LOG.error("加载数据库驱动失败！");
		}
		Connection con = null;//Connection:与指定数据库连接的对话
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","study40","a");
			//DriverManager.getConnection(url,user,password):试图建立到给定数据库 URL 的连接。
			LOG.error("连接数据成功......");

		} catch (SQLException e) {
			LOG.error("连接数据失败！");
			e.printStackTrace();
		}
		
		Statement st= null;//创建一个 Statement 对象来将 SQL 语句发送到数据库
		try {
			 st = con.createStatement();   //创建一个 Statement 对象来将 SQL 语句发送到数据库。
			 LOG.error("创建sql语句平台成功....");
		} catch (SQLException e) {
			 LOG.error("创建sql语句平台失败！",e);
		}
		
		String sql = "select * from phone";
		ResultSet rs = null;   //获取生成此 ResultSet 对象的 Statement 对象。
		try {
			 rs = st.executeQuery(sql);
			LOG.error("执行查询成功....");
		} catch (SQLException e) {
			LOG.error("执行查询失败！");
			e.printStackTrace();
		}
		
		try {
			while(rs.next()){
				Integer pno = rs.getInt("pno");
				String branch = rs.getString(2);
				System.out.println(pno + " --- " + branch);
			}
			LOG.error("取出数据成功....");
		} catch (SQLException e) {
			LOG.error("取出数据失败！");
			e.printStackTrace();
		}
	}
}
