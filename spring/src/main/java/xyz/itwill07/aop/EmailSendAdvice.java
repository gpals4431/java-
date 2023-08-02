package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailSendAdvice {
	//������ �����ϱ� ���� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - Before Advice Method
	//=> �޴� ����� �̸����ּҿ� ������ �����޾� �α� ó��
	public void accessLog(JoinPoint joinPoint) {
		//Ÿ�ٸ޼ҵ��� �Ű��������� �޴»���� �̸��� �ּҸ� �����޾� ����
		String email=(String)joinPoint.getArgs()[0];
		//Ÿ�ٸ޼ҵ��� �Ű��������� �޴»���� ������ �����޾� ����
		String subject=(String)joinPoint.getArgs()[1];
		log.info(email+"�Կ��� <"+subject+"> ������ �̸����� �����մϴ�.");
	}
	
	//���� ���� �Ŀ� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� -
	//
	public void successLog(String email) {
		log.info(email+"�Կ��� �̸����� ���������� �����Ͽ����ϴ�.");
	}
	
	//���� ���� ���� �Ŀ� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ�
	//=> ���� ���� ���п� ���� �޼����� Ÿ�� �޼ҵ��� ���ܷκ��� �����޾� ����ϴ� ��� �ۼ�
	public void errorLog(Exception exception) {
		log.info("�̸��� ���� ���� = "+exception.getMessage());
	}
}
