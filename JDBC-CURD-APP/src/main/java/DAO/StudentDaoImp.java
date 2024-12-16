package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Student;
import JDBCUtility.JdbcConnection;

public class StudentDaoImp implements IStudentDao {

	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	public String addStudent(Student student) {

		String sqlInsertQuery = "INSERT INTO student (RollNo, Name, Age, addres) VALUES (?, ?, ?, ?)";

		try {
			connection = JdbcConnection.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}

			if (pstmt != null) {
				int rollNo = student.getRollNo();
				String name = student.getName();
				int age = student.getAge();
				String address = student.getAddress();

				pstmt.setInt(1, rollNo);
				pstmt.setString(2, name);
				pstmt.setInt(3, age);
				pstmt.setString(4, address);

				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student searchStudent(Integer rollNo) {
		Student student = null;
		String sqlQuary = "Select * from student where RollNo = ?";

		try {
			connection = JdbcConnection.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuary);
			}

			if (pstmt != null) {
				pstmt.setInt(1, rollNo);

				resultSet = pstmt.executeQuery();
			}

			student = new Student();
			if (resultSet != null) {
				if (resultSet.next()) {
					student = new Student();
					student.setRollNo(resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setAge(resultSet.getInt(3));
					student.setAddress(resultSet.getString(4));
					return student;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}

	@Override
	public String updateStudent(Student student) {

		String sqlUpdateQuery = "update student set name=?,age=?,addres=? where RollNo=?";

		try {
			connection = JdbcConnection.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}

			if (pstmt != null) {
				pstmt.setString(1, student.getName());
				pstmt.setInt(2, student.getAge());
				pstmt.setString(3, student.getAddress());
				pstmt.setInt(4, student.getRollNo());
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public String deleteStudent(Integer rollNo) {
		Student student = null;
		String sqlQuary = "Delete from student where RollNo = ?";

		try {
			connection = JdbcConnection.getConnection();

			if (connection != null) {
				pstmt = connection.prepareStatement(sqlQuary);
			}

			if (pstmt != null) {
				pstmt.setInt(1, rollNo);

				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected == 1) {
					return "success";
				}else {
					return "not found";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}

}
