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
	
	//��ûó���޼ҵ忡�� ���� �������� ��û�Ҷ� ���޵� ���� �̸��� ���� �̸����� ������ �Ǵ� string Ŭ������
	//�Ű������� �����ϸ� Front Controller�� ���ް��� �Ű������� �ڵ����� ����
	//�ѱ��� ����. ���ڵ�ó���������ʾƼ� �Ű������� �̿��� ���ް��� �����޾� ����ϱ� ���� ������Ʈ �޼��� ��ü�ο� ����Ǿ�
	//���޵Ǵ� ���� ���� ��������(ĳ���ͼ�) ���� ó�� - ���ڵ� �ʵ� ���
	//���� - �����α׷� ���� ���� �Ŀ������ ����� �����ϴ� ����� ���α׷� 
	//=> �����������̽��� ��ӹ��� �ڽ�Ŭ����(=����Ŭ����)�� ������web.xml���Ͽ� ����� ���
	//=> ���ʹ� front controller �������� ��ġ�Ͽ� ��û�� �ʿ��� ����� ����-was ���α׷����� ����
	
	/*
	 * @RequestMapping(value="/param", method=RequestMethod.POST)
	 *  public String result(String food, Model model) {
	 *  model.addAttribute("food", food);
	 *  return "param_display"; } }
	 */
	
	/*
	 * @RequestMapping(value="/param", method=RequestMethod.POST) public String
	 * result(@RequestParam(required = true, value="foodname" ) String food, Model
	 * model) { //el�� null ��¾ȵ� ������̼� ���� ���, ������̼��� ����ϸ� 400���������� ������ �Ű��������� �����ϰ�
	 * ������ - ������̼� ���� model.addAttribute("food", food); return "param_display"; }
	 */
	
	/*
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String result(@RequestParam(defaultValue = "�����", value="foodname" ) String food, Model model) {
		//el�� null ��¾ȵ� ������̼� ���� ���, ������̼��� ����ϸ� 400���������� ������ �Ű��������� �����ϰ� ������ - ������̼� ����
		model.addAttribute("food", food); 
		return "param_display";
	}
	*/
}

