package JavaJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JavaJDBC_01.Util;

public class SelectRecord {

	public static void main(String[] args) throws SQLException{
		
		Connection connection = null;
		PreparedStatement prstm = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		
		
		try {
			connection  = Util.getConnection();
			System.out.println("Connection is done : ");
			
			String quary = "Select * from Students where id = ?";
			if(connection != null) {
				prstm = connection.prepareStatement(quary);
				
				System.out.println("Enter the ID: ");
				int id = sc.nextInt();
				prstm.setInt(1, id);
				
				resultSet = prstm.executeQuery();
			}
			
			if(resultSet != null) {

                if(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				double marks = resultSet.getDouble(4);
				
				System.out.println("id\t\tname\t\tage\t\tmarks");
				System.out.println(id+"\t\t"+name+"\t\t"+age+"\t\t"+marks);
                }else {
    				System.out.println("matching id's record is not there ..");
    			}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
			Util.cleanUp(resultSet, prstm, connection);
		}

	}

}
