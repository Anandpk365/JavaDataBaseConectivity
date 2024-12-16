package Controller;

import java.util.Scanner;

import Service.IStudentService;
import StudentServiceFactory.StudentServiceFactory;

public class TestCurdAPP {

	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = null;
	
		while(true) {
			
			System.out.println("Please select the choice below : ");
			choice = sc.nextInt();
			System.out.println("addStudent : 1");
			System.out.println("searchStudent : 2");
			System.out.println("updateStudent : 3");
			System.out.println("deleteStudent : 4");
			System.out.println("Exit: 0");
			
			switch(choice) {
			case 1:  msg = studentService.addStudent(3, "Ajay", 32.5f, "06-08-1999", "D:\\Passpost Size Photo.JPG", "D:\\new 1.txt");
			
					if(msg.equalsIgnoreCase("success")) {
						System.out.println("SuccessFully inserted");
					}else {
						System.out.println("Failed inserted");
					}
				    break;
				    
			 case 2:  msg = studentService.searchStudent(2);
			 
					  if(msg.equalsIgnoreCase("success")) {
						  System.out.println("SuccessFully Deleted");
					  }else {
						  System.out.println("Failed Deleted");
					  }
					  break;
			 case 3:
			}

		}

	}

}
