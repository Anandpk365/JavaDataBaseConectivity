package Project_01_JDBC_ConsoleBased;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayAllRecords {
	
	private static Connection connection = null;
	private static PreparedStatement prstm = null;
	private static ResultSet resultSet = null;
	
	public static void display() throws IOException, SQLException {
		connection  = JDBCConnection.getConnection();
		
		String quary ="Select * from emp";
		if(connection != null) {
			prstm = connection.prepareStatement(quary);
			
			resultSet = prstm.executeQuery();
			
		}
		
		System.out.println("sID\t\tsName\t\tsAge\t\tsAddress");
		if(resultSet != null) {
			while(resultSet.next()) {
				
				System.out.println(resultSet.getInt(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getInt(3)+"\t\t"+resultSet.getString(4));
			}
		}
	}

}
