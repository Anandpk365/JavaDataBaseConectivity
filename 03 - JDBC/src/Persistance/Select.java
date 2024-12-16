package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Util.JDBC;

public class Select {
	
	private static Connection connection;
	private static PreparedStatement pstmt;
	private static ResultSet resultSet;

	public static void select() {
		connection = JDBC.getConnection();
		String quary = "Select * from student";
		
		try {
			if(connection!=null)
				pstmt = connection.prepareStatement(quary);
			
			resultSet = pstmt.executeQuery();
			
			System.out.println("name\t\t\tDOB\t\t\tDOJ");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"\t\t"+sdf.format(resultSet.getDate(2))+"\t\t"+sdf.format(resultSet.getDate(3)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.clean(connection, pstmt, resultSet);
		}
	}

}
