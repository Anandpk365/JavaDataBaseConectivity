package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	private static Connection connection = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		
		try {
			FileInputStream fis = new FileInputStream("D:\\Java full stack\\workspace\\JDBCCurdApp\\src\\Properties\\PropertiesFile.properties");
			Properties properties =new Properties();
			properties.load(fis);
			
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
			connection = DriverManager.getConnection(url, user, password);
			
			
		}catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void cleanUp(Connection c, Statement st, ResultSet rs) {
		try {
			if(c != null) {
				c.close();
			}
			
			if(st != null) {
				st.close();
			}
			
			if(rs != null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
