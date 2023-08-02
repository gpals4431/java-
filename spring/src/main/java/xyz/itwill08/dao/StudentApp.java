package xyz.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("08_dao.xml");
		StudentService service = context.getBean("studentService", StudentService.class);
		System.out.println("==========================================================");
		/*
		 * Student newStudent = new Student(); newStudent.setNo(9000);
		 * newStudent.setName("ȫ�淡"); newStudent.setPhone("010-1111-1111");
		 * newStudent.setAddress("����� ������"); newStudent.setBirthday("1999-01-01");
		 * service.addStudent(newStudent);
		 */
		
		service.removeStudent(9000);
		
		List<Student> studentList = service.getStudentList();
		for (Student student : studentList) {
			System.out.println("�й�=" + student.getNo() + ", �̸� =" + student.getName()+ 
					", ��ȣ =" + student.getPhone() +
					", �ּ� =" + student.getAddress() +
					", ������� =" + student.getBirthday().substring(0, 10));
		}

		((ClassPathXmlApplicationContext) context).close();

	}
}
