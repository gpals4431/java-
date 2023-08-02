package xyz.itwill07.aop;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

import lombok.Setter;

//java mail ����� �����ϱ� ���� spring-context-support ���̺귯���� javax.mail ���̺귯�� ����ó�� - ���̺� �̿� :pom.xml

/* ���� ���� ����� �����ϱ� ���� Ŭ���� - ���� ������ SMPT ���񽺸� ����Ͽ� ������ ����
=> ���� ����(Mail Server): ������ �ۼ����ϴ� ���񽺸� �����ϴ� ��ǻ�� 
=> SMTP(Simple Message Transfer Protocol) ���񽺷� ������ ������ POP3(Post Office Protocol3)
���񽺳� IMAP(Internet Message Access Protocol) ���񽺷� ������ �޾� ����ڿ��� ���� */ 
public class EmailSendBean {
	//JavaMailSender ��ü�� �����ϱ� ���� �ʵ� ����
	//=>JavaMailSender��ü: SMTP ���񽺸� �����ϴ� ������ ������ �����ϱ� ���� ��ü
	@Setter
	private JavaMailSender javaMailSender;
	
	//������ �����ϴ� �޼ҵ�
	//=> ������ �޴� ����� �̸��� �ּ�, ����, ������ �Ű������� ���޹޾� ����
	//=> ������ �޴� ����� �̸��� �ּҸ� ��ȯ
	public String sendEmail(String email, String subject, String content) throws Exception {
		//javaMailSender.createMimeMessage(): MimeMessage ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		//MimeMessage ��ü : ���� ���� ���� ������ �����ϱ� ���� ��ü 
		MimeMessage message = javaMailSender.createMimeMessage();
		
		//MimeMessage.setSubject(String subject) :  MimeMessage ��ü�� ���� ������ �����ϴ� �޼ҵ�
		message.setSubject(subject);
	
		//MimeMessage.setText(String content) :  MimeMessage ��ü�� ���� ������(�Ϲ� ����) �����ϴ� �޼ҵ�
		//message.setText(content);
		
		//MimeMessage.setContent(String content, String content) :  MimeMessage ��ü�� ���� ������ �����ϴ� �޼ҵ�
		//=> Ÿ�� �Ű������� ���Ϸ� ������ ������ ����(MimeType)�� �����Ͽ� ����
		message.setContent(content, "text/html; charset=utf-8");//html ���� ���� ����
		
		//message.setRecipient((RecipientType type, Address address) : ������ �޴� ����� �̸���
		//�ּҰ��� ������ �����ϴ� �޼ҵ�
		//RecipientType : ���� ���� ����ڸ� �����ϱ� ���� ��� ����
		//Address : �̸��� �ּҰ� ����� Address ��ü�� ����
		//InternetAddress ��ü : �̸��� �ּҸ� �����ϱ����� ��ü
		//message.setRecipient(RecipientType.TO, new InternetAddress(email));
		
		//message.setRecipient(Message.RecipientType, Address[])) : ������ �޴� �ټ��� ������� �̸���
		//�ּҰ��� ������ �����ϴ� �޼ҵ�
		message.setRecipient(RecipientType.TO, new InternetAddress(email));
		
		//javaMailSender.send(message): SMTP ���񽺸� ����Ͽ� ������ �����ϴ� �޼ҵ�
		javaMailSender.send(message);
		
		
		return email;
	}
}
