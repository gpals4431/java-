//05/15 - 4

package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataApp {//metadate: 주 데이터 보조 역할, 대부분 컬럼 검색대상에 대한 정보 제공 >> 오라클에서 no, name, address 등 컬럼 검색대상에 대한 정보를 제공
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		String sql = "select * from student order by  no"; //> *을 이용해 전체를 검색했을때 검색행의 컬럼 갯수는 5개
		//String sql = "select no,name from student order by  no";
		ResultSet rs = stmt.executeQuery(sql);//검색 결과 저장
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+",이름 ="+rs.getString("name"));
		}
		System.out.println("===================================================");
		//ResultSet.getMetaData() : 검색행(ResultSet객체)에 대한 부가적인 정보(검색대상)가 저장된 ResultSetMetaData 객체를 반환하는 메소드
		ResultSetMetaData rsmd=rs.getMetaData();
		
		//ResultSet.getColumnCount(): 검색행의 컬럼갯수를 반환하는 메소드
		int columnCount = rsmd.getColumnCount();
		System.out.println("검색행의 컬럼 갯수 = "+columnCount);
		System.out.println("===================================================");
		for(int i=1;i<=columnCount;i++) {//검색대상의 갯수만큼 반복처리 
			//ResultSetMetaData.getColumnLabel(int columnindex): 첨자위치(columnindex: 1부터 1씩 증가)의 검색대상의 이름(컬럼명)을 반환하는 메소드
			String columnLabel = rsmd.getColumnLabel(i); 
			
			//ResultSetMetaData.isNullable(int columnindex): 첨자위치(columnindex)의 검색대상의 NULL 허용 유무(0 또는 1)을 반환하는 메소드
			int isNull=rsmd.isNullable(i);
			String nullResult="Null";
			//ResultSetMetaData.columnNoNulls: NULL를 허용하지 않는 상수 - 정수값 : 0
			if(isNull==ResultSetMetaData.columnNoNulls) {
				nullResult="Not Null";
			}
			//ResultSetMetaData.getColumnTypeName() : 첨자위치(columnindex: 1부터 1씩 증가)의 검색대상의 컬럼의 오라클 자료형를 반환하는 메소드
			String columnTypeName = rsmd.getColumnTypeName(i);
			
			//ResultSetMetaData.getcolumnDisplaySize() : 첨자위치(columnindex: 1부터 1씩 증가)의 검색대상의 컬럼의 출력크기를 반환하는 메소드
			int columnDisplaySize = rsmd.getColumnDisplaySize(i);
			
			System.out.println("컬럼명 = "+columnLabel);
			System.out.println("null 허용유무 = "+nullResult);
			System.out.println("컬럼의 자료형 = "+columnTypeName);
			System.out.println("컬럼의 출력크기 = "+columnDisplaySize);
			System.out.println("===================================================");
		}
		ConnectionFactory.close(con, stmt, rs);
	 }
}
