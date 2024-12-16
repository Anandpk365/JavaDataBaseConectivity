package JavaJDBC;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
	
	private static String url = "jdbc:mysql://localhost:3306/myDB";
	private static String user = "root";
	private static String password = "root";
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	public static void main(String[] arg) {
		try {
     		Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class is Loaded");
			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is done..");
			System.out.println("Implemented class name is :: "+connection.getClass().getName());
			
			String quary = "Select * from Students";
			
			statement = connection.createStatement();
			System.out.println("Implemented class name is :: "+statement.getClass().getName());
		    resultSet = statement.executeQuery(quary);
		    System.out.println("Implemented class name is :: "+resultSet.getClass().getName());
		    
		    System.out.println("id\tname\tage\tmarks");
		    
		    while(resultSet.next()) {
		    	int id = resultSet.getInt(1);
		    	String name = resultSet.getString(2);
		    	int age = resultSet.getInt(3);
		    	double marks = resultSet.getDouble(4);
		    	System.out.println(id+"\t"+name+"\t"+age+"\t"+marks);
		    }
		    
//		    System.out.println("Delete the one record: ");
//		    
//		    String sqlRecordD = "Delete from Students where id = 1";
//		    
//		    int recordAffected = statement.executeUpdate(sqlRecordD);
//		    
////		    System.out.println("Number of row Affected: "+ recordAffected);
//		    
//		    System.out.println("Record is inserted : ");
//		    
//		    String quaryInsert = "insert into Students (name ,age, marks) values ('Bheem', 2, 342)";
//		    
//		    int rowAffected = statement.executeUpdate(quaryInsert);
//		    
//		    System.out.println("Number of row affected : "+ rowAffected);
		    
		    System.out.println("Update the Records : ");
		    
		    String updateQuary = "Update Students set name = 'Vishal' where id=5";
		    
		    int rowAffected = statement.executeUpdate(updateQuary);
		    
		    System.out.println("Row affected : "+rowAffected);
		    
		    

			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
					resultSet.close();
					statement.close();
					System.out.println("Connection/resultSet/statement is closed");
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
