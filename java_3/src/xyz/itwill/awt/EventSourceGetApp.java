/*0424 7*/
package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 색상 버튼을 누르면 캔버스의 색을 변경하는 프로그램 작성
public class EventSourceGetApp extends Frame {
	private static final long serialVersionUID = 1L;

	//이벤트처리 클래스의 메소드에서 사용될 컴퍼넌트 또는 컨테이너는 필드 선언
	// >> 이벤트 처리 클래스(내부 클래스)의 이벤트 처리 메소드에서 필드를 사용하여 이벤트 처리 가능
	Button red, green, blue, white;
	Canvas canvas;
	
	
	public EventSourceGetApp(String title) {
		super(title);

		red = new Button("RED");
		green = new Button("GREEN");
		blue = new Button("BLUE");
		white = new Button("WHITE");
		
		canvas = new Canvas();
		
		Panel panel = new Panel();
		
		panel.setLayout(new GridLayout(1,4));
		
		panel.add(red);
		panel.add(green);
		panel.add(blue);
		panel.add(white);
		
		add(panel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		
		panel.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
		
		
		//프레임의 [닫기]를 누른 경우 프로그램을 종료하는 이벤트 처리 객체 등록
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		red.addActionListener(new ColorButtonHandle() );
		green.addActionListener(new ColorButtonHandle() );
		blue.addActionListener(new ColorButtonHandle() );
		white.addActionListener(new ColorButtonHandle() );
		
		setBounds(800,200,400,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventSourceGetApp("이벤트처리");
		
	}
	
	/*
//컴퍼넌트마다 이벤트를 처리하는 클래스를 다르게 설덩
 * 컴포넌트가 여러개있으면 코드가 너무 많아짐! > 관리 어려움
	public class RedButtonHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.red);
		}
	}
	
	public class GreenButtonHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.green);
				
		}
	}
	
	public class BlueButtonHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.BLUE);
		}
	}
		
	public class WhiteButtonHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(Color.WHITE);
		
		}			
			
	}
	
	*/
	
	//컴퍼넌트마다 이벤트를 처리하는 클래스를 동일하게 설정
	// >> 이벤트 처리 메소드에서 이벤트가 발생된 컴퍼넌트를 구분하여 명령을 선택 실행
	public class ColorButtonHandle implements ActionListener{
		
	//이벤트 처리 메소드의 매개변수에는 이벤트 관련 정보를 Event객체로 제공받아 사용
	@Override
	public void actionPerformed(ActionEvent e) {
		//e. getSource() : 이벤트가 발생된 컴퍼넌트(컨테이너)를 반환하는 메소드
		// >> 컴퍼넌트(컨테이너)가 오브젝트 타입의 객체로 반환
		Object eventSource = e.getSource();
		
		//참조변수에 저장된 객체의 메모리 주소 비교
		if(eventSource == red ) {
			canvas.setBackground(Color.red);

		}else if ( eventSource == green) {
			canvas.setBackground(Color.green);

		}else if(eventSource == blue) {
			canvas.setBackground(Color.blue);		
			
		}else if(eventSource == white) {
			canvas.setBackground(Color.white);
			
		}
	}
		
	}
}

