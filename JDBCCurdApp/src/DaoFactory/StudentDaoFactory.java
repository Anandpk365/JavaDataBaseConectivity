package DaoFactory;

import StudentDAO.IStudentDao;
import StudentDAO.StudentDaoImp;

public class StudentDaoFactory {
	
	private StudentDaoFactory ( ) {}
	
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudent() {
		if(studentDao == null) {
			studentDao = new StudentDaoImp();
		}
		
		return studentDao;
	}

}
