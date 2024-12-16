package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Util.Jdbc;

public class Delete {
	
	private static Connection connection;
	private static PreparedStatement pstmt;

	public static void delete() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = Jdbc.getConnection();
			
			String quary = "Delete from employee where id = ?";
			
			if(connection != null) {
				pstmt = connection.prepareStatement(quary);
			}
			
			System.out.println("Enter the ID: ");
			int id = sc.nextInt();
			
			pstmt.setInt(1, id);
			
			int rowAffected = pstmt.executeUpdate();
			
			if(rowAffected == 1) {
				System.out.println("Deleted Operation: "+rowAffected);
			}else {
				System.out.println("failed to Deleted Operation: "+rowAffected);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			Jdbc.clean(connection, pstmt, null);
		}
	}

}
