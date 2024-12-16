package Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Util.jdbcUtil;

public class InsertOp {
	
	private static Connection connection;
	private static Statement statement;

	public static void insert() {
		
		Scanner sc = new Scanner(System.in);
		connection = jdbcUtil.getConnection();
		
		try {
			if(connection != null) {
				statement = connection.createStatement();
				System.out.println("Statement Object is created");
			}
			
			System.out.println("Enter the ID: ");
			int id = sc.nextInt();
			System.out.println("Enter the name ");
			String name = sc.next();
			
			System.out.println("Enter the Salary ");
			float salary = sc.nextFloat();

			
			String quary = String.format("insert into employee (id, name, salary)values('%d', '%s', '%f')",id, name, salary);
			
			int affectedRow = statement.executeUpdate(quary);
			System.out.println("number of row affected: "+ affectedRow);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.clean(connection, statement, null);
		}
	}

}
