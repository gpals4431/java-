/*0424 2*/
package xyz.itwill.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CharcterStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지] 키보드를 눌러 값을 입력해주세요. [프로그램 종료 : ctrl+'Z']");
		
		/*
		InputStreamReader 클래스 : InputStream 객체를 전달받아 문자테이터를 입력받기 위한
		입력 스트림(Reader 객체)를 생성하기위한 클래스 - 스트림 확장
		 */
		InputStreamReader in = new InputStreamReader(System.in);
		
		/*
		OutputStreamReader 클래스 : OutputStream 객체를 전달받아 문자테이터를 출력하기 위한
		출력 스트림(Writer 객체)를 생성하기위한 클래스 - 스트림 확장
		 */
		//OutputStreamWriter out = new  OutputStreamWriter(System.out);
		
		/*
		PrintWriter 클래스:  OutputStream 객체를 전달받아 문자테이터를 출력하기 위한
		출력 스트림(Writer 객체)를 생성하기위한 클래스
		> OutputStreamWriter 클래스보다 더 많은 출력메소드 제공
		*/
		PrintWriter out = new  PrintWriter(System.out);
		
		int readByte;
		
		while(true) {
			//Reader.read() : 입력스트림에 존재하는 값을 문자데이터(2Byte)로 읽어 정수값으로 반환하는 메소드
			readByte = in.read();
			
			if(readByte == -1) break;
			
			//Writer.write(int b) : 매개변수로 제공받은 값을 문자데이터(2Byte)로 출력스트림에 전달하는 메소드
			//>>문자 데이터는 출력스트림에 존재하는 버퍼(=임시메모리)에 일정한 크기만큼 저장하고 한번에 출력스트림으로 전달하여 출력처리
			out.write(readByte);// 보낼때 1바이트로 보내면 한글 실행 안됨.
			
			//Writer.flush () : 출력스트림의 버퍼에 존재하는 모든 값을 출력스트림으로 전달하는 메소드 
			out.flush();
		}
		
		System.out.println("[메세지]프로그램을 종료합니다");

	}
}
