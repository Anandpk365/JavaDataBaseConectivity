package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Util.Jdbc;

public class Update {
	
	private static Connection connection;
	private static PreparedStatement pstmt;

	public static void update() {
		
		Scanner sc = new Scanner(System.in);
		
		connection  = Jdbc.getConnection();
		
		String quary = "Update employee set name = ? where id = ?";
		
		try {
			if(connection!=null) {
				pstmt = connection.prepareStatement(quary);
			}
			
			System.out.println("Enter the ID of employee");
			int id = sc.nextInt();
			
			System.out.println("Enter the name of the Employee");
			String name = sc.next();
			
			pstmt.setInt(2, id);
			pstmt.setString(1, name);
			
			int rowAffected = pstmt.executeUpdate();
			
			if(rowAffected == 1) {
				System.out.println("Updated : "+rowAffected);
			}else
			{
				System.out.println("Failed to Update : "+rowAffected);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.clean(connection, pstmt, null);
		}
	}

}
