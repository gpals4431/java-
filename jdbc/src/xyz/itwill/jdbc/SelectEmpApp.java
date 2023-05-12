//8
package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//emp테이블에 저장된 모든 사원정보의 사원번호, 사원이름, 급여를 급여로 내림차순 정렬되도록 검색하여 출력하는 jdbc 프로그램 작성
public class SelectEmpApp {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String password = "tiger";
			con=DriverManager.getConnection(url, user, password);
			
			con.setAutoCommit(false);
			stmt=con.createStatement();
			
			//if(con!=null)throw new Exception(); 
			
			String sql="select empno,ename,sal from emp order by sal desc";
			
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("메세지: 검색된 사원정보가 있습니다.");
				
				do {
					int empno=rs.getInt("empno");
					String ename=rs.getString("ename");
					int sal=rs.getInt("sal");
					
					System.out.println("사원번호 = "+empno);
					System.out.println("사원이름 = "+ename);
					System.out.println("급여 = "+sal);
					System.out.println("-------------------------------------");
				}while(rs.next());
			}else {
				System.out.println("검색된 사원정보가 없음");
			}
			
			con.commit();
			
		}catch(ClassNotFoundException e) {
			System.out.println("에러 : oracleDriver 찾을 수 없음");

		}catch(SQLException e) {
			System.out.println("에러 : jdbc 관련 오류 "+e.getMessage());

		}catch(Exception e) {
			System.out.println("프로그램에 예기치 못한 오류 발생");
			
			try {
				con.rollback();
			}catch(SQLException exception) {
				
			}
		}finally {
			try {
				if(rs!=null); rs.close();
				if(stmt!=null); stmt.close();
				if(con!=null);con.close();
			}catch(SQLException e) {
				
			}
		}
	}
}
