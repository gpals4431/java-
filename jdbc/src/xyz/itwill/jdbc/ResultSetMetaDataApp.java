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
		ResultSet rs = stmt.executeQuery(sql);//검색 결과 저장 - ResultSet 객체 : 검색결과를 2차원 배열(행과 열 - 테이블)의 형태로 저장하여 제공하는 객체 > 이 객체를 이용해서 검색대상을 테이블 형태로 제공
		
		while(rs.next()) {
			System.out.println("학번 = "+rs.getInt("no")+",이름 ="+rs.getString("name"));
		}
		System.out.println("===================================================");
		//ResultSet.getMetaData() : 검색행(ResultSet객체)에 대한 부가적인 정보(검색대상)가 저장된 ResultSetMetaData 객체를 반환하는 메소드
		ResultSetMetaData rsmd=rs.getMetaData();// >> 검색 대상의 부가적인 컬럼정보들이 rsmd 참조변수에 저장 - 예) 학번, 이름 등
		
		//ResultSet.getColumnCount(): 검색행의 컬럼갯수를 반환하는 메소드
		int columnCount = rsmd.getColumnCount(); // >> rsmd에는 student 테이블의 부가적인 정보들이 저장되어 있고 rsmd.getColumnCount 메소드를 통해서 검색행의 컬럼 갯수를 반환함
		System.out.println("검색행의 컬럼 갯수 = "+columnCount);
		System.out.println("===================================================");
		for(int i=1;i<=columnCount;i++) {//검색대상의 갯수만큼 반복처리 
			//ResultSetMetaData.getColumnLabel(int columnindex): 첨자위치(columnindex: 1부터 1씩 증가)의 검색대상의 이름(컬럼명)을 반환하는 메소드
			String columnLabel = rsmd.getColumnLabel(i); //>>첨자 위치의 부가적인 정보 (컬럼명)를 coulumLabel 문자열 참조변수에 저장함
			
			//ResultSetMetaData.isNullable(int columnindex): 첨자위치(columnindex)의 검색대상의 NULL 허용 유무(0 또는 1)을 반환하는 메소드
			int isNull=rsmd.isNullable(i);
			String nullResult="Null";
			//ResultSetMetaData.columnNoNulls: NULL를 허용하지 않는 상수 - 정수값 : 0
			if(isNull==ResultSetMetaData.columnNoNulls) {
				//rsmd.columnNoNulls 경고 :The static field ResultSetMetaData.columnNoNulls should be accessed in a static way, 정적메소드는 클래스로 접근, 상수는 final static 사용 (상수: 불변의 값)
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
