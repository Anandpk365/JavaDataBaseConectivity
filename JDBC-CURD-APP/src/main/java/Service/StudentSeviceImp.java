package Service;

import DAO.IStudentDao;
import DAOFactory.StudentDaoFactory;
import DTO.Student;

public class StudentSeviceImp implements IStudentService {

	private IStudentDao studentDao;

	@Override
	public String addStudent(Student student)  {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(student);
	}

	@Override
	public Student searchStudent(Integer rollNo) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(rollNo);
	}

	@Override
	public String updateStudent(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer rollNo) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(rollNo);
	}

}
