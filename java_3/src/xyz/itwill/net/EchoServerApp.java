
/*0427 06*/
package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트에서 보내온 메세지를 제공받아 출력하는 서버 프로그램 작성
public class EchoServerApp {
	public static void main(String[] args) {
		ServerSocket echoServer =null;
		
		try {
			echoServer=new ServerSocket(3000);//클라이언트 접속 환경 생성
			System.out.println("[메세지]Echo Server Running....");
			
			
			while(true) {//다수의 클라이언트 접속할 수 있도록 반복문 사용
				Socket socket = echoServer.accept();//소켓 생성>스레드 실행 클라이언트와 연결
				
				//소켓의 입력스트림을 제공받아 대량의 문자데이터를 얻어올 수 있는 입력스트림으로 확장
				BufferedReader in = new BufferedReader
						(new InputStreamReader(socket.getInputStream()));//1바이트만 읽어들릴수있음 > 확장
				
				//클라이언트의 소켓과 연결된 입력스트림을 이용하여 문자열(메세지)를 반환받아 출력
				System.out.println("["+socket.getInetAddress().getHostAddress()
						+"]님이 보내온 메세지 ="+in.readLine());
				
				socket.close();
			}
			
		}catch(IOException e) {
			System.out.println("error : 서버 네트워크에 문제가 발생함");
			
			
		}
	}
}
