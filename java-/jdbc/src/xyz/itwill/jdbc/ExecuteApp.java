//05/15 - 3
package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {
	public static void main(String[] args) throws SQLException {
	/*	Connection con =ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		
		String sql1="update student set name='임걱정' where no=2000";
		int rows= stmt.executeUpdate(sql1);
		
		System.out.println("메세지:"+rows+"명의 학생정보를 변경하였습니다");
		System.out.println("======================================================");
		String sql2="select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+",이름 ="+rs.getString("name"));
		}
		System.out.println("======================================================");
		ConnectionFactory.close(con, stmt, rs);
	 */
		Connection con =ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		int choice=1;//내가 선택하는 값 select를 사용하고 싶다면 1이 아닌 값으로 저장하면된 
		String sql="";
		if(choice==1){
			 sql="update student set name='임꺽정' where no=2000";
		}else {
			 sql="select * from student order by no";
		}
		
		/*
		stmt.execute(sql);//executeUpdate : delete, update 등만 가능, executeQuerry : select 명령 전달 >> 전달해야하는 값이 명확하지 않을때 execute()사용
		 > false 반환 : DML명령 또는 DDL 명령을 전달하여 실행된 경우의 반환값
		 > true 반환 : select 명령을 전달하여 실행된 경우의 반환값
		 > 전달되어 실행될 SQL 명령이 명확하지 않은 경우 사용하는 메소드
		*/
		boolean result= stmt.execute(sql);//>choice = 1이므로 update DML/DDL 명령이 전달되면서 false 값이 result 값에 저장됨 
		
		if(result) {//select 명령이 전달되어 실행된 경우
			//statement.getResultSet() : Statement 객체로 전달되어 실행된 SELECT 명령의 처리 결과를 ResultSet 객체로 반환하는 메소드
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
				System.out.println("학번 = "+rs.getString("no")+"이름 = "+rs.getString("name"));	
			}
			
		}else {//DML 또는 DDL 명령이 전달되어 실행된 경우
			int rows=stmt.getUpdateCount();
			System.out.println("학생 정보 변경");
			ConnectionFactory.close(con,stmt);
		}
	}
		
		
}
