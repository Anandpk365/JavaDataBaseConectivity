package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc {
	
	private static Connection connection;

	private Jdbc() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		try {
			FileInputStream fis = new FileInputStream("D:\\Java full stack\\workspace\\02 - JDBC\\Properties\\application.properties");
			Properties properties = new Properties();
			properties.load(fis);
			
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("userName"), properties.getProperty("password"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void clean(Connection c, Statement s, ResultSet r ) {
		
		try {
			if(c != null)
				c.close();
			
			if( s!=null)
				s.close();
			
			if(r != null)
				r.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
