package xyz.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//model 기능을 제공하기 위한 클래스
public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("abc", "홍길동", "서울시 강남구"));
		memberList.add(new Member("qwe", "임꺽정", "서울시 도봉구"));
		memberList.add(new Member("zxc", "전우치", "서울시 관악구"));

		// 요청에대한 처리 결과를 jsp 문서에 제공하기 위해 request 속성값으로 저장
		request.setAttribute("memberList", memberList);
		
		//처리결과를 제공받아 클라이언트에게 응답처리할 jsp문서의 이름(viewName)을 반환
		return "member_list";
	}
}
