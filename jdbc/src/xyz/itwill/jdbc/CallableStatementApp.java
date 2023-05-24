//5/16 - 1
package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/*저장 프로시저 > 자바에서 호출
CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN STUDENT.NO%TYPE >>  IN모드 매개변수 
    ,VNAME OUT STUDENT.NAME%TYPE) IS // >>  OUT모드 매개변수 : 바인딩 변수
BEGIN
    SELECT NAME INTO VNAME FROM STUDENT WHERE NO=VNO;
    IF SQL%FOUND THEN
        DELETE FROM STUDENT WHERE NO = VNO;
        COMMIT;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        VNAME:=NULL;
END;
/
*/

//키보드로 학번을 입력받아 STUDENT 테이블에 저장된 학생정보 중 해당 학번의 학생정보를 삭제하는 JDBC 프로그램 작성
// - 저장 프로시저를 호출하여 학생정보를 삭제처리
public class CallableStatementApp {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 삭제>>");
		System.out.println("학번 입력 >>");
		int no = Integer.parseInt(in.readLine());
		System.out.println("=======================================================================");
		Connection con = ConnectionFactory.getConnection();
		/*
		Connection.prepareCall(String sql) : 저장 프로시저를 호출하는 명령을 전달하여 실행하기 위한 CallableStatement 객체를
		반환하는 메소드 
		>> 저장 프로시저를 호출하는 명령  - {call delete_student(?,?){
		>> 저장 프로시저 호출시 사용한 ? 기호에는 반드시 setXXX() 메소드를 호출하여 값을 전달하거나 registerOutParamete() 메소드를
		호출하여 값을 제공받아 저장
		 */
		
		
		String sql ="{call delete_student(?,?)}";
		CallableStatement cstmt = con.prepareCall(sql);
		//CallableStatement.setXXX(int parameterIndex, XXX value) : 저장 프로시저에서 사용한 매개변수 중 in모드의 매개변수에 값을 전달하기 위한 메소드
		cstmt.setInt(1,no);//첫번째 inparameter에 값 전달
		
		//CallableStatement.registerOutParameter(int parameterIndex, int sqlType) : 저장 프로시저에서 사용한 매개변수 중 out 모드의 매개변수에 저장된 값을 제공받기 위한 메소드
		// >> sqlType: SQL 자료형 - Types 클래스의 상수 사용
		cstmt.registerOutParameter(2, Types.NVARCHAR);//두번째 inparameter에 값 전달
		
		//CallableStatement.execute() : 저장 프로시저를 호출하는 명령을 전달하여 실행하는 메소드, 뭐가 실행될지 모름 > execute 사용
		cstmt.execute();
		
		//CallableStatement.getXXX(int parameterIndex) : 저장 프로시저에서 사용한 매개변수 중 out 모드의 매개변수에 저장된 값을 반환하는 메소드
		String name = cstmt.getString(2);
		if(name==null) {
			System.out.println("[메세지] 해당 학번의 학생정보를 찾을 수 없습니다.");
		}else {
			System.out.println("[메세지]"+name+"님을 삭제 하였습니다.");
		}
		
		ConnectionFactory.close(con,cstmt);
		}
	}

