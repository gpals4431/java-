package xyz.itwill07.aop;

//�ٽɰ��ɸ��
public class JoinPointBean {
	public void add() {
		System.out.println("*** JoinPointBeanŬ������ add()�޼ҵ� ȣ�� ***");
	}
	public void modify(int num, String name) {
		System.out.println("*** JoinPointBeanŬ������ modify()�޼ҵ� ȣ�� ***");
	}
	public void remove(int num) {
		System.out.println("*** JoinPointBeanŬ������ remove()�޼ҵ� ȣ�� ***");
	}
	public String getName() {
		System.out.println("*** JoinPointBeanŬ������ getName()�޼ҵ� ȣ�� ***");
		return "ȫ�浿";
	}
	public void calc(int num1, int num2) {
		System.out.println("*** JoinPointBeanŬ������ calc()�޼ҵ� ȣ�� ***");
		System.out.println("�� ="+(num1/num2));
	}
}
