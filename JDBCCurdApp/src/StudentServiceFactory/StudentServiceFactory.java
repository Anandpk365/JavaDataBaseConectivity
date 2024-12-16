package StudentServiceFactory;

import Service.IStudentService;
import Service.StudentServiceImp;

public class StudentServiceFactory {
	
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService() {
		if(studentService == null) {
			studentService = new StudentServiceImp();
		}
		return studentService;
	}

}
