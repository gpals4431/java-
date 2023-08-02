package xyz.itwill08.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xyz.itwill07.aop.AopAnnotationBean;


/*Data Source 객체 : 다수의 컨넥션 객체를 미리 생성하여 저장하고 있는 객체 - DBCP
=>Spring Bean Configuration File 에서 데이터소스 인터페이스를 상속받은 자식클래스를 SpringBean으로 등록하여 사용

1.데이터소스 인터페이스를 상속받은 자식클래스는 스프링프레임워크에서 제공하는 spring jdbc라이브러리 이용 -메이븐 사용:pom.xml
2.데이터소스 관련 라이브러리 외에 오라클 Driver 관련 라이브러리도 프로젝트 빌드 처리

스프링 컨테이너에게 Data Source 객체를 제공받아 Connection 객체를 반환받아 사용
*/
public class DataSourceApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-5_aopAnnotation.xml");
		AopAnnotationBean bean=context.getBean("aopAnnotationBean", AopAnnotationBean.class);
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
