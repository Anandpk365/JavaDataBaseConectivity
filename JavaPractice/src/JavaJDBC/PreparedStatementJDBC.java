package JavaJDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JavaJDBC_01.Util;

public class PreparedStatementJDBC {

	public static void main(String[] args) throws IOException, SQLException{
		
		Connection connection = null;
		PreparedStatement prmtm = null;
		ResultSet resultSet = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			connection = Util.getConnection();
			System.out.println("Connection is done.. ");
			
			
			String quary = "Insert into Students (name, age, marks) values (?,?,?)";
			int rowAffected = 0;
			while(true) {
			if(connection != null) {
				System.out.println("insert record: ");
				System.out.println("Enter Your name : ");
				String name = sc.next();
				
				System.out.println("Enter age : ");
				int age = sc.nextInt();
				
				System.out.println("Enter marks : ");
				double marks = sc.nextDouble();
				
				prmtm = connection.prepareStatement(quary);
				
				prmtm.setString(1, name);
				prmtm.setInt(2, age);
				prmtm.setDouble(3, marks);
				
				int row = prmtm.executeUpdate();
				
				rowAffected+=row;
				
				System.out.println("Do you want to Continue Y/N : ");
				char choice = sc.next().charAt(0);
				
				if(choice == 'n' || choice == 'N') {
					break;
				}
				
			}
		}
			System.out.println("record inserted Successfully : ");
			System.out.println("Number of Row Affected : "+rowAffected);
			
			resultSet = prmtm.executeQuery("Select * from Students;");
			
			System.out.println("id\t\tname\t\tage\t\tmarks");
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				double marks = resultSet.getDouble(4);
				System.out.println(id+"\t\t"+name+"\t\t"+age+"\t\t"+marks);
			}
			
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				sc.close();
				Util.cleanUp(resultSet, prmtm, connection);
			}

	}

}
