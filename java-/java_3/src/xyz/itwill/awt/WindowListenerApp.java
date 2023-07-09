/*0424 5*/
package xyz.itwill.awt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


//Frame에서는 window 이벤트 발생
// >> WindowListener 인터페이스를 상속받은 자식클래스를 사용하여 이벤트 처리
public class WindowListenerApp extends Frame {
	private static final long serialVersionUID = 1L;

	public WindowListenerApp(String title) {
		super(title);
		
		//프레임에서 Window이벤트가 발생될 경우 이벤트 처리할 객체 등록
		addWindowListener(new WindowEventHandleOne());
		setBounds(800,200,300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new WindowListenerApp("윈도우 이벤트");
		
	}
	//Listener 인터페이스를 상속받은 자식클래스(이벤트 처리 클래스)는 무조건 인터페이스의 모든 추상메소드 오버라이드 선언
	// >> 불필요한 추상메소드를 오버라이드 선언함
	public class WindowEventHandleOne implements WindowListener{
		//단점: 필요없는 요소도 무조건적으로 오버라이드 선언해줘야함
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowOpened 메소드 호출");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowClosing 메소드 호출");
			System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowClosed 메소드 호출");

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowIconified 메소드 호출");
			
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowDeiconified 메소드 호출");
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowActivated 메소드 호출");
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("windowDeactivated 메소드 호출");
			
		}
		
	}
}
