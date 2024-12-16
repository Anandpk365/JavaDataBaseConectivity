package DateOperation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Project_01_JDBC_ConsoleBased.JDBCConnection;

public class JDBCInsertionOperation {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		java.sql.Date dojDate = null;
		java.sql.Date doeDate = null;
		
		String name = null;
		String doj = null;
		String doe = null;
		
		Scanner sc = null;
		
		try {
			connection = JDBCConnection.getConnection();
		
		String quary = "Insert into empDate (name, doj, doe) values (?, ?, ?)";
		if(connection != null) {
			
				pstmt = connection.prepareStatement(quary);
				if(pstmt != null) {
					sc = new Scanner(System.in);
					if(sc != null) {
						System.out.println("Enter the name of employee : ");
						name = sc.next();
						
						System.out.println("Enter the joining date (MM-dd-yyyy) : ");
						doj = sc.next();
						
						System.out.println("Enter the ending date (yyyy-MM-dd) : ");
						doe = sc.next();
					}
					
					if(doj != null) {
						SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
						java.util.Date uDate = sdf.parse(doj);
			
						long value = uDate.getTime();
						
						dojDate = new java.sql.Date(value);
						
					}
					
					if(doe != null) {
						doeDate = java.sql.Date.valueOf(doe);
					}
					
					pstmt.setString(1, name);
					pstmt.setDate(2, dojDate);
					pstmt.setDate(3, doeDate);
					
					int rowAffected = pstmt.executeUpdate();
					System.out.println("number of row Afected : "+rowAffected);
				}

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}catch(ParseException  e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCConnection.cleanUP(connection, pstmt, resultSet);
			sc.close();
		}

	}

}
