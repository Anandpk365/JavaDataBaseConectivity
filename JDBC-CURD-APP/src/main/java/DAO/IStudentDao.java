package DAO;

import DTO.Student;

public interface IStudentDao {
	
	public String addStudent(Student student) ;

	public Student searchStudent(Integer rollNo);

	public String updateStudent(Student student);

	public String deleteStudent(Integer sid);

}
