package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Util.Jdbc;

public class Insert {
	
	private static Connection connection;
	private static String quary;
	private static PreparedStatement pstmt;

	public static void insert() {
		
		Scanner sc = new Scanner(System.in);
		
		connection = Jdbc.getConnection();
		
		quary = "Insert into employee (id, name, salary) values(?, ?, ?)";
		
		System.out.println("Enter the Employee ID...");
		int id = sc.nextInt();
		
		System.out.println("Enter the Name of the Employee...");
		String name = sc.next();
		
		System.out.println("Enter the salary of the employee...");
		float salary = sc.nextFloat();
		
		try {
			if(connection != null)
				pstmt = connection.prepareStatement(quary);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setFloat(3, salary);
			
			int rowAffected = pstmt.executeUpdate();
			
			if(rowAffected == 1) {
				System.out.println("Number of row Affected : "+ rowAffected);
			}else {
				System.out.println("Inserted operation is not performed :  "+ rowAffected);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			Jdbc.clean(connection, pstmt, null);
		}
	}

}
