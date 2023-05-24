//05-16 -6

package xyz.itwill.student;

import java.util.List;

//DAO 클래스가 상속받기 위한 인터페이스
// >> 추상메소드를 선언하여 인터페이스를 상속받은 모든 자식 클래스(DAO 클래스)가 동일한 메소드가 선언되도록 메소드의 
// 작성 규칙 제공
// >> DAO 클래스가 변경되더라도 프로그램에 영향을 최소화하기 위해 인터페이스 선언 >> 결합도 낮춤
// >> 인터페이스는 추상메소드 = 명령이 없는 메소드 를 이용하여 규칙을 제공

public interface StudentDAO {

	// 학생 정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	int insertStudent(StudentDTO student);

	// 학생 정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	int updateStudent(StudentDTO student);

	// 학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	int deleteStudent(int no);

	// 학번은 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드
	// >> 일반적으로 단일행은 값 또는 DTO 객체 반환, 학번은 고유값 
	StudentDTO selectStudent(int no);

	// 이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환하는 메소드 - 이름 중복 가능성 > 여러개 저장된
	// 객체를 반환 > List 객체
	// >> 다중행은 무조건 List 객체 반환
	List<StudentDTO> selectNameStudentList(String name);

	// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	List<StudentDTO> selectAllStudentList();

}
