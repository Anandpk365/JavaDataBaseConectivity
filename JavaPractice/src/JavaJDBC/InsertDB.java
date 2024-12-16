package JavaJDBC;
import JavaJDBC_01.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDB {
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet =null;

	public static void main(String[] args) {
		
		try {
			connection = Util.getConnection();
			if(connection != null) {
				statement = connection.createStatement();
			}
			
			int affectedRow = 0;
			
			while(true) {
				System.out.println("Enter the name: ");
				Scanner sc = new Scanner(System.in);
				String name = sc.nextLine();
				System.out.println("Enter the age : ");
				int age = sc.nextInt();
				System.out.println("Enter the marks : ");
				double marks = sc.nextDouble();
				
				String quary = "insert into Students (name, age, marks) values ('"+name+"',"+age+","+marks+")";
				int n= statement.executeUpdate(quary);
				
				System.out.println("Successfully Inserted");
				affectedRow +=n;
				
				System.out.println("Do you want to continue : Y/N ");
				char choice = sc.next().charAt(0);
				
				if(choice =='n') {
					break;
				}
			}
			
			System.out.println("Number of Row affected : "+affectedRow);
			
			if(statement != null) {
				String quary = "Select * from Students";
				resultSet = statement.executeQuery(quary);
			}
			
			System.out.println("id\t\tname\t\tage\t\tmarks");
			
			if(resultSet != null) {
				while(resultSet.next()) {
					System.out.println(""+resultSet.getInt(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getInt(3)+"\t\t"+resultSet.getDouble(4));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
