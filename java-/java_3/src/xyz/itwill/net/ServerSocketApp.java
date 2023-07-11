/*0427 02*/
package xyz.itwill.net;

import java.io.IOException;
import java.net.ServerSocket;

/*
 TCP 프로그램 : ServerSocket 클래스와 Socket 클래스를 이용하여 작성
  >> 서버와 클라이언트가 소켓을 사용하여 1:1로 연결되어 데이터를 송수신하는 네트워크 프로그램
  
  서버(Server) : 외부의 컴퓨터(클라이언트)가 접속할 수 있는 환경과 서비스를 제공하기위한 컴퓨터
   >> ServerSocket 클래스를 사용하여 서버 프로그램 작성
   
  클라이언트(CLient) : 서버에 접속하여 서비스를 제공받을 수 있는 컴퓨터
   >>접속시 socket클래스를 사용하여 클라이언트 프로그램 작성
 */


//ServerSocket 클래스를 사용하여 사용 가능한 포트번호를 검색하는 프로그램 작성
public class ServerSocketApp {
	public static void main(String[] args) {
		for(int i=2000; i<=9000; i+=1000) {
			try {
				/*
				ServerSocket 클래스 : 서버 프로그램을 작성하기 위해 사용하는 클래스
			 	>> ServerSocket 클래스의 ServerSocket(int port) 생성자를 이용하여 매개변수로 
				전달받은 port번호를 활성화하여 ServerSocket 객체 생성 
				>> ServerSocket 객체를 생성하여 클라이언트가 접속할 수 있는 환경 제공
				>> 매개변수로 전달받은 포트번호를 이미 다른 네트워크 프로그램이 사용 중인 경우 > IOException 발생
				>실행 >> 방화벽 알림 > 꼭 액세스 허용을 눌러줘야함
				 > 액세스 허용 안눌렀다면 네트워크 속성> 네트워크 공유센터 >방화벽 고급설정 >인바운드 규칙 > 이클립스 > 연결 허용
				*/
				ServerSocket serverSocket = new ServerSocket(i);
				
				System.out.println("[메세지]"+i+"번 포트는 네트워크 프로그램에서 사용가능함.");
				
				//serverSocket.close :serverSocket 객체를 제거하는 메소드 >> 클라이언트가 접속할 수 있는 환경 소멸
				serverSocket.close();
			}catch(IOException e) {
				
				System.out.println("[메세지]"+i+"번 포트는 이미 다른 네트워크 프로그램에서 사용중.");
			}
		}
	}
}
