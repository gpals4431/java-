/*0421 8*/
package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;


//FlowLayout 클래스 : 컴퍼넌트를 컨테이너의 왼쪽부터 오른쪽방향으로 차례대로 배치하는 배치 관리자
// => 컨테이너의 크기를 벗어날 경우 자동으로 아래로 이동하여 컴퍼넌트 배치
// => penal, applet등의 컨테이너의 기본 배치 관리자
public class FlowLayoutApp extends Frame{

	private static final long serialVersionUID = 1L;

	
	public FlowLayoutApp(String title) {
		super(title);
		
		//frame의 배치관리자를 FlowLayout로 변경
		setLayout(new FlowLayout());
		
		Button button1= new Button("Button=1");
		Button button2= new Button("Button=2");
		Button button3= new Button("Button=3");
		Button button4= new Button("Button=4");
		Button button5= new Button("Button=5");
	
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		
		setBounds(600, 100, 500, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FlowLayoutApp("FlowLayoutApp");
		
	}
}
