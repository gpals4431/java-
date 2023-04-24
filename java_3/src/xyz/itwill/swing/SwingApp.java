/*0424 8*/
package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//JTextField 컴퍼넌트에서 메세지를 입력 후 엔터를 누르면 JTextArea 컴퍼넌트에 메세지를 추가하여 출력되도록 프로그램 작성
// >> JTextField 컴퍼넌트에서 메세지를 입력후 엔터를 누르면 ActionEvent 발생
public class SwingApp extends JFrame{
	private static final long serialVersionUID = 1L;

	
	JTextField jTextField;//이벤트처리메소드에서 쓸수 있도록 만들어주려고 field사용
	JTextArea jTextArea;

	
	public SwingApp(String title) {
		super(title);

		jTextField=new JTextField();
		jTextArea=new JTextArea("[홍길동]님이 입장하였습니다.\n");
		
		//Swing 프로그램에서는 OS에서 제공되는 모든 글꼴 사용
		jTextField.setFont(new Font("굴림체", Font.BOLD, 20 ));
		jTextArea.setFont(new Font("굴림체", Font.BOLD, 20 ));
		
		jTextArea.setBackground(Color.YELLOW);
		
		
		//setFocusable(false):jTextArea 컴퍼넌트에 입력초점을 제공하지 않도록 설정 - 출력 컴퍼넌트로만 사용
		jTextArea.setFocusable(false);
		
		//getContentPane(); : 프레임의 컨테이너 기능을 객체로 반환하는 메소드
		Container container = getContentPane();
		
		//JScrollPane : 컴퍼넌트에 스크롤을 제공하는 컨테이너
		JScrollPane jScrollPane=new JScrollPane(jTextArea);
		
		//jTextField 컴퍼넌트에서 ActionEvent가 발생될 경우 , 이벤트 처리할 클래스로 객체를 생성하여 이벤트 처리 기능 등록 
		
		container.add(jScrollPane, BorderLayout.CENTER);
		//container.add(jTextArea, BorderLayout.CENTER); // 가운데 위치하면 가운데 고정 >> 스크롤 내릴수없어서?
		container.add(jTextField, BorderLayout.SOUTH);
		
		jTextField.addActionListener(new TextEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(800,200,400,100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SwingApp("Swing");
		

	}
	public class TextEventHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TextComponent.getText() : jtext 필드 컴퍼넌트 또는 jtextArea 컴퍼넌트에 입력된 문자열을 얻어와 반환하는 메소드
			String text = jTextField.getText();
			
			if(!text.equals("")) {
				//jTextArea.append(String text): jTextArea 컴퍼넌트에 문자열을 추가하여 출력하는 메소드
				jTextArea.append("[홍길동]"+text+"\n");
				
				//setCaretPosition(int position) : JTextArea 컴퍼넌트의 스크롤을 이동하는 메소드, 맨하단으로 스크롤 이동
				jTextArea.setCaretPosition(jTextArea.getText().length());
				
				//TextComponent.setText() : jtextfield 컴퍼넌트 또는 jtextArea 컴퍼넌트에 입력된 문자열을 변경하는 메소드
				jTextField.setText("");
			}
		}
	}
}
