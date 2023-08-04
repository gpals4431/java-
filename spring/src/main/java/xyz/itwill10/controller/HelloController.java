package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

//@Controller : ��û ó�� Ŭ������ ������������ ����ϱ� ���� ������̼�
//=> Ŭ������ �̸��� spring bean�� �ĺ��ڷ� �ڵ� ����- ù���ڴ� �ҹ��ڷ� ��ȯ
//=> value �Ӽ��� ����Ͽ� spring bean�� �ĺ��� ���� ����

@Slf4j
@Controller 
public class HelloController {
	//�˾Ƽ� �������̽� ��� controller �������̽� ��Ӿȹ޾Ƶ��� -> ��ûó���޼ҵ� ����� @requestmapping ������̼� ���
	//�ϳ��� Ŭ������ �ϳ��� ��û�� ó�������� ��� ��ûŬ���� �ϳ��� ���� ������ ������ ������
	@RequestMapping(value="/hello")
	public void hello() {//��û ó�� �޼ҵ� - views �ؿ� hello,.jsp�� �վ����
		log.info("[/hello] ������ ��û");
	}
	
	@RequestMapping("helloViewName")
	public String helloViewName() {
		log.info("/helloviewName ������ ��û");
		return "hello";
	}
	
	@RequestMapping("/helloMav")
	public ModelAndView helloModelAndView() {
		log.info("/ helloMav ������ ��û");
		
		/*
		 * ModelAndView modelAndView = new ModelAndView();
		 * modelAndView.setViewName("hello");//setter �޼ҵ� ���̸� ����
		 */		
		ModelAndView modelAndView = new ModelAndView("hello");
		
		return modelAndView;
	}
}
