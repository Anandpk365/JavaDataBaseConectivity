package JDBCCurdOperation;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCUtil.JDBC;

public class DeleteOp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Scanner sc = null;
		
		int row = 0;
		
		try {
			connection = JDBC.getConnection();
			
			if(connection != null)
				statement = connection.createStatement();
			
			sc = new Scanner(System.in);
			System.out.println("Enter the roll");
			int roll = sc.nextInt();
			
			String quary = String.format("Delete from student where roll = '%d'", roll);
			if(statement != null)
				row = statement.executeUpdate(quary);
			
			System.out.println("Affected Row : "+row);
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.cleanUP(connection, statement, null);
		}

	}

}
