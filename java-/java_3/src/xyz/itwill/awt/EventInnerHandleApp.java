/*0424 2*/
package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//[exit] 버튼을 누르면 프로그램을 종료하는 GUI 프로그램 작성
// >> 이벤트 클래스를 디자인클래스 내부 클래스로 작성
// >> 내부 클래스(이벤트 처리 클래스)는 외부 클래스(디자인 클래스)의 필드와 메소드를 접근제한자에 상관없이 사용 가능
// >>이벤트 처리 메소드에서 디자인 클래스의 컴퍼넌트 사용 가능
// 장점: 만들기도 쉽고 유지보수도 쉽다. 가장 많이 사용
public class EventInnerHandleApp extends Frame {
	private static final long serialVersionUID = 1L;
	
	
	public EventInnerHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		Button exit = new Button("exit");//이벤트 소스
		
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		//외부클래스의 메소드에서는 내부 클래스로 객체 생성 가능
		exit.addActionListener(new EventHandle());

		setBounds(800,200,300,300);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new EventInnerHandleApp("이벤트처리");
	
	}
	
	// >> 내부 클래스(이벤트 처리 클래스)는 외부 클래스(디자인 클래스)의 필드와 메소드를 접근제한자에 상관없이 사용 가능
	public class EventHandle implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	}
}
