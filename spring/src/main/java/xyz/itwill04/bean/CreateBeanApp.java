package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
 
//Spring ?? ???¬??? BeanFactory κ°μ²΄ ?? ApplicationContext κ°μ²΄λ‘? ?€?λ§? μ»¨ν?΄?
//(Spring Container) κΈ°λ₯ ? κ³?
// => ?€?λ§? μ»¨ν?΄?? ?κ²½μ€? ??Ό(Spring Bean Configuration File - XML)λ‘? ?΄??€λ₯? ? κ³΅λ°? 
//Spring Bean(κ°μ²΄) κ΄?λ¦?
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1.BeanFactory κ°μ²΄λ₯? ??±??¬ ?€?λ§? μ»¨ν?΄?λ‘? ?¬?©?? λ°©λ²");
		System.out.println("=============== Spring Container μ΄κΈ°? ?  ===============");
		//BeanFactory ?Έ?°??΄?€λ₯? ??λ°μ? ???΄??€λ‘? κ°μ²΄ ??± - BeanFactory κ°μ²΄ 
		// => BeanFactory κ°μ²΄λ₯? ??±?  ? Spring Bean Configuration File? ? κ³΅λ°? ?€?λ§? 
		//μ»¨ν?΄? ??± - ?€?λ§? μ»¨ν?΄? μ΄κΈ°? ?? 
		// => λ§€κ°λ³???? Spring Bean Configuration File? κ²½λ‘λ₯? ? κ³΅λ°? Resource κ°μ²΄λ‘? ??±??¬ ? ?¬
		// => BeanFactory κ°μ²΄? Spring Bean Configuration File? ?±λ‘λ ?΄??€λ‘? λ―Έλ¦¬ κ°μ²΄λ₯?
		//??±?μ§? ?κ³? Spring Bean ?μ²??  ??±??¬ ? κ³?
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("=============== Spring Container μ΄κΈ°? ? ===============");
		//BeanFactory.getBean(String beanName) : λ§€κ°λ³??λ‘? Spring Beanλ₯? κ΅¬λΆ?κΈ? ?? ?λ³μ
		//(beanName)? ? ?¬λ°μ ?€?λ§? μ»¨ν?΄?λ‘λ??° Spring Bean(κ°μ²΄)λ₯? ??±??¬ λ°ν?? λ©μ?
		// => Object ???? κ°μ²΄λ₯? λ°ν?λ―?λ‘? λ°λ? λͺμ?  κ°μ²΄ ?λ³?? ?¬?©
		// => λ§€κ°λ³??λ‘? ? ?¬λ°μ? ?λ³μ(beanName)? Spring Bean?΄ ?? κ²½μ° NoSuchBeanDefinitionException λ°μ
		CreateBean bean1=(CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("==========================================================");
		System.out.println("2.ApplicationContext κ°μ²΄λ₯? ??±??¬ ?€?λ§? μ»¨ν?΄?λ‘? ?¬?©?? λ°©λ²");
		System.out.println("=============== Spring Container μ΄κΈ°? ?  ===============");
		//ApplicationContext ?Έ?°??΄?€λ₯? ??λ°μ? ???΄??€λ‘? κ°μ²΄ ??± - ApplicationContext κ°μ²΄
		// => ApplicationContext κ°μ²΄λ₯? ??±?  ? Spring Bean Configuration File? ? κ³΅λ°? 
		//?€?λ§? μ»¨ν?΄? ??± - ?€?λ§? μ»¨ν?΄? μ΄κΈ°? ?? 
		// => ?΄??€κ°? μ°Έμ‘° κ°??₯? ?΄?(ClassPath)? ???₯? Spring Bean Configuration File? ? κ³΅λ°? ?¬?©
		// => ApplicationContext κ°μ²΄? Spring Bean Configuration File? ?±λ‘λ ?΄??€λ‘? λ―Έλ¦¬ 
		//κ°μ²΄λ₯? ??±??¬ Spring Bean ?μ²?? λ―Έλ¦¬ ??±? κ°μ²΄λ₯? ? κ³?		
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("=============== Spring Container μ΄κΈ°? ? ===============");
		//DL(Dependency Lookup) : ?€?λ§? μ»¨ν?΄?κ°? κ΄?λ¦¬ν? κ°μ²΄(Spring Bean)λ₯? κ²????¬ ? κ³΅ν? κΈ°λ₯ 
		//ApplicationContext.getBean(String beanName) : λ§€κ°λ³??λ‘? Spring Beanλ₯? κ΅¬λΆ?κΈ? ?? 
		//?λ³μ(beanName)? ? ?¬λ°μ ?€?λ§? μ»¨ν?΄?λ‘λ??° Spring Bean(κ°μ²΄)λ₯? λ°ν?? λ©μ?
		// => Object ???? κ°μ²΄λ₯? λ°ν?λ―?λ‘? λ°λ? λͺμ?  κ°μ²΄ ?λ³?? ?¬?©
		// => λ§€κ°λ³??λ‘? ? ?¬λ°μ? ?λ³μ(beanName)? Spring Bean?΄ ?? κ²½μ° NoSuchBeanDefinitionException λ°μ
		CreateBean bean2=(CreateBean)context.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext κ°μ²΄λ₯? ? κ±°ν? λ©μ?
		// => ?€?λ§? μ»¨ν?΄?κ°? ?λ©ΈλκΈ? ? ? ?€?λ§? μ»¨ν?΄?? ??΄ κ΄?λ¦¬λ? λͺ¨λ  κ°μ²΄(Spring Bean)λ₯? ?? ?λ©?
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	} 
}
