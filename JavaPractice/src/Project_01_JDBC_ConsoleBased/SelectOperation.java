package Project_01_JDBC_ConsoleBased;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectOperation {
	
	private static ResultSet resultSet = null;
	private static Connection connection = null;
	private static PreparedStatement prstm = null;
	
	public static void select(int choice) throws IOException, SQLException {
		connection = JDBCConnection.getConnection();
		
		String quary = "Select * from emp where id = ?";
		if(connection != null) {
			prstm = connection.prepareStatement(quary);
			prstm.setInt(1, choice);
			resultSet = prstm.executeQuery();
		}
		
		
		if(resultSet!=null) {
			if(resultSet.next()) {
				System.out.println("sID\t\tsName\t\tsAge\t\tsAddress");
				System.out.println(resultSet.getInt(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getInt(3)+"\t\t"+resultSet.getString(4));
			}else {
				System.out.println("Record not available for given ID ");
			}
		}
	}

}
