package JDBCCurdOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import JDBCUtil.JDBC;

public class InsertOp {

	public static void main(String[] args)  {
		
		Connection connection = null;
		Statement st = null;
		Scanner sc = null;
		
		int rowAffected = 0;
		
		try {
		    connection  = JDBC.getConnection();
		    System.out.println("Connection is Established");
		    
		    if(connection != null) {
		    	st = connection.createStatement();
		    	sc = new Scanner(System.in);
		    	if(st != null) {
		    		
		    		System.out.println("Enter the roll");
		    		int rollno = sc.nextInt();
		    		
		    		System.out.println("Enter the name : ");
		    		String name = sc.next();
		    		
		    		System.out.println("Enter the marks : ");
		    		float marks = sc.nextFloat();
		    		
		    		String quary = String.format("insert into student (roll,name, marks) values ('%d', '%s', '%f')", rollno, name, marks);
		    		
		    		rowAffected = st.executeUpdate(quary);
		    		
		    	}
		    	
		    	System.out.println("Row affected : "+ rowAffected);
		    	}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		
				JDBC.cleanUP(connection, st, null);

		}
	    
	}

}
