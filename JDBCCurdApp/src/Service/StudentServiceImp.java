package Service;


import DaoFactory.StudentDaoFactory;
import StudentDAO.IStudentDao;

public class StudentServiceImp implements IStudentService{


	private IStudentDao studentDao = null;
	
	public String addStudent(int rollNo, String name, float wieght, String passYear, String imageLoc, String pdfLoc) {
		studentDao = StudentDaoFactory.getStudent();
		return studentDao.addStudent(rollNo, name, wieght, passYear, imageLoc, pdfLoc);
	}
	
	public String searchStudent(int rollNo) {
		studentDao = StudentDaoFactory.getStudent();
		return studentDao.searchStudent(rollNo);
	}
	
	public String updateStudent(int rollNo, String name, float wieght, String passYear, String imageLoc, String pdfLoc) {
		studentDao = StudentDaoFactory.getStudent();
		return studentDao.updateStudent(rollNo, name, wieght, passYear, imageLoc, pdfLoc);
	}
	
	public String deleteStudent(int rollNo) {
		studentDao = StudentDaoFactory.getStudent();
		return studentDao.deleteStudent(rollNo);
	}

}
