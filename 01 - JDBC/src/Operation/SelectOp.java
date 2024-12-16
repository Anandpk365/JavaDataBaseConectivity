package Operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Util.jdbcUtil;

public class SelectOp {
	
    private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
    
    public static void select() throws SQLException {
    	
    	Scanner sc = new Scanner(System.in);
    	connection = jdbcUtil.getConnection();
    	System.out.println("Connection is Established");
    	
    	if(connection != null) {
    		statement = connection.createStatement();
    		System.out.println("Statement Object is created");
    	}
    	
    	System.out.println("Please enter the ID: ");
    	int id = sc.nextInt();
    	
    	String quary = String.format("Select * from employee where id = '%d'", id);
    	
    	resultSet = statement.executeQuery(quary);
    	System.out.println("Quary is executed");
    	
    	if(resultSet != null) {
    		System.out.println("id\tname\tsalary");
    		while(resultSet.next()) {
    			int id1 = resultSet.getInt(1);
    			String name = resultSet.getString(2);
    			double salary = resultSet.getDouble(3);
    		
    			System.out.println(id1+"\t"+name+"\t"+salary);
    		}
    	}else {
    		System.out.println("Record is not available");
    	}
    	
    	jdbcUtil.clean(connection, statement, resultSet);

   }
}
