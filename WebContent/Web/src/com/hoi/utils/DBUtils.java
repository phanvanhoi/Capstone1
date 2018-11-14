package com.hoi.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.hoi.beans.Student;
import com.hoi.beans.Subject;

public class DBUtils {

	public static Student findUser(Connection conn, //
			String SubjectID, String PassWord) throws SQLException {

		String sql = "Select a.StudentID, a.NameStudent, a.Email, a.Address, a.IdentityCard, a.PassWord, a.IndustryID from Student a " //
				+ " where a.StudentID = ? and a.PassWord= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, SubjectID);
		pstm.setString(2, PassWord);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			Student student = new Student();
			student.setStudentID(SubjectID);
			
			String NameStudent = rs.getString("NameStudent");
			student.setNameStudent(NameStudent);
			
			String Email = rs.getString("Email");
			student.setEmail(Email);
			
			String Address = rs.getString("Address");
			student.setAddress(Address);
			
			String IdentityCard = rs.getString("IdentityCard");
			student.setIdentityCard(IdentityCard);
			
			student.setPassWord(PassWord);
			
			String IndustryID = rs.getString("IndustryID");
			student.setIndustryID(IndustryID);
			
			return student;
		}
		return null;
	}

	public static Student findUser(Connection conn, String StudentID) throws SQLException {

		String sql = "Select a.StudentID, a.NameStudent, a.Email, a.Address, a.IdentityCard, a.PassWord, a.IndustryID from Student a "//
				+ " where a.StudentID = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, StudentID);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			
			Student student = new Student();
			student.setStudentID(StudentID);
			
			String NameStudent = rs.getString("NameStudent");
			student.setNameStudent(NameStudent);
			
			String Email = rs.getString("Email");
			student.setEmail(Email);
			
			String Address = rs.getString("Address");
			student.setAddress(Address);
			
			String IdentityCard = rs.getString("IdentityCard");
			student.setIdentityCard(IdentityCard);
			
			String PassWord = rs.getString("PassWord");
			student.setPassWord(PassWord);
			
			String IndustryID = rs.getString("IndustryID");
			student.setIndustryID(IndustryID);
			
			return student;
		}
		return null;
	}

	public static List<Subject> querySubject(Connection conn) throws SQLException {
		String sql = "Select a.SubjectID, a.NameSubject, a.Credits, a.NumberOfHours, a.TypeOfSubjectID from  Subject a";
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Subject> list = new ArrayList<Subject>();
		while (rs.next()) {
			String subjectID = rs.getString("SubjectID");
			String nameSubject = rs.getString("NameSubject");
			int credits = rs.getInt("Credits");
			int numberOfHours = rs.getInt("NumberOfHours");;
			String typeOfSubjectID = rs.getString("TypeOfSubjectID");
			Subject subject = new Subject();
			subject.setSubjectID(subjectID);
			subject.setNameSubject(nameSubject);
			subject.setCredits(credits);
			subject.setNumberOfHours(numberOfHours);
			subject.setTypeOfSubjectID(typeOfSubjectID);			
			list.add(subject);
		}
		return list;
	}

	public static Subject findSubject(Connection conn, String SubjectID) throws SQLException {
		String sql = "Select a.SubjectID, a.NameSubject, a.Credits, a.NumberOfHours, a.TypeOfSubjectID from  Subject a where a.SubjectID=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, SubjectID);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String subjectID = rs.getString("SubjectID");
			String nameSubject = rs.getString("NameSubject");
			int credits = rs.getInt("Credits");
			int numberOfHours = rs.getInt("NumberOfHours");;
			String typeOfSubjectID = rs.getString("TypeOfSubjectID");
			Subject subject = new Subject(subjectID, nameSubject, credits, numberOfHours, typeOfSubjectID);
			return subject;
		}
		return null;
	}

	public static void updateSubject(Connection conn, Subject subject) throws SQLException {
		String sql = "Update Subject set NameSubject =?, Credits=?, NumberOfHours=?, TypeOfSubjectID=? where SubjectID=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, subject.getNameSubject());
		pstm.setInt(2, subject.getCredits());
		pstm.setInt(3, subject.getNumberOfHours());
		pstm.setString(4, subject.getTypeOfSubjectID());
		pstm.setString(5, subject.getSubjectID());
		pstm.executeUpdate();
	}

	public static void insertSubject(Connection conn, Subject subject) throws SQLException {
		String sql = "Insert into Product(SubjectID,NameSubject,Credits,NumberOfHours,TypeOfSubjectID) values (?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, subject.getSubjectID());
		pstm.setString(2, subject.getNameSubject());
		pstm.setInt(3, subject.getCredits());
		pstm.setInt(4, subject.getNumberOfHours());
		pstm.setString(5, subject.getTypeOfSubjectID());
		pstm.executeUpdate();
	}

	public static void deleteSubject(Connection conn, String SubjectID) throws SQLException {
		String sql = "Delete From Product where SubjectID= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, SubjectID);

		pstm.executeUpdate();
	}

}