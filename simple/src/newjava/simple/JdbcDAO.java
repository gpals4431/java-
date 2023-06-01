package newjava.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public abstract class JdbcDAO {// 추상클래스 - new 연산자로 객체 생성 불가능
	// PoolDataSource 객체(DBCP 객체)를 저장하기 위한 필드
	private static PoolDataSource pds;

	static {
		// PoolDataSource 객체를 반환받아 필드에 저장
		pds = PoolDataSourceFactory.getPoolDataSource();

		try {
			// PoolDataSource 객체를 생성하여 Connection 객체를 미리 생성하여 저장 - 컨넥션 10~20개까지 만들어짐
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			pds.setURL("jdbc:oracle:thin:@www.itwill.xyz:1521:xe");
			pds.setUser("jdbc_team02");
			pds.setPassword("jdbc_team02");
			pds.setInitialPoolSize(10);
			pds.setMaxPoolSize(20);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// PoolDataSource 객체(DBCP 객체)에 저장된 Connection 객체 중 하나를 반환하는 메소드
	public Connection getConnection() {
		Connection con = null;
		try {
			con = pds.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;// 10개 중 하나를 제공받음
	}

	// 매개변수로 JDBC 관련 객체를 전달받아 제거하는 메소드
	public void close(Connection con) {
		try {
			// PoolDataSource 객체 제거 : PoolDataSource(DBCP 객체)에게 다시 Connection 객체를 되돌려주는 기능
			// 제공
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Connection con, PreparedStatement pstmt) {
		try {
			// PoolDataSource 객체 제거 : PoolDataSource(DBCP 객체)에게 다시 Connection 객체를 되돌려주는 기능
			// 제공
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			// PoolDataSource 객체 제거 : PoolDataSource(DBCP 객체)에게 다시 Connection 객체를 되돌려주는 기능
			// 제공
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
