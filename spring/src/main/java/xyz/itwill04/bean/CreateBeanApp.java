package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
 
//Spring ?��?��?��?��?��?��?��?�� BeanFactory 객체 ?��?�� ApplicationContext 객체�? ?��?���? 컨테?��?��
//(Spring Container) 기능 ?���?
// => ?��?���? 컨테?��?��?�� ?��경설?��?��?��(Spring Bean Configuration File - XML)�? ?��?��?���? ?��공받?�� 
//Spring Bean(객체) �?�?
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1.BeanFactory 객체�? ?��?��?��?�� ?��?���? 컨테?��?���? ?��?��?��?�� 방법");
		System.out.println("=============== Spring Container 초기?�� ?�� ===============");
		//BeanFactory ?��?��?��?��?���? ?��?��받�? ?��?��?��?��?���? 객체 ?��?�� - BeanFactory 객체 
		// => BeanFactory 객체�? ?��?��?�� ?�� Spring Bean Configuration File?�� ?��공받?�� ?��?���? 
		//컨테?��?�� ?��?�� - ?��?���? 컨테?��?�� 초기?�� ?��?�� 
		// => 매개�??��?��?�� Spring Bean Configuration File?�� 경로�? ?��공받?�� Resource 객체�? ?��?��?��?�� ?��?��
		// => BeanFactory 객체?�� Spring Bean Configuration File?�� ?��록된 ?��?��?���? 미리 객체�?
		//?��?��?���? ?���? Spring Bean ?���??��  ?��?��?��?�� ?���?
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("=============== Spring Container 초기?�� ?�� ===============");
		//BeanFactory.getBean(String beanName) : 매개�??���? Spring Bean�? 구분?���? ?��?�� ?��별자
		//(beanName)?�� ?��?��받아 ?��?���? 컨테?��?��로�??�� Spring Bean(객체)�? ?��?��?��?�� 반환?��?�� 메소?��
		// => Object ???��?�� 객체�? 반환?���?�? 반드?�� 명시?�� 객체 ?���??�� ?��?��
		// => 매개�??���? ?��?��받�? ?��별자(beanName)?�� Spring Bean?�� ?��?�� 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean1=(CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("==========================================================");
		System.out.println("2.ApplicationContext 객체�? ?��?��?��?�� ?��?���? 컨테?��?���? ?��?��?��?�� 방법");
		System.out.println("=============== Spring Container 초기?�� ?�� ===============");
		//ApplicationContext ?��?��?��?��?���? ?��?��받�? ?��?��?��?��?���? 객체 ?��?�� - ApplicationContext 객체
		// => ApplicationContext 객체�? ?��?��?�� ?�� Spring Bean Configuration File?�� ?��공받?�� 
		//?��?���? 컨테?��?�� ?��?�� - ?��?���? 컨테?��?�� 초기?�� ?��?�� 
		// => ?��?��?���? 참조 �??��?�� ?��?��(ClassPath)?�� ???��?�� Spring Bean Configuration File?�� ?��공받?�� ?��?��
		// => ApplicationContext 객체?�� Spring Bean Configuration File?�� ?��록된 ?��?��?���? 미리 
		//객체�? ?��?��?��?�� Spring Bean ?���??�� 미리 ?��?��?�� 객체�? ?���?		
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("=============== Spring Container 초기?�� ?�� ===============");
		//DL(Dependency Lookup) : ?��?���? 컨테?��?���? �?리하?�� 객체(Spring Bean)�? �??��?��?�� ?��공하?�� 기능 
		//ApplicationContext.getBean(String beanName) : 매개�??���? Spring Bean�? 구분?���? ?��?�� 
		//?��별자(beanName)?�� ?��?��받아 ?��?���? 컨테?��?��로�??�� Spring Bean(객체)�? 반환?��?�� 메소?��
		// => Object ???��?�� 객체�? 반환?���?�? 반드?�� 명시?�� 객체 ?���??�� ?��?��
		// => 매개�??���? ?��?��받�? ?��별자(beanName)?�� Spring Bean?�� ?��?�� 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean2=(CreateBean)context.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext 객체�? ?��거하?�� 메소?��
		// => ?��?���? 컨테?��?���? ?��멸되�? ?��?�� ?��?���? 컨테?��?��?�� ?��?�� �?리되?�� 모든 객체(Spring Bean)�? ?��?�� ?���?
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	} 
}
