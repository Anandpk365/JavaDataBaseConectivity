package Project_01_JDBC_ConsoleBased;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateOperation {
	
	private static Connection connection = null;
	private static PreparedStatement prstm = null;
	private static ResultSet resultSet = null;
	private static int rowAffected = 0;
	
	public static void update(int id, String name) throws IOException, SQLException {
		connection = JDBCConnection.getConnection();
		
		String quary = "Select * from emp where id = ?";
		if(connection != null) {
			prstm = connection.prepareStatement(quary);
			prstm.setInt(1, id);
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
		
		quary = "update emp set name = ? where id = ?";
		if(connection != null) {
			prstm = connection.prepareStatement(quary);
			prstm.setInt(2, id);
			prstm.setString(1, name);
			rowAffected = prstm.executeUpdate();
		}
		
		if(rowAffected != 0) {
			System.out.println("Record Successfully Updated");
		}else {
			System.out.println("Failed to update");
		}
		
	}

}
