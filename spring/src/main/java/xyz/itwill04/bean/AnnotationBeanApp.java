package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container ì´ˆê¸°?™” ? „ ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-3_beanAnnotation.xml");
		System.out.println("=============== Spring Container ì´ˆê¸°?™” ?›„ ===============");
		AnnotationBean bean=context.getBean("annotationBean", AnnotationBean.class);
		bean.display();
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
