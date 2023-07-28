package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
 
//Spring ?”„? ˆ?„?›Œ?¬?—?„œ?Š” BeanFactory ê°ì²´ ?˜?Š” ApplicationContext ê°ì²´ë¡? ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆ
//(Spring Container) ê¸°ëŠ¥ ? œê³?
// => ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆ?Š” ?™˜ê²½ì„¤? •?ŒŒ?¼(Spring Bean Configuration File - XML)ë¡? ?´?˜?Š¤ë¥? ? œê³µë°›?•„ 
//Spring Bean(ê°ì²´) ê´?ë¦?
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1.BeanFactory ê°ì²´ë¥? ?ƒ?„±?•˜?—¬ ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆë¡? ?‚¬?š©?•˜?Š” ë°©ë²•");
		System.out.println("=============== Spring Container ì´ˆê¸°?™” ? „ ===============");
		//BeanFactory ?¸?„°?˜?´?Š¤ë¥? ?ƒ?†ë°›ì? ??‹?´?˜?Š¤ë¡? ê°ì²´ ?ƒ?„± - BeanFactory ê°ì²´ 
		// => BeanFactory ê°ì²´ë¥? ?ƒ?„±?•  ?•Œ Spring Bean Configuration File?„ ? œê³µë°›?•„ ?Š¤?”„ë§? 
		//ì»¨í…Œ?´?„ˆ ?ƒ?„± - ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆ ì´ˆê¸°?™” ?‘?—… 
		// => ë§¤ê°œë³??ˆ˜?—?Š” Spring Bean Configuration File?˜ ê²½ë¡œë¥? ? œê³µë°›?•„ Resource ê°ì²´ë¡? ?ƒ?„±?•˜?—¬ ? „?‹¬
		// => BeanFactory ê°ì²´?Š” Spring Bean Configuration File?— ?“±ë¡ëœ ?´?˜?Š¤ë¡? ë¯¸ë¦¬ ê°ì²´ë¥?
		//?ƒ?„±?•˜ì§? ?•Šê³? Spring Bean ?š”ì²??‹œ  ?ƒ?„±?•˜?—¬ ? œê³?
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("=============== Spring Container ì´ˆê¸°?™” ?›„ ===============");
		//BeanFactory.getBean(String beanName) : ë§¤ê°œë³??ˆ˜ë¡? Spring Beanë¥? êµ¬ë¶„?•˜ê¸? ?œ„?•œ ?‹ë³„ì
		//(beanName)?„ ? „?‹¬ë°›ì•„ ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆë¡œë??„° Spring Bean(ê°ì²´)ë¥? ?ƒ?„±?•˜?—¬ ë°˜í™˜?•˜?Š” ë©”ì†Œ?“œ
		// => Object ???…?˜ ê°ì²´ë¥? ë°˜í™˜?•˜ë¯?ë¡? ë°˜ë“œ?‹œ ëª…ì‹œ?  ê°ì²´ ?˜•ë³??™˜ ?‚¬?š©
		// => ë§¤ê°œë³??ˆ˜ë¡? ? „?‹¬ë°›ì? ?‹ë³„ì(beanName)?˜ Spring Bean?´ ?—†?Š” ê²½ìš° NoSuchBeanDefinitionException ë°œìƒ
		CreateBean bean1=(CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("==========================================================");
		System.out.println("2.ApplicationContext ê°ì²´ë¥? ?ƒ?„±?•˜?—¬ ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆë¡? ?‚¬?š©?•˜?Š” ë°©ë²•");
		System.out.println("=============== Spring Container ì´ˆê¸°?™” ? „ ===============");
		//ApplicationContext ?¸?„°?˜?´?Š¤ë¥? ?ƒ?†ë°›ì? ??‹?´?˜?Š¤ë¡? ê°ì²´ ?ƒ?„± - ApplicationContext ê°ì²´
		// => ApplicationContext ê°ì²´ë¥? ?ƒ?„±?•  ?•Œ Spring Bean Configuration File?„ ? œê³µë°›?•„ 
		//?Š¤?”„ë§? ì»¨í…Œ?´?„ˆ ?ƒ?„± - ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆ ì´ˆê¸°?™” ?‘?—… 
		// => ?´?˜?Š¤ê°? ì°¸ì¡° ê°??Š¥?•œ ?´?”(ClassPath)?— ???¥?œ Spring Bean Configuration File?„ ? œê³µë°›?•„ ?‚¬?š©
		// => ApplicationContext ê°ì²´?Š” Spring Bean Configuration File?— ?“±ë¡ëœ ?´?˜?Š¤ë¡? ë¯¸ë¦¬ 
		//ê°ì²´ë¥? ?ƒ?„±?•˜?—¬ Spring Bean ?š”ì²??‹œ ë¯¸ë¦¬ ?ƒ?„±?œ ê°ì²´ë¥? ? œê³?		
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("=============== Spring Container ì´ˆê¸°?™” ?›„ ===============");
		//DL(Dependency Lookup) : ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆê°? ê´?ë¦¬í•˜?Š” ê°ì²´(Spring Bean)ë¥? ê²??ƒ‰?•˜?—¬ ? œê³µí•˜?Š” ê¸°ëŠ¥ 
		//ApplicationContext.getBean(String beanName) : ë§¤ê°œë³??ˆ˜ë¡? Spring Beanë¥? êµ¬ë¶„?•˜ê¸? ?œ„?•œ 
		//?‹ë³„ì(beanName)?„ ? „?‹¬ë°›ì•„ ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆë¡œë??„° Spring Bean(ê°ì²´)ë¥? ë°˜í™˜?•˜?Š” ë©”ì†Œ?“œ
		// => Object ???…?˜ ê°ì²´ë¥? ë°˜í™˜?•˜ë¯?ë¡? ë°˜ë“œ?‹œ ëª…ì‹œ?  ê°ì²´ ?˜•ë³??™˜ ?‚¬?š©
		// => ë§¤ê°œë³??ˆ˜ë¡? ? „?‹¬ë°›ì? ?‹ë³„ì(beanName)?˜ Spring Bean?´ ?—†?Š” ê²½ìš° NoSuchBeanDefinitionException ë°œìƒ
		CreateBean bean2=(CreateBean)context.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext ê°ì²´ë¥? ? œê±°í•˜?Š” ë©”ì†Œ?“œ
		// => ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆê°? ?†Œë©¸ë˜ê¸? ? „?— ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆ?— ?˜?•´ ê´?ë¦¬ë˜?Š” ëª¨ë“  ê°ì²´(Spring Bean)ë¥? ??™ ?†Œë©?
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	} 
}
