package xyz.itwill06.oop;

//Proxy Ŭ���� - ���⼭ ������
//�ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ尡 ���Ե� �޼ҵ带 �����ϴ� Ŭ���� - proxyŬ���� : �������� �ڵ����� �������
public class AopProxy implements Aop{
	//�ٽɰ����ڵ��� �޼ҵ尡 ����� Ŭ������ ��ü�� �����ϱ� ���� �ʵ�
	//=> �ʵ��� �ڷ����� �������̽��� �����Ͽ� ��� �ڽ�Ŭ������ ��ü�� ����ǵ��� ����
	private Aop target;
	
	//Ⱦ�ܰ����ڵ��� �޼ҵ尡 ����� Ŭ������ ��ü�� �����ϱ� ���� �ʵ�
	private AopLogger logger;
	
	//�����ڸ� �̿��Ͽ� �ʵ忡 ��ü�� ���޹޾� �����ϰų� ��ü�� ���� �����Ͽ� �ʵ忡 ���� - di ������ ����
	public AopProxy(Aop target) {
		this.target=target;
		logger=new AopLogger();
	}
	
	//�������̽��� ��ӹ޾� �������̵� ����� �޼ҵ�(PointCut)���� �ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ尡 
	//���ԵǾ�(Weaving)�Ǿ� ����� ����ǵ��� �ۼ�
	//=> �ٽɰ����ڵ尡 �ۼ��� �޼ҵ� ȣ�� �� �Ǵ� �Ŀ� Ⱦ�� �����ڵ尡 �ۼ��� �޼ҵ� 
	//=> Ⱦ�ܰ����ڵ尡 ���Ե� ��ġ : JoinPont
	@Override
	public void display1() {
		logger.beforeLog();//Ⱦ�ܰ����ڵ尡 �ۼ��� �޼ҵ� ȣ��
		target.display1();//�ٽɰ����ڵ尡 �ۼ��� �޼ҵ� ȣ��
		
	}

	@Override
	public void display2() {
		logger.beforeLog();//Ⱦ�ܰ����ڵ尡 �ۼ��� �޼ҵ� ȣ��
		target.display2();//�ٽɰ����ڵ尡 �ۼ��� �޼ҵ� ȣ��
	}

	@Override
	public void display3() {
		logger.beforeLog();//Ⱦ�ܰ����ڵ尡 �ۼ��� �޼ҵ� ȣ��
		target.display3();//�ٽɰ����ڵ尡 �ۼ��� �޼ҵ� ȣ��
	}

}
