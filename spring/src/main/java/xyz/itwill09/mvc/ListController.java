package xyz.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//model ����� �����ϱ� ���� Ŭ����
public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("abc", "ȫ�浿", "����� ������"));
		memberList.add(new Member("qwe", "�Ӳ���", "����� ������"));
		memberList.add(new Member("zxc", "����ġ", "����� ���Ǳ�"));

		// ��û������ ó�� ����� jsp ������ �����ϱ� ���� request �Ӽ������� ����
		request.setAttribute("memberList", memberList);
		
		//ó������� �����޾� Ŭ���̾�Ʈ���� ����ó���� jsp������ �̸�(viewName)�� ��ȯ
		return "member_list";
	}
}
