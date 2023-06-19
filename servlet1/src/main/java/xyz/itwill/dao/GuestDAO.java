//06/19 guest 2
package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xyz.itwill.dto.GuestDTO;

//GUEST 테이블의 행을 삽입, 삭제, 검색하기 위한 기능을 제공하는 클래스
public class GuestDAO extends JdbcDAO {
	private static GuestDAO _dao;

	private GuestDAO() {

	}

	static {
		_dao = new GuestDAO();
	}

	public static GuestDAO getDAO() {
		return _dao;
	}

	// 방명록 게시글 정보를 전달받아 GUEST 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertGuest(GuestDTO guest) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "insert into guest values(guest_seq.nextval, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, guest.getWriter());
			pstmt.setString(2, guest.getSubject());
			pstmt.setString(3, guest.getContent());

			rows = pstmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("에러 : insertGuest 메소드의 SQL 오류 =" + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;

	}

	// 방명록 게시글정보를 전달받아 GUEST 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateGuest(GuestDTO guest) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "update guest set writer=?, subject=?, content=? where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, guest.getWriter());
			pstmt.setString(2, guest.getSubject());
			pstmt.setString(3, guest.getContent());
			pstmt.setInt(4, guest.getNum());

			rows = pstmt.executeUpdate(sql);

		} catch (SQLException e) {
			System.out.println("에러 : updateGuest 메소드의 SQL 오류 =" + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;

	}

	// 방명록 게시글번호를 전달받아 GUEST 테이블에 저장된 행을 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteGuest(GuestDTO guest) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "delete from guest where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, guest.getNum());

			rows = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("에러 : insertGuest 메소드의 SQL 오류 =" + e.getMessage());

		} finally {
			close(con, pstmt);
		}
		return rows;

	}

	// 방명록 게시글번호를 전달받아 GUEST 테이블에 저장된 행을 검색하여 반환하는 메소드
	public GuestDTO selectGuest(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		GuestDTO guest=null;
		
		try{
			con=getConnection();
			
			String sql="select * from guest where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, guest.getNum());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//매핑 단계 -> 자바 객체로 만들어줌
				guest=new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWriter(rs.getString("writer"));
				guest.setSubject(rs.getString("subject"));
				guest.setContent(rs.getString("content"));
				guest.setRegdate(rs.getString("regdate"));
				
				}	
			}catch (SQLException e) {
				System.out.println("error: selectGuest메소드의 SQL 오류"+e.getMessage());
			}finally {
				close(con, pstmt, rs);
			}
			return guest;
		}
		
	

	// GUEST 테이블에 저장된 모든 행을 검색하여 반환하는 메소드
	public List<GuestDTO> selectGuestList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GuestDTO> guestList = new ArrayList<>();

		try {
			con = getConnection();// 10개의 컨넥션 중 하나 반환

			String sql = "select * from guest order by num desc";
			pstmt = con.prepareStatement(sql);

			// 실행결과를 Java 객체(값)로 매핑하여 반환 -> List 객체로 반환
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// ResultSet 커서 위치의 행을 DTO 객체로 표현
				// => ResultSet 커서 위치의 행에 대한 컬럼값은 DTO 객체의 필드에 매핑하여 저장
				GuestDTO guest = new GuestDTO();
				guest.setNum(rs.getInt("num"));
				guest.setWriter(rs.getString("writer"));
				guest.setSubject(rs.getString("subject"));
				guest.setContent(rs.getString("content"));
				guest.setRegdate(rs.getString("regdate"));

				// List 객체에 DTO 객체를 요소로 추가
				guestList.add(guest);
			}

		} catch (SQLException e) {
			System.out.println("error: selectStudentList메소드의 SQL 오류" + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return guestList;
	}
}