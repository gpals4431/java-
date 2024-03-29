package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container μ΄κΈ°? ?  ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("=============== Spring Container μ΄κΈ°? ? ===============");
		//ApplicationContext.getBean(String beanName) : ?€?λ§? μ»¨ν?΄?λ‘λ??° λ§€κ°λ³??λ‘? ? ?¬λ°μ?
		//beanName? Spring Bean(κ°μ²΄)λ₯? κ²????¬ λ°ν?? λ©μ?
		// => Object ???? κ°μ²΄λ₯? λ°ν?λ―?λ‘? λ°λ? λͺμ?  κ°μ²΄ ?λ³?? ?¬?©
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");

		//ApplicationContext.getBean(String beanName, Class<T> clazz) : ?€?λ§? μ»¨ν?΄?λ‘λ??°
		//λ§€κ°λ³??λ‘? ? ?¬λ°μ? beanName? Spring Beanλ₯? Class κ°μ²΄λ‘? κ°μ²΄ ?λ³????¬ λ°ν?? λ©μ?
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean ?λ¦¬λ¨Ό?Έλ₯? ?΄?©?λ©? λ©μ?λ₯? κ°μ²΄λ₯? ??±? ? ???Όλ‘? ?ΈμΆλ?λ‘? ?€?  κ°??₯
		//bean.init();//μ΄κΈ°? λ©μ?
		
		bean.display();
		
		//bean ?λ¦¬λ¨Ό?Έλ₯? ?΄?©?λ©? λ©μ?λ₯? κ°μ²΄ ?λ©? ?  ???Όλ‘? ?ΈμΆλ?λ‘? ?€?  κ°??₯
		//bean.destroy();//λ§λ¬΄λ¦? λ©μ?
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










