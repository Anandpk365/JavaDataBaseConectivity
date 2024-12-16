package Project_01_JDBC_ConsoleBased;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {
	
	private static Connection connection = null;
	private JDBCConnection() {
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class is Loaded successfully..");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	public static Connection getConnection() throws IOException, SQLException {
		FileInputStream fis = new FileInputStream("D:\\Java full stack\\workspace\\JavaPractice\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		connection = DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	

	
	public static void cleanUP(Connection c, PreparedStatement ps, ResultSet r) {
		try {
			if(c != null) {
				c.close();
			}
			
			if(ps != null) {
				ps.close();
			}
			
			if(r != null) {
				r.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


}


//public static Connection getConnection() throws IOException, SQLException {
//	FileInputStream fis = new FileInputStream("D:\\Java full stack\\workspace\\JavaPractice\\application.properties");
//	Properties properties = new Properties();
//	properties.load(fis);
//	
//	String url = properties.getProperty("url");
//	String user = properties.getProperty("user");
//	String password = properties.getProperty("password");
//	connection = DriverManager.getConnection(url, user, password);
//	
//	return connection;
//}
