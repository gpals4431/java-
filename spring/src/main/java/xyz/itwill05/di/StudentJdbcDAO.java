package xyz.itwill05.di;

import java.util.List;

/* DAO Ŭ���� : ���� ��ü(File, DBMS ��)�� �࿡ ���� ����, ����, ����, �˻� ��� ����
=> �����ü�� ���� �Ǵ� ����� ���� DAO Ŭ���� ���� ����
=> DAO Ŭ������ ����Ǿ DAO Ŭ������ ����ϴ� Ŭ����(Service Ŭ����)�� ������ �ּ�ȭ�ϱ� ����
�ݵ�� �������̽��� ��ӹ޾� �ۼ� - ���յ��� ���� ���������� ȿ���� ���� */
public class StudentJdbcDAO implements StudentDAO {
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** StudentJdbcDAO Ŭ������ deleteStudent �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO Ŭ������ insertStudent �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudent �޼ҵ� ȣ�� ***");
		return null;

	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudentList �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** StudentJdbcDAO Ŭ������ updateStudent �޼ҵ� ȣ�� ***");
		return 0;
	}
}
