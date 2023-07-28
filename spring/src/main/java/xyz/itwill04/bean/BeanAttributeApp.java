package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container 초기?�� ?�� ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("=============== Spring Container 초기?�� ?�� ===============");
		//ApplicationContext.getBean(String beanName) : ?��?���? 컨테?��?��로�??�� 매개�??���? ?��?��받�?
		//beanName?�� Spring Bean(객체)�? �??��?��?�� 반환?��?�� 메소?��
		// => Object ???��?�� 객체�? 반환?���?�? 반드?�� 명시?�� 객체 ?���??�� ?��?��
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");

		//ApplicationContext.getBean(String beanName, Class<T> clazz) : ?��?���? 컨테?��?��로�??��
		//매개�??���? ?��?��받�? beanName?�� Spring Bean�? Class 객체�? 객체 ?���??��?��?�� 반환?��?�� 메소?��
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean ?��리먼?���? ?��?��?���? 메소?���? 객체�? ?��?��?�� ?�� ?��?��?���? ?��출되?���? ?��?�� �??��
		//bean.init();//초기?�� 메소?��
		
		bean.display();
		
		//bean ?��리먼?���? ?��?��?���? 메소?���? 객체 ?���? ?�� ?��?��?���? ?��출되?���? ?��?�� �??��
		//bean.destroy();//마무�? 메소?��
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










