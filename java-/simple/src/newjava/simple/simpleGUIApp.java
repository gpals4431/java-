package newjava.simple;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class simpleGUIApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTable table;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel searchLabel;
	private JPanel panel_4;
	private JLabel inLabel;
	private JLabel inoutLabel;
	private JLabel outLabel;
	private JLabel inoutLabel_1;
	private JLabel name_Label;
	private JLabel inoutLabel_2;

	JTextField amoney_TF, aname_TF, usedate_TF, search_TF, inout_TF, in_TF, out_TF;
	JButton search_btn, clear_btn, insert_btn, delete_btn, update_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					simpleGUIApp frame = new simpleGUIApp();
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
	public simpleGUIApp() {
		setTitle("◆◆◆ 계좌 관리 프로그램 ◆◆◆");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 514);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Object[] title = { "내역명", "금액", "입/출금", "사용날짜", "출금내역", "입금내역" };
		table = new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		contentPane.add(table, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(2, 6, 0, 0));

		name_Label = new JLabel("사용처");
		name_Label.setBackground(Color.WHITE);
		name_Label.setHorizontalAlignment(SwingConstants.RIGHT);
		name_Label.setFont(new Font("돋움", Font.BOLD, 15));
		panel_2.add(name_Label);

		aname_TF = new JTextField();
		panel_2.add(aname_TF);
		aname_TF.setColumns(10);

		inoutLabel_1 = new JLabel("금액");
		inoutLabel_1.setBackground(Color.WHITE);
		inoutLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		inoutLabel_1.setFont(new Font("돋움", Font.BOLD, 15));
		panel_2.add(inoutLabel_1);

		amoney_TF = new JTextField();
		panel_2.add(amoney_TF);
		amoney_TF.setColumns(10);

		inoutLabel = new JLabel("입/출금");
		inoutLabel.setBackground(Color.WHITE);
		inoutLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		inoutLabel.setFont(new Font("돋움", Font.BOLD, 15));
		panel_2.add(inoutLabel);

		inout_TF = new JTextField();
		inout_TF.setColumns(10);
		panel_2.add(inout_TF);

		inoutLabel_2 = new JLabel("날짜");
		inoutLabel_2.setBackground(Color.WHITE);
		inoutLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		inoutLabel_2.setFont(new Font("돋움", Font.BOLD, 15));
		panel_2.add(inoutLabel_2);

		usedate_TF = new JTextField();
		usedate_TF.setColumns(10);
		panel_2.add(usedate_TF);

		outLabel = new JLabel("지출내역");
		outLabel.setBackground(Color.WHITE);
		outLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		outLabel.setFont(new Font("돋움", Font.BOLD, 15));
		panel_2.add(outLabel);

		out_TF = new JTextField();
		out_TF.setColumns(10);
		panel_2.add(out_TF);

		inLabel = new JLabel("수입내역");
		inLabel.setBackground(Color.WHITE);
		inLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		inLabel.setFont(new Font("돋움", Font.BOLD, 15));
		panel_2.add(inLabel);

		in_TF = new JTextField();
		in_TF.setColumns(10);
		panel_2.add(in_TF);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3, BorderLayout.SOUTH);

		searchLabel = new JLabel("검색항목");
		searchLabel.setFont(new Font("돋움", Font.BOLD, 15));
		panel_3.add(searchLabel);

		search_TF = new JTextField();
		search_TF.setFont(new Font("돋움체", Font.PLAIN, 15));
		search_TF.setColumns(20);
		panel_3.add(search_TF);

		// 검색 버튼
		search_btn = new JButton("검색");

		search_btn.setForeground(new Color(255, 255, 255));
		search_btn.setBackground(Color.DARK_GRAY);
		search_btn.setFont(new Font("돋움", Font.BOLD, 15));
		panel_3.add(search_btn);
		search_btn.addActionListener(this);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// 삽입 버튼
		insert_btn = new JButton(" 추 가 ");
		insert_btn.setForeground(Color.WHITE);
		insert_btn.setBackground(Color.DARK_GRAY);
		panel_4.add(insert_btn);
		insert_btn.setFont(new Font("굴림", Font.BOLD, 15));
		insert_btn.addActionListener(this);

		// 변경 버튼
		update_btn = new JButton(" 수 정 ");
		update_btn.setBackground(Color.DARK_GRAY);
		update_btn.setForeground(Color.WHITE);
		panel_4.add(update_btn);
		update_btn.setFont(new Font("굴림", Font.BOLD, 15));
		update_btn.addActionListener(this);

		// 삭제 버튼
		delete_btn = new JButton(" 삭 제 ");
		delete_btn.setForeground(Color.WHITE);
		delete_btn.setBackground(Color.DARK_GRAY);
		panel_4.add(delete_btn);
		delete_btn.setFont(new Font("굴림", Font.BOLD, 15));
		delete_btn.addActionListener(this);

		// 초기화 버튼
		clear_btn = new JButton("초기화");
		clear_btn.setForeground(Color.WHITE);
		clear_btn.setBackground(Color.DARK_GRAY);
		panel_4.add(clear_btn);
		clear_btn.setFont(new Font("굴림", Font.BOLD, 15));
		clear_btn.addActionListener(this);

		// 프로그램 실행시 테이블을 보여주는 메소드 호출
		displayAllaccountList();

	}// GUI 메소드 호출

	// 수정 버튼 누른 후 TF에 컴퍼넌트를 비활성화 처리하는 메소드
	// 모든 TF에 컴퍼넌트를 비활성화 처리하는 메소드
	public void updateinitialize() {
		amoney_TF.setEditable(false);
		search_TF.setEditable(false);
		inout_TF.setEditable(false);
		out_TF.setEditable(false);
		in_TF.setEditable(false);
		aname_TF.setEditable(true);
		usedate_TF.setEditable(true);
	}
	public void update_change_initialize() {
		amoney_TF.setEditable(true);
		search_TF.setEditable(true);
		inout_TF.setEditable(true);
		out_TF.setEditable(true);
		in_TF.setEditable(true);
		aname_TF.setEditable(true);
		usedate_TF.setEditable(true);
	}
	//TF 컴퍼넌트 활성화
	public void initialize() {
		amoney_TF.setEditable(true);
		search_TF.setEditable(true);
		inout_TF.setEditable(true);
		out_TF.setEditable(true);
		in_TF.setEditable(true);
		aname_TF.setEditable(true);
		usedate_TF.setEditable(true);
	}
	//추가 버튼 누른 후 TF 컴퍼넌트 비활성화 처리하는 메소드
	public void insertinitialize() {
		amoney_TF.setEditable(true);
		search_TF.setEditable(false);
		inout_TF.setEditable(true);
		out_TF.setEditable(true);
		in_TF.setEditable(true);
		aname_TF.setEditable(true);
		usedate_TF.setEditable(true);
	}
		
	// 모든 TF 컴퍼넌트의 입력값을 초기화하는 메소드
	public void clear() {
		amoney_TF.setText("");
		aname_TF.setText("");
		inout_TF.setText("");
		usedate_TF.setText("");
		out_TF.setText("");
		in_TF.setText("");
		search_TF.setText("");

	}
	//초기화 버튼을 눌렀을 떄 실행되는 메소드
	public void none() {
		clear();
		displayAllaccountList();
		initialize();
		update_change_initialize();
	}


	// 프로그램 실행전 테이블을 보여주는 메소드
	private void displayAllaccountList() {
		List<simpleDTO> accountList = simpleDAOImpl.getDao().selectAllaccountList();

		if (accountList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 계좌정보가 없습니다");
			return;
		}

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// 첫번째 행을 삭제하는 메소드
		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		// vector 객체 생성 - JTable 컴퍼넌트에 추가될 하나의 행을 저장하기 위한 객체
		for (simpleDTO account : accountList) {
			Vector<Object> rowData = new Vector<>();

			// simpleDTO 객체의 필드값을 Vector 객체의 요소로 추가 - 배열 나열
			rowData.add(account.getAname());
			rowData.add(account.getAmoney());
			rowData.add(account.getAinout());
			rowData.add(account.getUsedate());
			rowData.add(account.getAout());
			rowData.add(account.getAin());

			// JTable 컴퍼넌트에 행을 추가하여 출력
			model.addRow(rowData);
		}
	}

	// 삽입시 메소드
	// 입력값 검증
	private boolean insertaccount() {
		insertinitialize();
		String name = aname_TF.getText();

		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "사용처명을 반드시 입력해주세요.");
			aname_TF.requestFocus();
			return false;
		}
		String nameReg = "^[0-9a-zA-Zㄱ-ㅎ가-힣]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "1자리 이상 입력해주세요.");
			aname_TF.requestFocus();
			return false;
		}

		String money = amoney_TF.getText();
		if (money.equals("")) {
			JOptionPane.showMessageDialog(this, "금액을 반드시 입력해주세요.");
			amoney_TF.requestFocus();
			return false;
		}
		String moneyReg = "\\d{1,10}$";
		if (!Pattern.matches(moneyReg, money)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
			JOptionPane.showMessageDialog(this, "금액은 숫자로만 입력해 주세요.");
			amoney_TF.requestFocus();
			return false;
		}

		String inout = inout_TF.getText();
		if (!inout.equals("입금") && !inout.equals("출금")) {
			JOptionPane.showMessageDialog(this, "입금과 출금 중 하나를 선택하여 입력해주세요.");
			inout_TF.requestFocus();
			return false;

		}

		String date = usedate_TF.getText();
		if (date.equals("")) {
			JOptionPane.showMessageDialog(this, "사용날짜를 반드시 입력해주세요.");
			usedate_TF.requestFocus();
			return false;
		}

		String dateReg = "(2[0-9])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if (!Pattern.matches(dateReg, date)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
			JOptionPane.showMessageDialog(this, "[yy-mm-dd] 형식에 맞게 입력해주세요.");
			usedate_TF.requestFocus();
			return false;
		}

		String out = out_TF.getText();
		if (!out.equals("") && !out.equals("식사") && !out.equals("교통비") && !out.equals("생활") && !out.equals("의료/건강")
				&& !out.equals("문화/여가") && !out.equals("주거/통신") && !out.equals("저금/투자")) {
			JOptionPane.showMessageDialog(this, " 지출 내역은 식사, 교통비, 생활, 의료/건강, 문화/여가, 주거/통신,저금/투자" + " 하나를 선택하여 입력해주세요.");
			out_TF.requestFocus();
			return false;

		}

		String in = in_TF.getText();
		if (!in.equals("") && !(in.equals("급여")) && !(in.equals("용돈")) && !(in.equals("사업수익"))
				&& !(in.equals("금융수익"))) {
			JOptionPane.showMessageDialog(this, " 수입 내역은 급여, 용돈, outea싟사업수익, 금융수익" + "중 하나를 선택하여 입력해주세요.");
			in_TF.requestFocus();
			return false;

		}

		simpleDTO account = new simpleDTO();
		account.setAname(name);
		account.setAmoney(Integer.parseInt(money));
		account.setAinout(inout);
		account.setUsedate(date);
		account.setAout(out);
		account.setAin(in);

		int rows = simpleDAOImpl.getDao().insertAccountBook(account);

		JOptionPane.showMessageDialog(this, rows + "개의 정보를 삽입하였습니다.");

		// 모든 테이블을 보여주는 메소드 호출
		displayAllaccountList();

		/* TF 컴포넌트 초기화
		// TF 컴포넌트 초기화
		aname_TF.setText("");
		amoney_TF.setText("");
		inout_TF.setText("");
		usedate_TF.setText("");
		out_TF.setText("");
		in_TF.setText("");*/
		
		clear();
		return false;
	}

	/*
	 * // 이름과 날짜를 입력받아 정보를 변경하는 메소드 첫번째 버튼을 눌렀을 때 이름과 날짜를 검색하여 테이블에 출력하는 메소드 호출
	 * public boolean updatechangeaccount() { updateinitialize();
	 * 
	 * }
	 */
	// 이름과 날짜를 입력받아 정보를 변경하는 메소드 첫번째 버튼을 눌렀을 때 이름과 날짜를 검색하여 출력하는 메소드 호출
	// >> 두번재 눌렀을때 이름과 날자를 제외한 변경값을 받아 테이블에 저장된 정보를 변경하는 메소드
	private boolean updateaccount() {
		
		updateinitialize();

	
		return false;
		}
		
		
		
	private boolean update_change_account() {
		String name = aname_TF.getText();

		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "사용처명을 반드시 입력해주세요.");
			aname_TF.requestFocus();
			return false;
		}
		String nameReg = "^[0-9a-zA-Zㄱ-ㅎ가-힣]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "1자리 이상 입력해주세요.");
			aname_TF.requestFocus();
			return false;
		}

		String date = usedate_TF.getText();
		if (date.equals("")) {
			JOptionPane.showMessageDialog(this, "사용날짜를 반드시 입력해주세요.");
			usedate_TF.requestFocus();
			return false;
		}

		String dateReg = "(2[0-9])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if (!Pattern.matches(dateReg, date)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
			JOptionPane.showMessageDialog(this, "[yy-mm-dd] 형식에 맞게 입력해주세요.");
			usedate_TF.requestFocus();
			return false;
		
		}
		
		simpleDTO account = simpleDAOImpl.getDao().update_changeAccountBook(aname_TF.getText(), usedate_TF.getText());
		String money = amoney_TF.getText();
		if (money.equals("")) {
			JOptionPane.showMessageDialog(this, "금액을 반드시 입력해주세요.");
			amoney_TF.requestFocus();
			return false;
		}
		String moneyReg = "\\d{1,10}$";
		if (!Pattern.matches(moneyReg, money)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
			JOptionPane.showMessageDialog(this, "금액은 숫자로만 입력해 주세요.");
			amoney_TF.requestFocus();
			return false;
		}

		if(account == null) {
			JOptionPane.showMessageDialog(this, "저장된 정보가 없습니다.");
			return false;
		
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String inout = inout_TF.getText();
		if (!inout.equals("입금") && !inout.equals("출금")) {
			JOptionPane.showMessageDialog(this, "입금과 출금 중 하나를 선택하여 입력해주세요.");
			inout_TF.requestFocus();
			return false;

		}

	

		String out = out_TF.getText();
		if (!out.equals("") && !out.equals("식사") && !out.equals("교통비") && !out.equals("생활") && !out.equals("의료/건강")
				&& !out.equals("문화/여가") && !out.equals("주거/통신") && !out.equals("저금/투자")) {
			JOptionPane.showMessageDialog(this, " 지출 내역은 식사, 교통비, 생활, 의료/건강, 문화/여가, 주거/통신,저금/투자" + " 하나를 선택하여 입력해주세요.");
			out_TF.requestFocus();
			return false;

		}

		String in = in_TF.getText();
		if (!in.equals("") && !(in.equals("급여")) && !(in.equals("용돈")) && !(in.equals("사업수익"))
				&& !(in.equals("금융수익"))) {
			JOptionPane.showMessageDialog(this, " 수입 내역은 급여, 용돈, 사업수익, 금융수익" + "중 하나를 선택하여 입력해주세요.");
			in_TF.requestFocus();
			return false;

		}
	
		simpleDTO accountchange = new simpleDTO();
		
		accountchange.setAmoney(Integer.parseInt(money));
		accountchange.setAinout(inout);
		accountchange.setAout(out);
		accountchange.setAin(in);
		accountchange.setAname(name);
		accountchange.setUsedate(date);

		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
			Vector<Object> rowData = new Vector<>();
			
			rowData.add(accountchange.getAname());
			rowData.add(accountchange.getAmoney());
			rowData.add(accountchange.getAinout());
			rowData.add(accountchange.getUsedate());
			rowData.add(accountchange.getAout());
			rowData.add(accountchange.getAin());
		int rows = simpleDAOImpl.getDao().updateAccountBook(accountchange);

			model.addRow(rowData);
		
		
		JOptionPane.showMessageDialog(this, rows + "개의 정보를 변경하였습니다.");

		// 모든 테이블을 보여주는 메소드 호출
		displayAllaccountList();
		// TF 컴포넌트 초기화
		//aname_TF.setText("");
		//usedate_TF.setText("");

		none();
		// TF 컴포넌트 초기화
		aname_TF.setText("");
		amoney_TF.setText("");
		inout_TF.setText("");
		usedate_TF.setText("");
		out_TF.setText("");
		in_TF.setText("");

		return false;
	}
	// 이름과 날짜를 입력받아 정보를 변경하는 메소드 첫번째 버튼을 눌렀을 때 이름과 날짜를 검색하여 테이블에 출력하는 메소드 호출
		public boolean update_change_account1() {
			updateinitialize();
			
			String name = aname_TF.getText();

			if (name.equals("")) {
				JOptionPane.showMessageDialog(this, "사용처명을 반드시 입력해주세요.");
				aname_TF.requestFocus();
				return false;
			}
			String nameReg = "^[0-9a-zA-Zㄱ-ㅎ가-힣]*$";
			if (!Pattern.matches(nameReg, name)) {
				JOptionPane.showMessageDialog(this, "1자리 이상 입력해주세요.");
				aname_TF.requestFocus();
				return false;
			}

			String date = usedate_TF.getText();
			if (date.equals("")) {
				JOptionPane.showMessageDialog(this, "사용날짜를 반드시 입력해주세요.");
				usedate_TF.requestFocus();
				return false;
			}

			String dateReg = "(2[0-9])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
			if (!Pattern.matches(dateReg, date)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
				JOptionPane.showMessageDialog(this, "[yy-mm-dd] 형식에 맞게 입력해주세요.");
				usedate_TF.requestFocus();
				return false;
			}
			
			String money = amoney_TF.getText();
			if (money.equals("")) {
				JOptionPane.showMessageDialog(this, "금액을 반드시 입력해주세요.");
				amoney_TF.requestFocus();
				return false;
			}
			String moneyReg = "\\d{1,10}$";
			if (!Pattern.matches(moneyReg, money)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
				JOptionPane.showMessageDialog(this, "금액은 숫자로만 입력해 주세요.");
				amoney_TF.requestFocus();
				return false;
			}

			String inout = inout_TF.getText();
			if (!inout.equals("입금") && !inout.equals("출금")) {
				JOptionPane.showMessageDialog(this, "입금과 출금 중 하나를 선택하여 입력해주세요.");
				inout_TF.requestFocus();
				return false;

			}

			String out = out_TF.getText();
			if (!out.equals("") && !out.equals("식사") && !out.equals("교통비") && !out.equals("생활") && !out.equals("의료/건강")
					&& !out.equals("문화/여가") && !out.equals("주거/통신") && !out.equals("저금/투자")) {
				JOptionPane.showMessageDialog(this, " 지출 내역은 식사, 교통비, 생활, 의료/건강, 문화/여가, 주거/통신, 저금/투자" + " 하나를 선택하여 입력해주세요.");
				out_TF.requestFocus();
				return false;

			}

			String in = in_TF.getText();
			if (!in.equals("") && !(in.equals("급여")) && !(in.equals("용돈")) && !(in.equals("사업수익"))
					&& !(in.equals("금융수익"))) {
				JOptionPane.showMessageDialog(this, " 수입 내역은 급여, 용돈, 사업수익, 금융수익" + "중 하나를 선택하여 입력해주세요.");
				in_TF.requestFocus();
				return false;

			}
			simpleDTO account = new simpleDTO();
			
			account.setAmoney(Integer.parseInt(money));
			account.setAinout(inout);
			account.setAout(out);
			account.setAin(in);
			account.setAname(name);
			account.setUsedate(date);

			int rows = simpleDAOImpl.getDao().updateAccountBook(account);

			JOptionPane.showMessageDialog(this, rows + "개의 정보를 변경하였습니다.");

			// 모든 테이블을 보여주는 메소드 호출
			displayAllaccountList();

			// TF 컴포넌트 초기화
			aname_TF.setText("");
			amoney_TF.setText("");
			inout_TF.setText("");
			usedate_TF.setText("");
			out_TF.setText("");
			in_TF.setText("");

			return false;
		}


	// 이름을 입력받아 검색하는 메소드
	public boolean searchname() {
		search_TF.requestFocus();
		String name = search_TF.getText();
		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "검색창에 사용처를 반드시 입력해주세요.");
			search_TF.requestFocus();
			return false;
		}
		String nameReg = "^[0-9a-zA-Zㄱ-ㅎ가-힣]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "1자리 이상 입력해주세요.");
			search_TF.requestFocus();
			return false;
		}

		List<simpleDTO> accountList = simpleDAOImpl.getDao().selectAnameList(name);

		if (accountList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 정보가 없습니다.");
			return false;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		for (simpleDTO account : accountList) {
			Vector<Object> rowData = new Vector<>();
			
			rowData.add(account.getAname());
			rowData.add(account.getAmoney());
			rowData.add(account.getAinout());
			rowData.add(account.getUsedate());
			rowData.add(account.getAout());
			rowData.add(account.getAin());

			model.addRow(rowData);
		}
		
		search_TF.setText("");
		return false;
	}

	// 이름과 날짜를 입력받아 삭제버튼을 눌러 테이블의 정보를 삭제하는 메소드
	public boolean deleteaccount() {
		updateinitialize();

		String name = aname_TF.getText();
		String date = usedate_TF.getText();

		if (name.equals("") && date.equals("")) {
			JOptionPane.showMessageDialog(this, "이름과 날짜를 반드시 입력해 주세요.");
			aname_TF.requestFocus();
			return false;
		}
		if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "사용처명을 입력해주세요.");
			aname_TF.requestFocus();
			return false;
		}
		String nameReg = "^[0-9a-zA-Zㄱ-ㅎ가-힣]*$";
		if (!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "1자리 이상 입력해주세요.");
			aname_TF.requestFocus();
			return false;
		}

		if (date.equals("")) {
			JOptionPane.showMessageDialog(this, "사용날짜를 반드시 입력해주세요.");
			usedate_TF.requestFocus();
			return false;
		}

		String dateReg = "(2[0-9])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if (!Pattern.matches(dateReg, date)) {// 정규표현식과 입력값의 입력패턴이 다른 경우
			JOptionPane.showMessageDialog(this, "[yy-mm-dd] 형식에 맞게 입력해주세요.");
			usedate_TF.requestFocus();
			return false;
		}

		simpleDTO account = new simpleDTO();

		account.setAname(name);
		account.setUsedate(date);

		int rows = simpleDAOImpl.getDao().deleteAccountBook(account);

		if (rows > 0) {
			JOptionPane.showMessageDialog(this, "계좌 테이블에서" + rows + "개의 정보를 삭제하였습니다.");
		} else {
			JOptionPane.showMessageDialog(this, "계좌 테이블에 삭제할 정보가 없습니다.");
		}
		displayAllaccountList();
		// TF 컴포넌트 초기화
		//aname_TF.setText("");
		//usedate_TF.setText("");

		none();
		
		return false;

	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		Component c = (Component) ev.getSource();
		try {
			if (c == insert_btn) {
				if (!insertaccount())
					return;
				displayAllaccountList();
			} else if (c == delete_btn) {
				if (!deleteaccount())
					return;
				//deleteaccount();
			//처음 수정 버튼을 눌렀을 때 -> 이름과 날짜를 제외한 TF 컴퍼넌트를 비활성화 
			//-> 이름과 날짜 입력 수정버튼-> 해당 정보 테이블에 표시
			//변경 값 입력 후 -> 수정 버튼 -> 변경완료
			} else if (c == update_btn) {
				if (!updateaccount()) {
					return;
				}else {
					initialize();
				}
				deleteaccount();
			} else if (c == update_btn) {
				if (!updateaccount()) {
					return;
				}else {
					update_change_initialize();
					update_change_account();
				}
				displayAllaccountList();
			} else if (c == search_btn) {
				if (!searchname())
					return;
				searchname();
			} else if (c== clear_btn) {
				none();
			}
		} catch (Exception e) {
			System.out.println("예외발생" + e.getMessage());
		}

	}

}