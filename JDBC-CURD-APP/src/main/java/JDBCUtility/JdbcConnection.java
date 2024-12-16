package JDBCUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConnection {

	private static FileInputStream fis;
	private static String url;
	private static String user;
	private static String password;
	private static Connection connection;

	private JdbcConnection() {

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
			fis = new FileInputStream(
					"D:\\Java full stack\\workspace\\JDBC-CURD-APP\\src\\main\\java\\Properties\\application.properties");
			Properties properties = new Properties();
			properties.load(fis);

			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");

			connection = DriverManager.getConnection(url, user, password);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void clean(Statement s, Connection c, ResultSet r) {
		try {
			if (s != null) {
				s.close();
			}

			if (c != null) {
				c.close();
			}

			if (r != null) {
				r.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
