package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	@RequestMapping("/forward_move")
	public String forward(Model model) {
		//Model ��ü�� ����Ͽ� ��(View)���� ������ ��ü�� �Ӽ������� ���� - Request Scope
		model.addAttribute("name", "ȫ�浿");
		
		//�並 �����ϱ� ���� ���̸�(ViewName) ��ȯ
		// => Front Controller(DispatchServlet Ŭ����)�� �������� ���̸��� InternalResourceViewResolver 
		//��ü�� ����Ͽ� JSP ������ ��ȯ�ϰ� JSP ������ ������ �̵��Ͽ� ���� ó��
		//������ �̵� : ���� ���ο��� ���� �����α׷��� �����带 �ٸ� �����α׷����� �̵��Ͽ� ���� ó��
		// => Ŭ���̾�Ʈ�� ��û URL �ּҴ� ������� ������ Request Scope �Ӽ����� ��ü�� �����޾� ��� ����
		return "display_forward";
	}
}







