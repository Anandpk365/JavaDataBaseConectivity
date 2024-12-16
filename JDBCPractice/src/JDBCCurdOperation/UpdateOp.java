package JDBCCurdOperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCUtil.JDBC;

public class UpdateOp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		int row=0;
		
		try {
			connection = JDBC.getConnection();
			if(connection != null) {
				statement = connection.createStatement();
			}
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Eneter ther name : ");
			String name = sc.next();
			
			System.out.println("Enter the roll : ");
			int roll = sc.nextInt();
			
			String quary = String.format("update student set name = '%s' where roll = '%d'",name, roll);
			if(statement != null) {
				row = statement.executeUpdate(quary);
			}
			
			System.out.println("Row : "+row);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.cleanUP(connection, statement, null);
		}

	}

}
