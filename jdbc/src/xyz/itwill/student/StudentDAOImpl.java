//05-16 -7

package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO 클래스(DATA ACCESS OBJECT) : 저장매체에 행 단위 정보를 삽입, 삭제, 변경, 검색하는 기능을 제공하는 클래스
// >> 저장매체 : 정보를 행 단위로 저장하여 관리하기 위한 하드웨어 또는 소프트웨어 - DBMS
// >> 인터페이스를 상속받아 만드는 것을 권장 - 메소드 작성규칙 제공받을 수 있고 유지보수의 효율성 높일 수 있음
// >> 싱글톤 디자인 패턴을 적용하여 작성하는 것을 권장 - 프로그램에 하나의 객체만 제공되는 클래스

//student 테이블에 행을 삽입, 삭제, 변경, 검색하는 기능의 메소드를 제공하는 클래스
// >> DAO 클래스의 메소드는 SQL명령에 필요한 값을 객체(변수)로 전달받아 하나의 SQL명령을 DBMS 서버에 전달해서
//실행하고 실행결과를 JAVA 객체(값)으로 매핑하여 반환
// >> JdbcDAO 클래스를 상속받아 DAO 클래스의 메소드에서 JdbcDAO 클래스의 메소드 호출 가능
public class StudentDAOImpl extends JdbcDAO implements StudentDAO{
	private static StudentDAOImpl _dao;
	
	public StudentDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	static {
		_dao=new StudentDAOImpl();
	}
	public static StudentDAOImpl getDAO() {
		return _dao;
	}
	//학생 정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	@Override
	public int insertStudent(StudentDTO student) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql ="insert into student values(?,?,?,?,?)";// ?은 DTO로 채워줌
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("에러 : insertStudent 메소드의 SQL 오류 ="+e.getMessage());//매핑하여 반환
		}finally {
			close(con,pstmt);
		}
		return rows;
		
	}
	//학생 정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	@Override
	public int updateStudent(StudentDTO student) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql ="update student set name=?, phone=?, address=?, birthday=?, where no=?";
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("에러 : updateStudent 메소드의 SQL 오류 ="+e.getMessage());//매핑하여 반환
		}finally {
			close(con,pstmt);
		}
		return rows;
		
	}
	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	@Override
		public int deletStudent(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows=0;
		
		try {
			con=getConnection();
		
			String sql ="delete from student where no=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
		
			rows=pstmt.executeUpdate();
		
		}catch(SQLException e) {
			System.out.println("에러 : updateStudent 메소드의 SQL 오류 ="+e.getMessage());//매핑하여 반환
		}finally {
			close(con,pstmt);
		}
		return rows;

	
	}
	//학번은 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드
	@Override
	public StudentDTO selectStudent(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		StudentDTO student =null;
		
		try {
			con=getConnection();
			
			String sql ="select * from student where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			//ResultSet 객체에 저장된 검색행을 자바 객체(값)으로 매핑처리
			//if 문 = 검색행이 0 또는 1인 경우 사용
			if(rs.next()) {//검색행이 있는 경우
				student=new StudentDTO();
				//처리행의 컬럼값을 반환받아 DTO 객체의 필드값으로 변경 > 행을 객체로 만들어줌 = 매핑
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("Phone"));
				student.setAddress(rs.getString("Address"));
				student.setBirthday(rs.getString("Birthday").substring(0,10));
			}
				
		}catch(SQLException e) {
			System.out.println("에러 : selectStudent 메소드의 SQL 오류 ="+e.getMessage());//매핑하여 반환
		}finally {
			close(con,pstmt,rs);
		}
		//검색행이 없는 경우 null 반환하고 검색행이 있는 경우 DTO 객체 반환 - 검색행 하나를 반환 
		return student;
	
	}
	//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환하는 메소드 - 이름 중복 가능성 > 여러개 저장된 객체를 반환 > List 객체
	public List<StudentDTO> selectNameStudentList(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<>();
		try {
			con=getConnection();
			
			String sql="select * from student where name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			//검색행이 0개 이상인 경우 반복문 사용
			while(rs.next()) {
				//하나의 검색행을 DTO 객체로 매핑 처리
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				//DTO 객체를 List 객체의 요소로 추가 
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNameStudentList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	@Override
	public List<StudentDTO> selectnameStudentList(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<StudentDTO> studentList = new ArrayList<>();
		
		try {
			con=getConnection();
			
			String sql ="select * from student";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			//검색행이 0개 이상인 경우 반복문 사용
			while(rs.next()) {
				//하나의 검색행을 DTO 객체로 매핑 처리
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("Phone"));
				student.setAddress(rs.getString("Address"));
				student.setBirthday(rs.getString("Birthday").substring(0,10));
				
				//List 객체에 DTO 객체를 요소로 추가 
				studentList.add(student);
				
			}
				
		}catch(SQLException e) {
			System.out.println("에러 : selectStudent 메소드의 SQL 오류 ="+e.getMessage());//매핑하여 반환
		}finally {
			close(con,pstmt,rs);
		}
		//검색행이 없는 경우 null 반환하고 검색행이 있는 경우 DTO 객체 반환 - 검색행 하나를 반환 
		return studentList;
	}
	@Override
	public List<StudentDTO> selectallStudentList() {
		// TODO Auto-generated method stub
		return null;
	}
}
