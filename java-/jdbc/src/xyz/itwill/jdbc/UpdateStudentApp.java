//4
package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


//student 테이블에 저장된 학생정보 중 학번이 [2000]인 학생의 이름을 [임걱정]으로 변경하고 주소를 [부천시 원미구]로 변경하는 JDBC프로그램 작성
public class UpdateStudentApp {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		
		try {
			//OracleDriver >> 자동으로 import됨 import된 클래스 가져다 쓰기만 하면됨
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password="tiger";
		
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.createStatement();
			
			
			String sql="update student set name='임걱정',address ='부천시 원미구' where no=2000 ";
			
			int rows=stmt.executeUpdate(sql);
			//오라클에서 UPDATE를 하면 트렌젝션에 학생정보가 조작이 되어서 데이터 락이 걸림 >> 따라서 JDBC에서 명령을 실행할 수 없음 > 커밋이나 롤백 후 명령 실행
			
			System.out.println("[메세지]"+rows+"명의 학생정보를 변경하였습니다.");
			
		}catch(ClassNotFoundException e) {
			System.out.println("에러 : OracleDriver 클래스를 찾을 수 없습니다.");
		
		}catch(SQLException e) {
			System.out.println("에러 : JDBC 관련 오류 = "+e.getMessage());
	
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(con != null)con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
