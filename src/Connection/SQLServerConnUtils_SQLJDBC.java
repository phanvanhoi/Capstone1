package Connection;

import java.sql.*;

public class SQLServerConnUtils_SQLJDBC {
	public static Connection getConnection(String database) throws SQLException {
		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=" +database+ ";user=SA;password=123";

		Connection con = DriverManager.getConnection(connectionUrl);
		return con;
	}
}
