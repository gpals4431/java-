package newjava.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//ACCOUNT_BOOK 테이블에 행을 삽입,삭제,변경,검색하는 기능의 메소드를 제공하는 클래스 
public class simpleDAOImpl extends JdbcDAO implements simpleDAO {
	private static simpleDAOImpl _dao;

<<<<<<< HEAD
	public simpleDAOImpl() {
		// TODO Auto-generated constructor stub
=======
   @Override
   public int updateAccountBook(simpleDTO account) {
      Connection con =null;
      PreparedStatement pstmt = null;
      int rows =0;
      
      try {
         con = getConnection();
         
         String sql = "update account_book set amoney=?, ainout=?, aout=?, ain=? where aname=? and usedate=? ";
         
         pstmt = con.prepareStatement(sql);
         
         pstmt.setInt(1, account.getAmoney());
         pstmt.setString(2, account.getAinout());
         pstmt.setString(3, account.getAout());
         pstmt.setString(4, account.getAin());
         pstmt.setString(5, account.getAname());
         pstmt.setString(6, account.getUsedate());
         
         rows = pstmt.executeUpdate();
      }catch(SQLException e) {
         System.out.println("[에러]updateAccountBook() 메소드의 SQL오류 발생");
      }finally {
         close(con,pstmt);
      }return rows;
   }

@Override
public int deleteAccountBook(simpleDTO account) {
	Connection con = null;
	PreparedStatement pstmt = null;
	int rows = 0;

	try {
		con = getConnection();

		String sql = "delete from account_book where aname=? and usedate=? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, account.getAname());
		pstmt.setString(2, account.getUsedate());

		rows = pstmt.executeUpdate();

	} catch (SQLException e) {
		System.out.println("에러 : deleteAccountBook 메소드의 SQL 오류 =" + e.getMessage());// 매핑하여 반환
	} finally {
		close(con, pstmt);
>>>>>>> refs/remotes/origin/main
	}

	static {
		_dao = new simpleDAOImpl();

	}

	public static simpleDAOImpl getDao() {
		return _dao;
	}

	@Override
	public int insertAccountBook(simpleDTO account) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

<<<<<<< HEAD
		try {
			con = getConnection();
=======
		String sql = "select aname, amoney, ainout, to_char(usedate,'yyyy-mm-dd') usedate, aout, ain from account_book where aname=? order by usedate";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, aname);
>>>>>>> refs/remotes/origin/main

			String sql = "insert into account_book values(?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, account.getAname());
			pstmt.setInt(2, account.getAmoney());
			pstmt.setString(3, account.getAinout());
			pstmt.setString(4, account.getUsedate());
			pstmt.setString(5, account.getAout());
			pstmt.setString(6, account.getAin());

			rows = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("[에러]insertAccountBook() 메소드의 SQL오류 발생");
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public int updateAccountBook(simpleDTO account) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "update account_book set amoney=?, ainout=?, aout=?, ain=? where aname=? and usedate=? ";

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, account.getAmoney());
			pstmt.setString(2, account.getAinout());
			pstmt.setString(3, account.getAout());
			pstmt.setString(4, account.getAin());
			pstmt.setString(5, account.getAname());
			pstmt.setString(6, account.getUsedate());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateAccountBook() 메소드의 SQL오류 발생");
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	@Override
	public int deleteAccountBook(simpleDTO account) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;

		try {
			con = getConnection();

			String sql = "delete from account_book where aname=? and usedate=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getAname());
			pstmt.setString(2, account.getUsedate());

			rows = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("에러 : deleteAccountBook 메소드의 SQL 오류 =" + e.getMessage());// 매핑하여 반환
		} finally {
			close(con, pstmt);
		}
		return rows;

	}

	@Override
	public List<simpleDTO> selectAnameList(String aname) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<simpleDTO> accountList = new ArrayList<>();

		try {
			con = getConnection();

			String sql = "select aname, amoney, ainout, to_char(usedate,'yyyy-mm-dd') usedate, aout, ain from account_book where aname=? order by usedate";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, aname);

			rs = pstmt.executeQuery();// 자바 객체로 만들어 줘야함

			while (rs.next()) {// 검색행이 있는 경우
				simpleDTO account = new simpleDTO();
				// 처리행의 컬럼값을 반환받아 DTO 객체의 필드값으로 변경 > 검색행을 자바객체로 만들어줌 = 매핑
				account.setAname(rs.getString("aname"));
				account.setAmoney(rs.getInt("amoney"));
				account.setAinout(rs.getString("ainout"));
				account.setUsedate(rs.getString("usedate"));
				account.setAout(rs.getString("aout"));
				account.setAin(rs.getString("ain"));

				accountList.add(account);
			}

		} catch (SQLException e) {
			System.out.println("에러 : selectAnameList 메소드의 SQL 오류 =" + e.getMessage());// 매핑하여 반환
		} finally {
			close(con, pstmt, rs);
		}
		// 검색행이 없는 경우 null 반환하고 검색행이 있는 경우 DTO 객체 반환 - 검색행 하나를 반환
		return accountList;
	}

@Override
public List<simpleDTO> selectAllaccountList() {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	List<simpleDTO> accountList = new ArrayList<>();
	try {
		con = getConnection();
		String sql = " select aname, amoney, ainout, to_char(usedate,'yyyy-mm-dd') usedate, aout, ain from account_book order by usedate";

		pstmt = con.prepareStatement(sql);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			simpleDTO account = new simpleDTO();
			account.setAname(rs.getString("aname"));
			account.setAmoney(rs.getInt("amoney"));
			account.setAinout(rs.getString("ainout"));
			account.setUsedate(rs.getString("usedate"));
			account.setAout(rs.getString("aout"));
			account.setAin(rs.getString("ain"));

			accountList.add(account);
		}

	} catch (SQLException e) {

	} finally {
		close(con, pstmt, rs);
	}
	return accountList;
}

@Override
public simpleDTO update_changeAccountBook(String aname, String usedate) {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	simpleDTO changeaccount = null ;
	try {
		con = getConnection();
		String sql = " select * from account_book where aname=? and usedate =? order by usedate";

		pstmt = con.prepareStatement(sql);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			changeaccount = new simpleDTO();
			
			changeaccount.setAmoney(rs.getInt("amoney"));
			changeaccount.setAinout(rs.getString("ainout"));
			changeaccount.setAout(rs.getString("aout"));
			changeaccount.setAin(rs.getString("ain"));
			changeaccount.setAname(rs.getString("aname"));
			changeaccount.setUsedate(rs.getString("usedate"));

		}
	}catch(SQLException e) {
		System.out.println("에러 : update_changeAccountBook 메소드의 SQL 오류 =" + e.getMessage());
	}finally {
		close(con, pstmt, rs);
	}
	return changeaccount;
	}
}
