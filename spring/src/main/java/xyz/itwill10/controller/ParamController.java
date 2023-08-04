package xyz.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.CharacterEncodingFilter;

@Controller
public class ParamController {
	@RequestMapping(value="/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	/*@RequestMapping(value="/param", method = RequestMethod.POST)
	public String result(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String food=request.getParameter("food");
		request.setAttribute("food", food);
		return "param_display";
		
	}*/
	
	//요청처리메소드에서 현재 페이지를 요청할때 전달된 값의 이름과 같은 이름으로 원시형 또는 string 클래스의
	//매개변수를 선언하면 Front Controller는 전달값을 매개변수에 자동으로 저장
	//한글이 깨짐. 인코딩처리해주지않아서 매개변수를 이용해 전달값을 제공받아 사용하기 전에 리퀘스트 메세지 몸체부에 저장되어
	//전달되는 값에 대한 문자형태(캐릭터셋) 변경 처리 - 인코딩 필드 사용
	//필터 - 웹프로그램 실행 전과 후에실행될 명령을 제공하는 기능의 프로그램 
	//=> 필터인터페이스를 상속받은 자식클래스(=필터클래스)를 생성해web.xml파일에 등록해 사용
	//=> 필터는 front controller 실행전에 위치하여 요청과 필요한 기능을 제공-was 프로그램으로 제어
	
	/*
	 * @RequestMapping(value="/param", method=RequestMethod.POST)
	 *  public String result(String food, Model model) {
	 *  model.addAttribute("food", food);
	 *  return "param_display"; } }
	 */
	/*
	//required 속성 : false(선택 전달값) 또는 true(필드 전달값 - 기본값) 중 하나를 속성값으로 설정
	// => required 속성값을 [true]로 설정하면 매개변수의 이름과 전달값의 이름을 동일하게 작성
	//하여 매개변수에 전달값이 저장되도록 설정 
	// => required 속성값을 [true]로 설정한 경우 전달값의 이름과 매개변수의 이름이 같아도 전달값이
	//없으면 매개변수에 [null] 저장 - 400 에러코드 미발생 
	//value 속성 : 전달값의 이름을 속성값으로 설정
	// => @RequestParam 어노테이션의 value 속성값을 이용하여 전달값을 제공받아 매개변수에 저장
	// => 전달값의 이름과 매개변수의 이름을 다르게 작성할 경우 사용하는 속성
	// => 다른 속성이 없으면 속성값만 설정 가능
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String result(@RequestParam(required = true, value = "foodname") String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String result(@RequestParam(defaultValue = "된장찌개", value="foodname" ) String food, Model model) {
		//el은 null 출력안됨 어노테이션 없을 경우, 어노테이션을 사용하면 400에러페이지 무조건 매개변수값을 전달하고 싶을때 - 어노테이션 권장
		model.addAttribute("food", food); 
		return "param_display";
	}
	*/
}

