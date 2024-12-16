package StudentDAO;


public interface IStudentDao {
	
	public String addStudent(int rollNo, String name,float wieght, String passYear, String imageLoc, String pdfLoc);
	
	public String searchStudent(int rollNo);
	
	public String updateStudent(int rollNo, String name,float wieght, String passYear, String imageLoc, String pdfLoc);
	
	public String deleteStudent(int rollNo);

}
