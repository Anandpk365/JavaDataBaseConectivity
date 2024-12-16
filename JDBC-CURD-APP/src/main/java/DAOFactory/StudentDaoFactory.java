package DAOFactory;

import DAO.IStudentDao;
import DAO.StudentDaoImp;

public class StudentDaoFactory {

	private StudentDaoFactory() {

	}

	private static IStudentDao studentDao = null;

	public static IStudentDao getStudentDao() {

		if (studentDao == null) {
			studentDao = new StudentDaoImp();
		}
		return studentDao;
	}

}
