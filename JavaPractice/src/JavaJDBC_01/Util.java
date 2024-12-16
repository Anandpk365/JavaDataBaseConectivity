package JavaJDBC_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Util {
	

//	private static final String url = "jdbc:mysql://localhost:3306/myDB";
//	private static final String user = "root";
//	private static final String password = "root";
	

	private static Connection connection = null;
//	private static Statement statement = null;

	
	
	private Util(){
		
	}
	
	static {
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is Loaded  :");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	

	
	public static Connection getConnection() throws SQLException, IOException {
		FileInputStream fis = new FileInputStream("D:\\Java full stack\\workspace\\JavaPractice\\PropertiesFile\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		connection = DriverManager.getConnection(url, user , password);
		return connection;
	}
	
	public static void cleanUp(ResultSet r, Statement s, Connection c) {
		try {
			if(r!=null)
				r.close();
			if(s!=null)
				s.close();
			if(c!=null)
				c.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
