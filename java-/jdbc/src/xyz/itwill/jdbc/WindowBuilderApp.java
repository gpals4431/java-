package xyz.itwill.jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class WindowBuilderApp extends JFrame {
	private JButton btnNewButton_2;
	private JPanel panel;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilderApp() {//생성자에서만 사용 가능  >> 이벤트 처리는 불가 >> xonvert local to filed 버튼 클릭
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("빨간색");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("HY중고딕", Font.BOLD, 12));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("파란색");
		btnNewButton_1.setFont(new Font("Dialog", Font.ITALIC, 12));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("녹색");
		btnNewButton_2.setFont(new Font("HY헤드라인M", Font.PLAIN, 12));
		btnNewButton_2.setForeground(Color.GREEN);
		panel.add(btnNewButton_2);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setText("ㅇㄹㅇㄹㅇㄹㅇ");
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
	}

}
