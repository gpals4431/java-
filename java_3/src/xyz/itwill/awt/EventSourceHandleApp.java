/*0424 3*/
package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//[exit] 버튼을 누르면 프로그램을 종료하는 GUI 프로그램 작성
// >> 디자인 클래스와 이벤트 처리 클래스를 하나의 클래스로 작성
// >> 이벤트 처리 메소드에서 디자인 클래스의 컴퍼넌트 사용 가능
public class EventSourceHandleApp extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;

	
	public EventSourceHandleApp(String title) {
		super(title);
		
		
		setLayout(new FlowLayout());
		
		Button exit = new Button("exit");//이벤트 소스
		
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		exit.addActionListener(this);
		//컴퍼넌트에서 발생된 이벤트를 this 키워드를 통해 현재 클래스의 객체로 이벤트 처리
		//이벤트클래스가 디자인클래스가 되는거니까 자기자신이 이벤트를 처리 할거면 this.(자신 객체 표현)
		// 단점 > 컴퍼넌트가 많을 수록 유지보수가 어려움
		
		setBounds(800,200,300,300);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new EventSourceHandleApp("이벤트처리");
	
	
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	
	
}
