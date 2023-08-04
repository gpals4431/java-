package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

//@Controller : 요청 처리 클래스를 스프링빈으로 등록하기 위한 어노테이션
//=> 클래스의 이름을 spring bean의 식별자로 자동 설정- 첫문자는 소문자로 변환
//=> value 속성을 사용하여 spring bean의 식별자 변경 가능

@Slf4j
@Controller 
public class HelloController {
	//알아서 인터페이스 상속 controller 인터페이스 상속안받아도됨 -> 요청처리메소드 만들기 @requestmapping 어노테이션 사용
	//하나의 클래스로 하나의 요청을 처리했지만 얘는 요청클래스 하나만 만들어도 여러개 선언이 가능함
	@RequestMapping(value="/hello")
	public void hello() {//요청 처리 메소드 - views 밑에 hello,.jsp가 잇어야함
		log.info("[/hello] 페이지 요청");
	}
	
	@RequestMapping("helloViewName")
	public String helloViewName() {
		log.info("/helloviewName 페이지 요청");
		return "hello";
	}
	
	@RequestMapping("/helloMav")
	public ModelAndView helloModelAndView() {
		log.info("/ helloMav 페이지 요청");
		
		/*
		 * ModelAndView modelAndView = new ModelAndView();
		 * modelAndView.setViewName("hello");//setter 메소드 뷰이름 변경
		 */		
		ModelAndView modelAndView = new ModelAndView("hello");
		
		return modelAndView;
	}
}
