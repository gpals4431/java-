package xyz.itwill.springmv;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
//테스트 클래스에서는 생성자를 만들수없음
public class StudentControllerTest {
	//WebApplicationContext 객체를 제공받아 저장하기 위한 필드 선언 - 의존성 주입
	//=>WebApplicationContext 객체 : SpringMVC 프로그램에서 스프링 컨테이너 기능을 제공하기 위한 객체
	@Autowired
	private WebApplicationContext context;
	
	//MockMvc 객체를 저장하기 위한 필드 선언 - 의존성 주입 불가능 
	//=> MockMvc 객체 : 클라이언트 대신에 요청과 응답을 가상으로 제공하기 위한 객체
	private MockMvc mvc;//가장 중요!!!!
	
	//@Before: 테스트 메소드 호출전에 실행될 명령을 작성한 메소드에 설정하는 어노테이션 - 초기화 처리를 위해 사용
	@Before//junit에서 제공하는 라이브러리 사용해야함!
	public void setup() {
		//build() : 가짜 MockMvc 객체 생성하여 반환
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		log.info("MockMvc 객체 생성");
	}
	
	@Test
	public void testStudentDisplay() throws Exception{
		//매개변수로 요청 url 주소를 전달받아 GET 방식으로 웹프로그램을 요청하는 메소드
		//=> 요청 페이지에 대한 url 주소의 요청 관련 정보(리퀘스트 메세지)가 저장된 builder 객체 반환
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		log.info(result.getModelAndView().getViewName());
		log.info(result.getModelAndView().getModel().toString());
	}
	

}	























