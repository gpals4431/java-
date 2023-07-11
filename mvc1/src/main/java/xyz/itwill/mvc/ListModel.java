package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.itwill.dto.UserinfoDTO;

public class ListModel implements Action {
@Override
public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	ActionForward actionForward = new ActionForward();
	
	try {
		HttpSession session = request.getSession();
		UserinfoDTO loginUserinfo= (UserinfoDTO) session.getAttribute("loginUserinfo");
		
		
		
	}catch (Exception e) {
	}
	return null;
}
}
