package xyz.itwill10.exception;

//ȸ�������� ���� ����, ����, �˻��� �� ����ڷκ��� ���޹��� ���̵��� ȸ�������� ���� ��� 
//�߻��� ���ܸ� ó���ϱ� ���� ���� Ŭ���� 
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}
}