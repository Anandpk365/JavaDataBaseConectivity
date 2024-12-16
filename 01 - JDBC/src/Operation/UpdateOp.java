package Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Util.jdbcUtil;

public class UpdateOp {
	
	private static Connection connection;
	private static Statement statement;

	public static void update() {
		
		Scanner sc =  new Scanner(System.in);
		connection = jdbcUtil.getConnection();
		
		try {
			if(connection !=null) {
				statement = connection.createStatement();
				System.out.println("Statement obejct created ");
			}
			
			System.out.println("Enter the id:");
			int id = sc.nextInt();
			
			System.out.println("Enter the name ");
			String name = sc.next();
			
			String quary = String.format("update employee set name = '%s' where id = '%d'", name, id);
			
			int rowAffected = statement.executeUpdate(quary);
			System.out.println("RowAffected : "+rowAffected);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
