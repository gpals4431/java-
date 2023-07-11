package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import study.dto.joinDTO;

public class joinDAO extends JdbcDAO{
	private static joinDAO _dao;

	public joinDAO() {
	}
	static {
		_dao = new joinDAO();
	}
	public static joinDAO getDAO() {
		return _dao;
	}
	
	//회원가입 페이지에서 회원정보를 입력받아 삽입하고 삽입행을 반환하는 메소드
	public int insertJoin(joinDTO join) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql ="insert into login values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, join.getId());
			pstmt.setString(2, join.getPassword());
			pstmt.setString(3, join.getName());
			
			rows=pstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			System.out.println("insertJoin()매소드의 SQL오류 발생 ="+e.getMessage());
		}finally {
			close(con, pstmt);
		}
		return rows;
		
	}
	
	//아이디를 전달받아 회원정보를 입력받아 dto 객체 반환
	public joinDTO selectJoin(String id, String password) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		joinDTO join =null;
		try {
			con=getConnection();
			
			String sql ="select * from join where id =? and password=?";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				join=new joinDTO();
				join.getId();
				join.getName();
				join.getPassword();
			}
			
		}catch (SQLException e) {
			System.out.println("selectJoin()매소드의 SQL오류 발생 ="+e.getMessage());
		}finally {
			close(con, pstmt, rs);
		}
		return join;
	
	}
}
