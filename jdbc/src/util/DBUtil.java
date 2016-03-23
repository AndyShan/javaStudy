package util;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ibook";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static java.sql.Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");// 1.加载驱动程序
		    conn = DriverManager.getConnection(URL, USER, PASSWORD);// 2.获得数据库的链接
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static java.sql.Connection getConnection() {
		return conn;
	}
	
	
	public static String getUrl() {
		return URL;
	}

	public static String getUser() {
		return USER;
	}

	public static String getPassword() {
		return PASSWORD;
	}

}
