/*0427 05*/
package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//키보드로 메세지를 입력받아 접속 서버에 전달하는 클라이언트 프로그램 작성
public class EchoClientApp {
	public static void main(String[] args) throws IOException {//키보드 입력스트림 잘못됐을 경우
		//키보드 입력스트림을 대량의 문자데이터를 얻어 올 수 있는 입력스트림으로 확장
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("전달 메세지 입력 >> ");
		String message = in.readLine();
		
		
		try {
			Socket socket = new Socket("192.168.13.5",3000);//서버 연결
			/*
			//소켓의 출력스트림을 제공받아 대량의 문자데이터를 전달할 수 있는 출력스트림으로 확장
			BufferedWriter out = new BufferedWriter
					(new OutputStreamWriter(socket.getOutputStream()));
			
			//서버의 소켓과 연결된 출력스트림을 이용하여 문자열(메세지) 전달
			out.write(message);

			//출력 스트림의 버퍼에 존재하는 문자데이터를출력스트림으로 전달
			out.flush();
			*/
			
			//소켓의 출력스트림을 제공받아
			//모든 형식의 값을 문자열로 변환하여 전달할 수 있는 기능의 출력스트림으로 확장
			PrintWriter out = new PrintWriter(socket.getOutputStream());//통로 확장
			
			//PrintWriter.println(Object o) : 매개변수로 전달받은 모든 자료형의 값(객체)를 문자열로 변환하여 
			//전달하는 메소드
			out.println(message);
			
			out.flush();
			
			socket.close();
			
		}catch(IOException e) {
			System.out.println("error : 서버에 접속 불가능");
		}
			
	
	}
}
