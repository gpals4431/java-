/*0421 6*/
package xyz.itwill.awt;

import java.awt.Button;
import java.awt.Frame;

//배치관리자를 사용하지않고 프레임에 컴퍼넌트를 배치하여 사용하는 프로그램
public class NonLayoutManagerApp extends Frame{
	private static final long serialVersionUID = 1L;

	
	public NonLayoutManagerApp(String title) {
		super(title);
		
		//container.setLayout(layoutManager mrg) : 컨테이너의 배치관리자를 변경하는 메소드
		setLayout(null);//프레임은 배치관리자를 사용하지않도록 설정
		
		Button button1 =new Button("Button-1");
		Button button2 =new Button("Button-2");
		
		//배치관리자를 사용하지 않을 경우 반드시, component의 크기와 출력위치를 변경 후 배치 > 수동 설정
		
		button1.setBounds(80, 100, 150, 80);
		button2.setBounds(190, 300, 100, 120);
		
		add(button1);
		add(button2);
		
		setBounds(600, 100, 400, 500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new NonLayoutManagerApp("배치관리자 미사용");
		
	}
}
