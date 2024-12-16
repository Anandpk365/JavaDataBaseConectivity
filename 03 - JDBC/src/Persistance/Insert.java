package Persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Util.JDBC;

public class Insert {

	private static Connection connection;
	private static PreparedStatement pstmt;
	private static int rowAffected;

	public static int insert(String name, String dob, String doj) {
	
		connection = JDBC.getConnection();

		String quary = "insert into student(name, dob, doj) values(?, ?, ?)";

		try {
			if (connection != null) {
				pstmt = connection.prepareStatement(quary);

				pstmt.setString(1, name);

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date uDate = sdf.parse(dob);
				long l = uDate.getTime();
				java.sql.Date sDOB = new java.sql.Date(l);
				pstmt.setDate(2, sDOB);

				java.sql.Date sDOJ = java.sql.Date.valueOf(doj);
				
				pstmt.setDate(3, sDOJ);

				 rowAffected = pstmt.executeUpdate();
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			JDBC.clean(connection, pstmt, null);
		}

		return rowAffected;
	}

}
