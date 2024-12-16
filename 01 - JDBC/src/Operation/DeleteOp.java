package Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Util.jdbcUtil;

public class DeleteOp {
	
	private static Connection connection;
	private static Statement statement;
	private static Object quary;

	public static void delete() {
		
		Scanner sc = new Scanner(System.in);
		connection = jdbcUtil.getConnection();
		
		try {
			if(connection != null) {
				statement = connection.createStatement();
				System.out.println("Statement object is Created ");
			}
			
			System.out.println("Enter the ID which wants to delete");
			int id = sc.nextInt();
			
			quary = String.format("delete from employee where id='%d'", id);
			
			int rowAffected = statement.executeUpdate((String) quary);
			System.out.print("Affected row: "+ rowAffected);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.clean(connection, statement, null);
		}
	}

}
