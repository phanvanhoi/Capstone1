package jdbc;

import java.sql.*;

public class ODBCConnUtils {
	// Lấy ra kết nối vào ODBC Data Source có tên "desktop-oqh4g1g\sa".
	public static Connection getJdbcOdbcConnection() throws SQLException, ClassNotFoundException {
		String odbcDataSourceName = "desktop-oqh4g1g\\sa";
		String userName = "SA";
		String password = "123456";
		return getJdbcOdbcConnection(odbcDataSourceName, userName, password);
	}

	public static Connection getJdbcOdbcConnection(String odbcDataSourceName, String userName, String password)
			throws SQLException, ClassNotFoundException {

		// Khai báo class Driver (Cầu nối Jdbc-Odbc)
		// Việc này cần thiết với Java 5
		// Java6 tự động tìm kiếm Driver thích hợp.
		// Nếu bạn dùng Java6, thì ko cần dòng này cũng được.
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// Cấu trúc URL Connection dành cho JDBC-ODBC
		String connectionURL = "jdbc:odbc:" + odbcDataSourceName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
