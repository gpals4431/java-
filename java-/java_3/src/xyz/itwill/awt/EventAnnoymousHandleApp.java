/*0424 4*/
package xyz.itwill.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//[exit] 버튼을 누르면 프로그램을 종료하는 GUI 프로그램 작성
//>> 이벤트 처리 클래스를 익명의 내부클래스로 작성
public class EventAnnoymousHandleApp extends Frame{

	private static final long serialVersionUID = 1L;

	public EventAnnoymousHandleApp(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		Button exit = new Button("exit");//이벤트 소스
		
		exit.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		add(exit);
		
		//이벤트 처리 객체를 익명의 내부클래스를 사용하여 생성, 단점: 일회성, 객체를 한개밖에 못만듦, 장점: 유지보수는 쉬움
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
	
		setBounds(800,200,300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EventHandleApp("이벤트처리");
		
	}
}
