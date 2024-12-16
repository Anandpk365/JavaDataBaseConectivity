package DateOperation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Project_01_JDBC_ConsoleBased.JDBCConnection;

public class Display {
	

	

	public static void main(String[] args)  {
		
		 Connection connection = null;
	     PreparedStatement pstm = null;
	     ResultSet resultSet = null;

		try {
			connection = JDBCConnection.getConnection();
			
			String quary = "Select * from empdate";
			if(connection != null) {
				pstm = connection.prepareStatement(quary);
//				pstm.setInt(1, 2);

				if(pstm != null) {

					resultSet = pstm.executeQuery();
					if(resultSet!=null) {
						System.out.println("Before formatiing changing ");
						System.out.println("id\t\tname\t\tdoj\t\tdoe");
						while(resultSet.next()) {
							int id = resultSet.getInt(1);
							String name = resultSet.getString(2);
							java.sql.Date doj = resultSet.getDate(3);
							java.sql.Date doe = resultSet.getDate(4);
							
							System.out.println(id+"\t\t"+name+"\t\t"+doj+"\t\t"+doe);
							
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							String dOJ = sdf.format(doj);
							String dOE = sdf.format(doe);
							
							System.out.println(id+"\t\t"+name+"\t\t"+dOJ+"\t\t"+dOE);
						}
					}
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.cleanUP(connection, pstm, resultSet);
		}

	}

}
