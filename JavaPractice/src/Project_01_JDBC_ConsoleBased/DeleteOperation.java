package Project_01_JDBC_ConsoleBased;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteOperation {
	
	private static Connection connection = null;
	private static PreparedStatement prstm = null;
	private static int rowAffected = 0;
	
	public static void delete (int id) throws IOException, SQLException {
		connection = JDBCConnection.getConnection();
		
		String quary = "Delete from emp where id = ?";
		if(connection != null) {
			prstm = connection.prepareStatement(quary);
			prstm.setInt(1, id);
			rowAffected = prstm.executeUpdate();
		}
		
		if( rowAffected !=0) {
			System.out.println("Deleted successfully");
		}else {
			System.out.println("failed to delete");
		}
	}

}
