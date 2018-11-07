package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCn {
	public void dbConnect() {
		// Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=TimetableAssume;user=SA;password=123";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT * FROM Student";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.IdentityCard
            while (rs.next()) {
                System.out.println(rs.getString("StudentID") + " " + rs.getString("NameStudent") + " " + rs.getString("Email") + " " + rs.getString("Address") + " " + rs.getString("IdentityCard") + " " + rs.getString("PassWord") + " " + rs.getString("IndustryID"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TestCn kn = new TestCn();
		kn.dbConnect();
	}
}


