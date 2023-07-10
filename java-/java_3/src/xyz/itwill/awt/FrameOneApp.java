/*0421 3*/
package xyz.itwill.awt;

import java.awt.Frame;

public class FrameOneApp {
	public static void main(String[] args) {
		//Frame 클래스 : 메뉴가 존재하는 컨테이너를 생성하기 위한 클래스
		//Frame frame =new Frame();
		// Frame 클래스의 frame(string title)생성자로 객체를 생성하면 제목을 설정된 프레임 생성
		Frame frame =new Frame("프레임 연습");
		
		
		//Component.setSize(int width, int hight): 컴포넌트의 크기를 변경하는 메소드
		// => gUI 프로그램에서 크기또는 위치를 표현하는 단위는 픽셀(pixel)로 설정
		//픽셀(pixel) : 하나의 색으로 표현하는 점(dot)
		frame.setSize(400,300);
		
		//Component.setLocation(int x, int y): 컴포넌트의 출력 위치를 변경하는 메소드
		frame.setLocation(600,100);
		
		
		//Component.setVisible(boolean b): 컴퍼넌트를 보이지않게 처리하거나 보이도록 처리하는 메소드 
		// - false: 보이지 않도록 처리, true : 보여지도록 처리
		frame.setVisible(true);
		
	}
}
