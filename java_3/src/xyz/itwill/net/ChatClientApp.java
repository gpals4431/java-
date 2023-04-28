//0428 1-1
package xyz.itwill.net;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
채팅 클라이언트 프로그램 - GUI
 > 서버에서 보내온 메세지를 전달받아 JTextArea컴퍼넌트에 출력 - 무한루프
 > JTextField 컴퍼넌트에서 입력된 메세지를 서버에 전달 - 이벤트 처리 메소드
 */
public class ChatClientApp extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private JTextArea jTextArea;
	private JTextField jTextField;
	
	//서버와 연결된 Socket 객체를 저장하기 위한 필드
	private Socket socket;
	
	//서버에서 보내온 메세지를 전달받기 위한 입력스트림을 저장하기 위한 필드
	private BufferedReader in;
	
	//서버에게 메세지를 보내기 위한 출력스트림을 저장하기 위한 필드
	private PrintWriter out;
	
	//대화명을 저장하기 위한 필드
	private String aliasName;
	
	public ChatClientApp(String title) {
		super(title);

		jTextArea=new JTextArea();
		jTextField=new JTextField();
		
		jTextArea.setFont(new Font("굴림체", Font.BOLD, 20));
		jTextField.setFont(new Font("굴림체", Font.BOLD, 20));
		
		jTextArea.setFocusable(false);
		
		JScrollPane jScrollPane = new  JScrollPane(jTextArea);
		
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		getContentPane().add(jTextField, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700,200,400,500);
		setVisible(true);
		
		//jTextField 컴퍼넌트에서 발생된 ActionEvent를 처리하기 위한 ActionListener객체를 추가하여 이벤트 처리
		jTextField.addActionListener(this);
		
		try {
			socket = new Socket("192.168.13.5",5000);
			// 소켓의 입력스트림을 제공받아 대량의 문자데이터를 읽을 수 있는 입력스트림으로 확장하여 필드에 저장
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			/* 소켓의  출력스트림을 제공받아 문자열을 전달할 수 있는 출력스트림으로 확장하여 필드에 저장
			 > PrintWriter클래스의 PrintWriter(OutputStream out, boolean autuFlush) 생성자를 사용하여
			 PrintWriter 객체 생성
			 > autuFlush 매개변수에 [true]를 전달하면 버퍼를 사용하지 않고 무조건 출력스트림으로 데이타를 전달 */
			out= new PrintWriter(socket.getOutputStream(),true);
			
			//socket 객체를 생성하여 필드에 저장 - 서버에 접속
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this, "서버에 접속 불가능", "접속오류", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		// 정상적인 대화명을 입력받기 위한 반복문
		while(true) {
			aliasName=JOptionPane.showInputDialog(this, "대화명을 입력해주세요."
					, "대화명 입력", JOptionPane.QUESTION_MESSAGE);
			
			String regEx="^[가-힣]{2,6}$";//정규 표현식 저장
			//정규표현식과 입력값(대화명)의 패턴이 같은 경우 반복문 종료
			if(Pattern.matches(regEx, aliasName))break;
			
			JOptionPane.showMessageDialog(this, "정상적인 대화명 입력 필요",
					"입력오류", JOptionPane.ERROR_MESSAGE);
		}
		
		//입력된 대화명을 서버에게 전달
		out.println(aliasName);
		
		
		//서버에서 보내온 메세지를 반환받아 JTextArea 컴퍼넌트에 추가하여 출력
		// >  프로그램이 종료되기 전까지 무한반복
		while(true) {
			try { 
				jTextArea.append(in.readLine()+"\n");
				
				//jTextArea 컴퍼넌트의 스크롤을 하단으로 이동
				jTextArea.setCaretPosition(jTextArea.getText().length());
			}catch(IOException e) {//서버측에서 프로그램 강제종료 시 발생할 수 있음
				JOptionPane.showMessageDialog(this, "서버와의 연결이 끊어졌습니다.",
						"접속오류", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClientApp("자바 채팅");
	}

	//JTextField 컴퍼넌트에서 입력된 문자열(메세지)을 반환받아 서버에 전달하는 명령 작성 
	@Override
	public void actionPerformed(ActionEvent e) {
		String message = jTextField.getText();
		
		if(!message.equals("")) {//입력된 메세지가 존재할 경우
			out.println(message);
			
			jTextField.setText("");
		}
		
	}
}
