//05-16 -7

package xyz.itwill.student;

import java.util.List;

//DAO 클래스(DATA ACCESS OBJECT) : 저장매체에 행 단위 정보를 삽입, 삭제, 변경, 검색하는 기능을 제공하는 클래스
// >> 저장매체 : 정보를 행 단위로 저장하여 관리하기 위한 하드웨어 또는 소프트웨어 - DBMS
// >> 인터페이스를 상속받아 만드는 것을 권장 - 메소드 작성규칙 제공받을 수 있고 유지보수의 효율성 높일 수 있음


//student 테이블에 행을 삽입, 삭제, 변경, 검색하는 기능의 메소드를 제공하는 클래스
// >> DAO 클래스의 메소드는 SQL명령에 필요한 값을 객체(변수)로 전달받아 하나의 SQL명령을 DBMS 서버에 전달해서
//실행하고 실행결과를 JAVA 객체(값)으로 매핑하여 반환
public class StudentDAOImpl implements StudentDAO{
	
	
	
	@Override
	public int insertStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return 0;
		
	}
	@Override
	public int deletStudent(int no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int updateStudent(StudentDTO student) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<StudentDTO> selectallStudentList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public StudentDTO selectStudent(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<StudentDTO> selectnameStudentList(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
