package xyz.itwill08.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.itwill07.aop.AopAnnotationBean;


/*Data Source ��ü : �ټ��� ���ؼ� ��ü�� �̸� �����Ͽ� �����ϰ� �ִ� ��ü - DBCP
=>Spring Bean Configuration File ���� �����ͼҽ� �������̽��� ��ӹ��� �ڽ�Ŭ������ SpringBean���� ����Ͽ� ���

1.�����ͼҽ� �������̽��� ��ӹ��� �ڽ�Ŭ������ �����������ӿ�ũ���� �����ϴ� spring jdbc���̺귯�� �̿� -���̺� ���:pom.xml
2.�����ͼҽ� ���� ���̺귯�� �ܿ� ����Ŭ Driver ���� ���̺귯���� ������Ʈ ���� ó��

������ �����̳ʿ��� Data Source ��ü�� �����޾� Connection ��ü�� ��ȯ�޾� ���
*/
public class DataSourceApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-5_aopAnnotation.xml");
		AopAnnotationBean bean=context.getBean("aopAnnotationBean", AopAnnotationBean.class);
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
