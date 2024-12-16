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



public class jdbcUtil {
	
	private static Connection connection = null;
	
	private jdbcUtil(){
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public static Connection getConnection() {
		
		try {
			FileInputStream fis = new FileInputStream("D:\\Java full stack\\workspace\\01 - JDBC\\Properties\\application.properties");
			Properties properties = new Properties();
			properties.load(fis);
			
			String url = properties.getProperty("url");
			String userName = properties.getProperty("userName");
			String password = properties.getProperty("password");
			
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void clean(Connection c, Statement s, ResultSet r) {
		
		try {
			if(c != null) {
				c.close();
			}
			
			if(s != null) {
				s.close();
			}
			
			if(r != null) {
				r.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	


}
