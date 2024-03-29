/*0426 02*/
package xyz.itwill.io;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class NotepadApp extends JFrame {
	private static final long serialVersionUID = 1L;

	
	JTextArea jTextArea;
	JMenuItem init/*(초기화)*/, open, save, exit ;  
	
	//FileDialog 클래스 : 파일을 선택하기 위한 다이얼로그를 생성하기 위한 컴퍼넌트 클래스
	FileDialog openDialog, saveDialog;
	
	//filepath : 현재 작업 중인 문서파일의 경로를 저장하기위한 필드
	private String filepath;
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar jMenuBar =new JMenuBar();
		JMenu jMenu = new JMenu("파일(F)");
		jMenu.setMnemonic('F');//Alt를 눌러 키보드로 메뉴 선택가능, 빠르게 선택할 수 있는 문자 지정, 단축키x
		
		
		//메뉴아이템을 선택할 경우 ActionEvent 발생 > 1. 버튼 눌렀을 때 2.Jtextfield에서 enter 3. 메뉴아이템 선택 
		init=new JMenuItem("새로 만들기(N)", 'N');
		open=new JMenuItem("열기(O)", 'O');
		save=new JMenuItem("저장(S)", 'S');
		exit=new JMenuItem("끝내기(X)", 'X');
		
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK+InputEvent.SHIFT_DOWN_MASK));
	
		
		jMenu.add(init);
		jMenu.add(open);
		jMenu.add(save);
		jMenu.addSeparator();
		jMenu.add(exit);
		
		jMenuBar.add(jMenu);
		
		setJMenuBar(jMenuBar);
		
		jTextArea = new JTextArea();
		jTextArea.setFont(new Font("굴림체", Font.PLAIN, 50));
		
		JScrollPane jScrollPane = new JScrollPane(jTextArea);
		
		getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		openDialog =new FileDialog(this, "열기", FileDialog.LOAD);
		saveDialog =new FileDialog(this, "저장", FileDialog.SAVE);
		
		
		
		init.addActionListener(new NodepadEventHandle());
		open.addActionListener(new NodepadEventHandle());
		save.addActionListener(new NodepadEventHandle());
		exit.addActionListener(new NodepadEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450,150,1000,600);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목없음 = Java 메모장");
		
	}
	
	public class NodepadEventHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Object eventSource = e. getSource();
			
			if(eventSource == init) {
				jTextArea.setText(" ");//JTextArea 컴퍼넌트 초기화
				filepath="";//필드값 초기화
				setTitle("제목없음 - Java메모장");//프레임 제목 초기화
			}else if(eventSource == open) {
				openDialog.setVisible(true);
				//열기 관련 파일 다이얼로그를 화면에 출력
				// >> 파일을 선택하거나 선택을 취소한 경우 파일 다이얼로그는 자동으로 숨김처리

				// FileDialog.getFile() : 선택된 파일의 이름을 반환하는 메소드 > 취소 또는 창닫기 한 경우 메소드 종료
				if(openDialog.getFile()==null) return;
				
				// FileDialog.getDirectory() : 선택된 파일의 디렉토리 경로를 반환하는 메소드 > 절대 경로를 만들어줌
				filepath = openDialog.getDirectory()+openDialog.getFile();//선택된 파일의 경로 저장
				
				try {
					//파일 경로를 제공받아 파일 입력스트림 생성
					BufferedReader in = new BufferedReader(new FileReader(filepath));//문서파일을 읽으려면 리더랑 라이터 사용 좀 더 빠르게 사용하기위해서 버퍼드로 확장
					
				jTextArea.setText("");//jTextArea 컴퍼넌트 초기화
				
				while(true) {
					//파일에 저장된 값을 한줄씩 읽어 문자열로 반환받아 저장
					String text = in.readLine();//버퍼로 확장하면 문자열을 한꺼번에 통째로 읽어드릴수있음 엔터를 칠때 까지
					if(text==null)break; // 파일 내용이 없는 경우 반복문 종료
					//변수에 저장된 문자열을 JTextArea 컴퍼넌트에 추가하여 출력
					jTextArea.append(text+"\n");
				}
				 in.close();
				 
				
				 setTitle(openDialog.getFile()+" - Java 메모장");
				}catch(FileNotFoundException exception) {//먼저 안쓰면 에러 >> IO이 부모이기 때문에
				 JOptionPane.showMessageDialog(null, "파일을 찾을 수 없습니다.");//부모없으면 null로 입력 가능
				}catch(IOException exception) {//오버라이드 선언 >> throws를 떠넘길 수 없음
				JOptionPane.showMessageDialog(null, "프로그램에 문제 발생");//부모없으면 null로 입력 가능
				}
				
			}else if(eventSource == save) {
				if(filepath == null || filepath.equals("")) {
					
				//저장 과련 파일 다이얼로그를 화면에 출력
				saveDialog.setVisible(true);
				
				if(saveDialog.getFile()==null) return;//파일을 선택하거나 선택을 취소 또는 창닫기 한 경우 메소드 종료
				
				filepath=saveDialog.getDirectory()+saveDialog.getFile();

				setTitle(saveDialog.getFile()+" - Java 메모장");
				}
				
				try {
					//파일 경로를 제공받아 파일 출력스트림 생성
					BufferedWriter out = new BufferedWriter(new FileWriter(filepath));
					
					//JTextArea 컴퍼넌트의 모든 문자열을 반환받아 저장
					String text = jTextArea.getText();
					
					//반환받은 문자열을 파일 출력스트림으로 전달하여 저장
					out.write(text);
					
					out.close();
					
				}catch(IOException exception) {//오버라이드 선언 >> throws를 떠넘길 수 없음
					JOptionPane.showMessageDialog(null, "프로그램에 문제 발생");//부모없으면 null로 입력 가능
					}
				
			}else if(eventSource == exit) {
				System.exit(0);
				
			}
		}
	}
}
