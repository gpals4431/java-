package xyz.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ëª¨ë¸ ê¸°ëŠ¥?„ ? œê³µí•˜ê¸? ?œ„?•œ ?´?˜?Š¤ - ?š”ì²? ì²˜ë¦¬ ë©”ì†Œ?“œê°? ì¶”ìƒë©”ì†Œ?“œë¡? ?„ ?–¸?œ ?¸?„°?˜?´?Š¤ë¥? ?ƒ?†ë°›ì•„ ?‘?„±
// => ?´?¼?´?–¸?Š¸ê°? [/view.itwill]?˜ URL ì£¼ì†Œë¡? ?š”ì²??•œ ê²½ìš° ì»¨íŠ¸ë¡¤ëŸ¬?— ?˜?•´ ?‹¤?–‰?  ?š”ì²? ì²˜ë¦¬ ?´?˜?Š¤
public class ViewController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member=new Member("test", "?¼ì§?ë§?", "?„œ?š¸?‹œ ì¢…ë¡œêµ?");
		request.setAttribute("member", member);
		return "member_view";
	}

}
