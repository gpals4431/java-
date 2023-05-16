//05-16 -8

package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//모든 JDBC 기능의 DAO 클래스가 상속받아 사용하기 위한 부모클래스 - 테이블마다 dao가있음 컨넥션 풀 만드는 명령이 중복 될 수 있어서 생성
// >> DBCP 객체를 생성하여 미리 Connection 객체를 생성하고 DBCP 객체로부터 Connection객체를 반환하거나 JDBC 관련 객체를 매개변수로 전달받아 
// >> 객체 생성이 목적이 아닌 상속을 목적으로 작성된 클래스이므로 추상클래스로 선언하는 것을 권장

public abstract class JdbcDAO {// 추상클래스 - new 연산자로 객체 생성 불가능
	//PoolDataSource 객체(DBCP 객체)를 저장하기 위한 필드
	private static PoolDataSource pds;
	
	static {
		//PoolDataSource 객체를 반환받아 필드에 저장
		pds=PoolDataSourceFactory.getPoolDataSource();
		
		try {
			//PoolDataSource 객체를 생성하여 Connection 객체를 미리 생성하여 저장 - 컨넥션 10~20개까지 만들어짐
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			pds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			pds.setUser("scott");
			pds.setPassword("tiger");
			pds.setInitialPoolSize(10);
			pds.setMaxPoolSize(20);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PoolDataSource 객체(DBCP 객체)에 저장된 Connection 객체 중 하나를 반환하는 메소드
	public Connection getConnection() {
		Connection con =null;
		try {
			con=pds.getConnection();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//매개변수로 JDBC 관련 객체를 전달받아 제거하는 메소드
	public void close(Connection con) {
		try {
			//PoolDataSource 객체 제거 : PoolDataSource(DBCP 객체)에게 다시 Connection 객체를 되돌려주는 기능 제공
			if(con!=null)con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con,PreparedStatement pstmt) {
		try {
			//PoolDataSource 객체 제거 : PoolDataSource(DBCP 객체)에게 다시 Connection 객체를 되돌려주는 기능 제공
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con,PreparedStatement pstmt, ResultSet rs) {
		try {
			//PoolDataSource 객체 제거 : PoolDataSource(DBCP 객체)에게 다시 Connection 객체를 되돌려주는 기능 제공
			if(rs!=null)rs.close();				
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
