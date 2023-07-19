package xyz.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.example.dto.ExampleDTO;

/*
이름       널?       유형           
-------- -------- ------------ 
NO       NOT NULL NUMBER       
ANAME    NOT NULL VARCHAR2(20) 
AMONEY   NOT NULL NUMBER(10)   
AINOUT   NOT NULL VARCHAR2(10) 
USERDATE NOT NULL DATE         
AOUT              VARCHAR2(20) 
AIN               VARCHAR2(20)   
*/
  

public class ExampleDAO extends JdbcDAO{
	public static ExampleDAO _dao;
	
	public ExampleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao = new ExampleDAO();
	}
	
	public static ExampleDAO getDao() {
		return _dao;
	}
	//모든 행을 검색해 List 객체로 반환하는 메소드
	public List<ExampleDTO> selecctAccountList(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ExampleDTO> accountList=new ArrayList<>();
		
		try {
			con=getConnection();
			
			String sql = "select * from account_book order by usedate";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ExampleDTO account=new ExampleDTO();
				account.setAname(rs.getString("aname"));
				account.setAmoney(rs.getInt("amoney"));
				account.setAinout(rs.getString("ainout"));
				account.setUsedate(rs.getString("usedate"));
				account.setAout(rs.getString("aout"));
				account.setAin(rs.getString("ain"));
				
				accountList.add(account);
			}
			
		}catch(SQLException e) {
			System.out.println("[에러]selecctAccountList() 메소드의 SQL 오류 = "+e.getMessage());

		}finally {
			close(con, pstmt, rs);
		}
		return accountList;
	}
	
	
	//삽입하고 삽입행의 갯수 반환
	public int insertAccount(ExampleDTO account, String search) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql = "insert into account_book values(no_seq.nextval,?,?,"+search+",?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, account.getAname());
			pstmt.setInt(2, account.getAmoney());
			pstmt.setString(3, account.getUsedate());
			pstmt.setString(4, account.getAout());
			pstmt.setString(5, account.getAin());
			
			rows=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("[에러]insertAccount() 메소드의 SQL 오류 = "+e.getMessage());

		}finally {
			close(con,pstmt);
		}
		
		return rows;
	}

	public List<ExampleDTO> searchAccountList(String search, String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ExampleDTO> accountList=new ArrayList<>();
		try {
			con=getConnection();
			if(keyword.equals("")) {
				
				String sql="select * from account_book order by usedate desc";
				pstmt=con.prepareStatement(sql);
				
						
			}else {
				String sql="select * from account_book where "+search+" like '%'||?||'%' order by usedate desc";
					
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				
				System.out.println(sql);
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ExampleDTO account=new ExampleDTO();
				account.setAname(rs.getString("aname"));
				account.setAmoney(rs.getInt("amoney"));
				account.setAinout(rs.getString("ainout"));
				account.setUsedate(rs.getString("usedate"));
				account.setAout(rs.getString("aout"));
				account.setAin(rs.getString("ain"));
				
				accountList.add(account);
			}
		}catch (SQLException e) {
			System.out.println("[에러]searchAcoountList()메소드에 의한 SQL오류"+e.getMessage());
		}finally {
			close(con, pstmt, rs);
		}
		return accountList;
		
	}
	
	public int searchAccountCount(String search, String keyword) {
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count =0;
		
		try {
			con=getConnection();
			
			//매개변수에 저장된 값을 비교하여 DBMS 서버에 다른 SQL명령을 전달하여 실행
			//=> 동적 SQL(Dynamic SQL) 기능  
			if(keyword.equals("")) {//검색 기능을 사용하지 않은 경우
				//REVIEW 테이블에 저장된 전체 게시글의 갯수를 검색
				String sql="select count(*) from account_book";
				pstmt=con.prepareStatement(sql);
				
			}else {//게시글 검색 기능을 사용한 경우
			
				String sql="select count(*) from account_book where "+search+" like '%'||?||'%'";
			
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				
			}
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		}catch(SQLException e) {
			System.out.println("[에러]searchAccountCount()메소드에 의한 SQL오류"+e.getMessage());
		}finally {
			close(con, pstmt, rs);
		}
		return count;
	}
	
	public int deleteAccount(int no) {
		Connection con =null;
		PreparedStatement pstmt=null;
		int rows =0;
		try {
			con=getConnection();
			
			String sql ="delete from account_book where no =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no );
			
			rows=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("[에러]deleteAccount()메소드에 의한 SQL오류"+e.getMessage());
		}finally {
			close(con, pstmt);
		}
		return rows;
		
	}
}
