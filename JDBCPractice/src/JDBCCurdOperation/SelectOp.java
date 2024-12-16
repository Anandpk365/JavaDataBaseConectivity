package JDBCCurdOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JDBCUtil.JDBC;

public class SelectOp {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		connection = JDBC.getConnection();
		System.out.println("Connection is Established ");
		
		if(connection != null) {
			try {
				statement = connection.createStatement();
				
				System.out.println(statement.getClass().getName());
				
				String quary = "Select * from student";
				if(statement != null) {
					resultSet = statement.executeQuery(quary);
				}
				
				if(resultSet != null) {
					System.out.println("Rollno\t\tname\t\tmarks");
					while(resultSet.next()) {
						int roll = resultSet.getInt(1);
						String name = resultSet.getString(2);
						float marks = resultSet.getFloat(3);
						
						System.out.println(roll+"\t\t"+name+"\t\t"+marks);
					}
				}
				else {
					System.out.println("Records are not available:");
				}
			} catch (SQLException e) {
		       e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBC.cleanUP(connection, statement, resultSet);
			}
		}
		

	}

}
