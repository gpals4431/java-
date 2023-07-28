package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container ì´ˆê¸°?™” ? „ ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("=============== Spring Container ì´ˆê¸°?™” ?›„ ===============");
		//ApplicationContext.getBean(String beanName) : ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆë¡œë??„° ë§¤ê°œë³??ˆ˜ë¡? ? „?‹¬ë°›ì?
		//beanName?˜ Spring Bean(ê°ì²´)ë¥? ê²??ƒ‰?•˜?—¬ ë°˜í™˜?•˜?Š” ë©”ì†Œ?“œ
		// => Object ???…?˜ ê°ì²´ë¥? ë°˜í™˜?•˜ë¯?ë¡? ë°˜ë“œ?‹œ ëª…ì‹œ?  ê°ì²´ ?˜•ë³??™˜ ?‚¬?š©
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");

		//ApplicationContext.getBean(String beanName, Class<T> clazz) : ?Š¤?”„ë§? ì»¨í…Œ?´?„ˆë¡œë??„°
		//ë§¤ê°œë³??ˆ˜ë¡? ? „?‹¬ë°›ì? beanName?˜ Spring Beanë¥? Class ê°ì²´ë¡? ê°ì²´ ?˜•ë³??™˜?•˜?—¬ ë°˜í™˜?•˜?Š” ë©”ì†Œ?“œ
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean ?—˜ë¦¬ë¨¼?Š¸ë¥? ?´?š©?•˜ë©? ë©”ì†Œ?“œë¥? ê°ì²´ë¥? ?ƒ?„±?•œ ?›„ ??™?œ¼ë¡? ?˜¸ì¶œë˜?„ë¡? ?„¤? • ê°??Š¥
		//bean.init();//ì´ˆê¸°?™” ë©”ì†Œ?“œ
		
		bean.display();
		
		//bean ?—˜ë¦¬ë¨¼?Š¸ë¥? ?´?š©?•˜ë©? ë©”ì†Œ?“œë¥? ê°ì²´ ?†Œë©? ? „ ??™?œ¼ë¡? ?˜¸ì¶œë˜?„ë¡? ?„¤? • ê°??Š¥
		//bean.destroy();//ë§ˆë¬´ë¦? ë©”ì†Œ?“œ
		System.out.println("==========================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
		System.out.println("==========================================================");
		ScopeBean bean1=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean2=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean3=context.getBean("singletonBean", ScopeBean.class);
		
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);
		System.out.println("==========================================================");
		ScopeBean bean4=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean5=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean6=context.getBean("prototypeBean", ScopeBean.class);
		
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	}
}










