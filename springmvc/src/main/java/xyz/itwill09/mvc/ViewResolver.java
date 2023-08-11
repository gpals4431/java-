package xyz.itwill09.mvc;

//?‘?‹µ ê´?? ¨ ? •ë³´ë?? ? œê³µí•˜ê¸? ?œ„?•œ ?´?˜?Š¤
public class ViewResolver {
	//ë§¤ê°œë³??ˆ˜ë¡? ViewName?„ ? „?‹¬ë°›ì•„ ?‘?‹µì²˜ë¦¬?•  JSP ë¬¸ì„œ?˜ ê²½ë¡œë¥? ?ƒ?„±?•˜?—¬ ë°˜í™˜
	public String getView(String viewName) {
		return "/WEB-INF/mvc/"+viewName+".jsp";
	}
}
