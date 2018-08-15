package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class zDBUtil {
	private static final Logger LOG = Logger.getLogger(zDBUtil.class);
	//第一步：加载驱动
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");//加载数据库驱动
			LOG.error("加载数据库成功！");
		} catch (ClassNotFoundException e) {
			LOG.error("加载数据库失败！");
			e.printStackTrace();
		}
		//第二步：连接数据库
		Connection con =null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","study40","a");
			LOG.error("连接数据库成功！");
		} catch (SQLException e) {
			LOG.error("连接数据库失败！");
			e.printStackTrace();
		}
		//第三步：创建sql语句平台 将是sql语句发送到数据库
		Statement st =null ;
		try {
			 st = con.createStatement();
			 LOG.error("创建sql语句平台成功！");
		} catch (SQLException e) {
			LOG.error("创建sql语句平台失败！");
			e.printStackTrace();
		}
		
		//第四步：书写和执行sql语句
		String sql = "select * from myemp inner join mydept on myemp.deptno = mydept.deptno where myemp.empno = 7788";
		ResultSet rs = null;//获取生成此 ResultSet 对象的 Statement 对象。
		//执行书写的sql语句
		try {
			rs = st.executeQuery(sql); //执行给定的 SQL 语句，该语句返回单个 ResultSet 对象
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {//选择要输出的列
			while(rs.next()){
				Integer empno = rs.getInt("empno");
				String ename = rs.getString(2);
				String loc = rs.getString(11);
				System.out.println(empno + " -- " + ename + " -- " + loc);
				System.out.println("输出完成!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//第五步：关闭连接
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
		}
	}

}
