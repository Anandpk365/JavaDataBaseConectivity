package JavaJDBC;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;



public class JavaJDBC2 {

	private static final String url = "jdbc:mysql://localhost:3306/myDB";
	private static String user = "root";
	private static String password ="root";
	
	static Connection connection = null;
	static Statement statement = null;
	


	public static void main(String[] args) {


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class Loaded");

			connection = DriverManager.getConnection(url, user, password);
			
			System.out.println("Connection is done : ");
			
			statement = connection.createStatement();
			String q = "delete from Students where id >= 7 and id<=19";
			
			int deleted = statement.executeUpdate(q);
			System.out.println("number of row affected : "+deleted);
			
			Scanner sc = new Scanner(System.in);
			int rowAffected = 0;
			
			while(true) {
			System.out.println("Enter the name : ");
			String name = sc.nextLine();
			System.out.println("Enter the age : ");
			int age = sc.nextInt();
			System.out.println("Enter the marks  :");
			double marks = sc.nextDouble();
//			
//			String quary = "insert into Students (name, age, marks) values ('"+name+"',"+age+", "+marks+")";
			String quary = String.format("insert into Students ('name','age','marks') values ('%s','%d','%g') ", name,age,marks);
			System.out.println(quary);
			int row = statement.executeUpdate(quary);
			
			System.out.println("Do You wnat to Continue : ");
			int wants = sc.nextInt();
			rowAffected += row;
			if(wants == 0) {
				break;
			}
			
			
			
			}
			
			System.out.println("total rowAffected : "+ rowAffected);
			
			ResultSet resultSet = statement.executeQuery("Select * from Students");
			
			System.out.println("id\tname\tage\tmarks");
			
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				double marks = resultSet.getDouble(4);
				System.out.println(id+"\t"+name+"\t"+age+"\t"+marks);
			}
			
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
