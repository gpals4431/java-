/*0424 1*/
package xyz.itwill.io;

import java.io.IOException;

public class ByteStreamApp {
	public static void main(String[] args) throws IOException{
		System.out.println("[메세지] 키보드를 눌러 값을 입력해주세요. [프로그램 종료 : ctrl+'Z']");
		
		//키보드 입력값을 저장하기위한 변수
		int readByte;
		
		while(true) {
			/*
			System.in : JAVA프로그램 개발을 위해 기본적으로 제공되는 키보드 입력스트림이 저장된 필드
			> InputStream 클래스를 기반으로 제공되는 입력스트림(객체)
			> 키보드를 누른 경우 키보드의 문자값이 입력스트림으로 전달
			
			InputStream.read() : 입력스트림에 존재하는 값을 원시데이터(1Byte)로 읽어 정수값(int)으로 반환하는 메소드 
			> 입력스트림에 값이 없는 경우 스레드는 일시중지 상태로 전환
			> 입력스트림에 엔터(Enter)가 입력될 경우 스레드 다시 실행
			readByte=System.in.read(); // 에러떨어지는 이유? 입력/출력 스트림 관련 메소드는 IOException 발생
			> IOException은 일반 예외이므로 반드시 예외처리, 모니터 뽑지않는 이상 거의 io예외 발생x >> throws 처리
			*/
			readByte=System.in.read(); 
			
			//입력종료신호(Ctrl+Z : EOF)가 전달된 경우 반복문 종료
			if(readByte==-1) break;
			
			/*
			System.out : JAVA프로그램 개발을 위해 기본적으로 제공되는 키보드 출력스트림이 저장된 필드
			> OutputStream 클래스를 기반으로 제공되는 출력스트림(객체) - PrintStream 클래스
			> 출력스트림에 값을 전달하여 모니터가 출력 처리
			
			OutputStream.write(int b) : 매개변수로 제공받은 값을 원시데이터(1Byte)로 출력스트림에 전달하는 메소드
			*/
			System.out.write(readByte);
			
		}
		
		System.out.println("[메세지]프로그램을 종료합니다");
	}
}
