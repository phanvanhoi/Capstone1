package utils;
import java.sql.*;
import Connection.*;
public class DBUtils  {
	public static void print() throws SQLException {
		
		Connection con = null;
		con = SQLServerConnUtils_SQLJDBC.getConnection("TimetableAssume");
		String sql = "Select * from Student";
		Statement statement =con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		System.out.println("connected");

		if (rs.next()) {
		    String StudentID = rs.getString("StudentID");
		    String NameStudent = rs.getString("NameStudent");
		    String Email = rs.getString("Email");
		    String Address = rs.getString("Address");
		    String IdentityCard = rs.getString("IdentityCard");
		    String PassWord = rs.getString("PassWord");
		    String IndustryID = rs.getString("IndustryID");
		    System.out.println(StudentID +"|" + NameStudent +"|" + Email +"|" + Address +"|" + IdentityCard +"|" + PassWord +"|" + IndustryID);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		DBUtils a = new DBUtils();
		a.print();
	}
}
