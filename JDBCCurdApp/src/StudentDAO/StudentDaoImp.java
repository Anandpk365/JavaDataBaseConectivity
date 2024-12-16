package StudentDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.IOUtils;

import Util.JDBCUtil;


public class StudentDaoImp implements IStudentDao {
	
	private Connection connection = null;
	private PreparedStatement pst = null;
	private ResultSet resultSet = null;
	
	public String addStudent(int rollNo, String name, float wieght, String passYear, String imageLoc, String pdfLoc) {
		connection = JDBCUtil.getConnection();
		
		try {
			String insertQuary = "insert into students (roll, name, weight, passYear, image, pdf) values(?, ?, ?, ?, ?, ?)";
			
			if(connection != null) {
				pst = connection.prepareStatement(insertQuary);
			}
			
			if(pst != null) {
				pst.setInt(1, rollNo);
				pst.setString(2, name);
				
				pst.setFloat(3, wieght);
				
				//String format to Java.Sql.Date format conversion (Date)
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date uDate =sdf.parse(passYear);
				
				long l = uDate.getTime();
				java.sql.Date sDate = new java.sql.Date(l);
				
				pst.setDate(4, sDate);
				
				pst.setBinaryStream(5, new FileInputStream(new File(imageLoc)));
				
				pst.setCharacterStream(6, new FileReader(new File(pdfLoc)));
				
				int rowAffected = pst.executeUpdate();
				
				if(rowAffected == 1)
					return "Success";
				
				
			}
		}catch(SQLException | ParseException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return "Failure";
	}
	
	public String searchStudent(int rollNo)  {
		connection = JDBCUtil.getConnection();
		
		try {
			String searchQuary = "Select * from students where roll =?";
			
			if(connection != null) {
				pst = connection.prepareStatement(searchQuary);
			}
			
			if(pst != null) {
				pst.setInt(1, rollNo);
				
				resultSet = pst.executeQuery();
			}
			
			System.out.println("RollNo\t\tname\t\tweight\t\tpassYear\t\timageLoc\t\tpdfLoc");
			
		    if(resultSet!=null) {

				int roll = resultSet.getInt(1);
				String name = resultSet.getString(2);
				float weight = resultSet.getFloat(3);
	
				
				java.sql.Date sdate = resultSet.getDate(4);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String passYear = sdf.format(sdate);

					InputStream is = resultSet.getBinaryStream(5);
					File file = new File("D:\\copied.jpg");
					FileOutputStream fos = new FileOutputStream(file);

					// copying the data from is to fos
					IOUtils.copy(is, fos);
					 
					 Reader reader = resultSet.getCharacterStream(6);
					 File f = new File("D:\\copiedd.txt");
					 
					 FileWriter fw =new FileWriter(f);
					 
					 IOUtils.copy(reader, fw);
					 
					 System.out.println(roll+"\t\t"+name+"\t\t"+weight +"\t\t"+passYear+"\t\t"+file.getAbsolutePath()+"\t\t"+f.getAbsolutePath());
					 
					 return "Success";

		    }
		}catch(SQLException | IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Failure";
	}
	
	public String updateStudent(int rollNo, String name,float wieght, String passYear, String imageLoc, String pdfLoc) {
		return null;
	}
	
	public String deleteStudent(int rollNo) {
		return null;
	}

}
