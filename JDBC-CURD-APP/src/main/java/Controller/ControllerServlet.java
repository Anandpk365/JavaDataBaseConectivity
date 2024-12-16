package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Student;
import Service.IStudentService;
import ServiceFactory.StudentServiceFactory;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IStudentService studentService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform")) {

			String sRollNo = request.getParameter("srollNo");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setRollNo(Integer.valueOf(sRollNo));
			student.setName(sname);
			student.setAge(Integer.valueOf(sage));
			student.setAddress(saddr);

			String status = studentService.addStudent(student);
			RequestDispatcher rd = null;
			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../success.html");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../failure.html");
				rd.forward(request, response);
			}
		}

		if (request.getRequestURI().endsWith("searchform")) {
			String rollNo = request.getParameter("srollNo");

			Student student = studentService.searchStudent(Integer.parseInt(rollNo));
			PrintWriter out = response.getWriter();
			if (student != null) {
				out.println("<body>");
				out.println("<br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>ROLLNo</th><td>" + student.getRollNo() + "</td></tr>");
				out.println("<tr><th>NAME</th><td>" + student.getName() + "</td></tr>");
				out.println("<tr><th>AGE</th><td>" + student.getAge() + "</td></tr>");
				out.println("<tr><th>ADDRESS</th><td>" + student.getAddress() + "</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
			} else {
				out.println("<h1 style='color:red;text-align:center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID " + rollNo
						+ "</h1>");
			}
			out.close();
		}
		
		if (request.getRequestURI().endsWith("editform")) {
			String rollNo = request.getParameter("rollNo");

			Student student = studentService.searchStudent(Integer.parseInt(rollNo));
			PrintWriter out = response.getWriter();
			if (student != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				out.println("<form method='post' action='./controller/updateRecord'>");
				out.println("<table>");
				out.println("<tr><th>ROLLNo</th><td>" + student.getRollNo() + "</td></tr>");
				out.println("<input type='hidden' name='rollNo' value='" + student.getRollNo() + "'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='name' value='" + student.getName()
						+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='age' value='" + student.getAge()
						+ "'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name='addr' value='" + student.getAddress()
						+ "'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			} else {
				// display not found message
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + rollNo
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("updateRecord")) {
			String srollNo = request.getParameter("rollNo");
			String sname = request.getParameter("name");
			String sage = request.getParameter("age");
			String saddr = request.getParameter("addr");

			Student student = new Student();
			student.setRollNo(Integer.parseInt(srollNo));
			student.setAddress(saddr);
			student.setName(sname);
			student.setAge(Integer.parseInt(sage));

			String status = studentService.updateStudent(student);
			RequestDispatcher rd = null;

			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../../updatesuccess.html");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../../updatefailure.html");
				rd.forward(request, response);
			}

		}
		
		if (request.getRequestURI().endsWith("deleteform")) {
			String rollNo = request.getParameter("rollNo");
			String status = studentService.deleteStudent(Integer.parseInt(rollNo));
			RequestDispatcher rd = null;
			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../deletesuccess.html");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				rd = request.getRequestDispatcher("../deletefailure.html");
				rd.forward(request, response);

			} else {
				rd = request.getRequestDispatcher("../deletenotfound.html");
				rd.forward(request, response);

			}
		}

	}

}
