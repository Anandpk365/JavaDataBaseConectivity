package Project_01_JDBC_ConsoleBased;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TotallNumberRecords {
	
	private static Connection connection = null;
	private static PreparedStatement prstm = null;
	private static ResultSet resultSet = null;
	
	public static int totalNumberRecords() throws IOException, SQLException {
		int rowCount = 0;
		connection = JDBCConnection.getConnection();
		
		String quary = "Select * from emp";
		if(connection != null)
		{
			prstm = connection.prepareStatement(quary);
			resultSet = prstm.executeQuery();
		}
	
		if(resultSet!=null) {
			while(resultSet.next()) {
				rowCount++;
			}
		}
		
		return rowCount;
	}

}
