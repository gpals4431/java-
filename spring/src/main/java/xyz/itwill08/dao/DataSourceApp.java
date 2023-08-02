package xyz.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*Data Source ��ü : �ټ��� ���ؼ� ��ü�� �̸� �����Ͽ� �����ϰ� �ִ� ��ü - DBCP
=>Spring Bean Configuration File ���� �����ͼҽ� �������̽��� ��ӹ��� �ڽ�Ŭ������ SpringBean���� ����Ͽ� ���

1.�����ͼҽ� �������̽��� ��ӹ��� �ڽ�Ŭ������ �����������ӿ�ũ���� �����ϴ� spring jdbc���̺귯�� �̿� -���̺� ���:pom.xml
2.�����ͼҽ� ���� ���̺귯�� �ܿ� ����Ŭ Driver ���� ���̺귯���� ������Ʈ ���� ó��

������ �����̳ʿ��� Data Source ��ü�� �����޾� Connection ��ü�� ��ȯ�޾� ���
*/
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		DataSource dataSource=context.getBean("dataSource", DataSource.class);
		System.out.println("==========================================================");
		System.out.println("dataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		System.out.println("connection = "+connection);
		connection.close();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
