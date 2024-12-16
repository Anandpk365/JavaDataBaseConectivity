package JDBCUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC {
	
	private static Connection connection = null;
	
	private static String url = null;
	private static String user = null;
	private static String password = null;
	
	JDBC(){};
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver has been Loaded:- ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\Java full stack\\workspace\\JDBCPractice\\PropertiesFile\\PropertiesFile.properties");

		Properties properties = new Properties();
		properties.load(fis);
		
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		
		connection = DriverManager.getConnection(url, user, password);
		
		
		}catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void cleanUP(Connection con, Statement st, ResultSet rs) {
		try {
			if(con != null) {
				con.close();
			}
			
			if(st != null) {
				st.close();
			}
			
			if(rs != null) {
				rs.close();
			}
			System.out.println("Resouces are closed:-");
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
