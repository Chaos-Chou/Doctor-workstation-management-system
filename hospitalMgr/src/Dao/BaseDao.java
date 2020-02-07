package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	public Connection conn = null;

	static {
		init();
	}

	public static void init() {// 静态导入配置文件
		Properties params = new Properties();
		String configFile = "Dao/database.properties";
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			params.load(is);
		} catch (IOException e) {
			System.out.print("错误信息：" + e);
		}
		driver = params.getProperty("driver");
		url = params.getProperty("url");
		user = params.getProperty("user");
		password = params.getProperty("password");
	}

	public Connection connection() {// 连接数据库

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("错误信息:" + e);
			return null;
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		// System.out.println("数据库连接成功！");
		return conn;
	}

	public void close(Connection conn, Statement stmt, ResultSet rs) {// 关闭连接
		try {
			if (null != conn) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		// System.out.println("数据库关闭成功！");
	}

}