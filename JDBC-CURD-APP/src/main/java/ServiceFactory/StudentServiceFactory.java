package ServiceFactory;

import Service.IStudentService;
import Service.StudentSeviceImp;

public class StudentServiceFactory {
	
	private StudentServiceFactory() {
		
	}
	
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService() {
		if(studentService==null) {
			studentService = new StudentSeviceImp();
		}
		
		return studentService;
	}

}
