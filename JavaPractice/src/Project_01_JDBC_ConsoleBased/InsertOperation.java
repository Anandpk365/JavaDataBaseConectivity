package Project_01_JDBC_ConsoleBased;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertOperation {
	
	private static Connection connection = null;
	private static PreparedStatement prstm = null;
	private static int rowAffected = 0;
	
	public static void insert(int id, String name, String doj, String doe, String image, String pdf) throws IOException, SQLException, ParseException {
		connection = JDBCConnection.getConnection();
		
		String quary = "insert into student(id, name, doj, doe, image, pdf) values (?, ?, ?, ?, ?, ?)";
		if(connection != null) {
			prstm = connection.prepareStatement(quary);
			prstm.setInt(1, id);
			prstm.setString(2, name);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			java.util.Date doj1 = sdf.parse(doj);
			
			long value = doj1.getTime();
			
			java.sql.Date date = new java.sql.Date(value);
			prstm.setDate(3, date);
			
			java.util.Date doj2 = sdf.parse(doe);
			
			long value1 = doj2.getTime();

			java.sql.Date date1 = new java.sql.Date(value1);
			
			prstm.setDate(4, date1);
			
			prstm.setBinaryStream(5, new FileInputStream(new File(image)));
			
			prstm.setCharacterStream(6, new FileReader(new File(pdf)));;

			

			
			rowAffected = prstm.executeUpdate();
			
			
		}
		
		if(rowAffected != 0) {
			System.out.println("Inserted Successfully");
		}else {
			System.out.println("Failed to insert");
		}
	}

}
