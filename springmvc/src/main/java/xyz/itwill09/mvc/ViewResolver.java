package xyz.itwill09.mvc;

//??΅ κ΄?? ¨ ? λ³΄λ?? ? κ³΅νκΈ? ?? ?΄??€
public class ViewResolver {
	//λ§€κ°λ³??λ‘? ViewName? ? ?¬λ°μ ??΅μ²λ¦¬?  JSP λ¬Έμ? κ²½λ‘λ₯? ??±??¬ λ°ν
	public String getView(String viewName) {
		return "/WEB-INF/mvc/"+viewName+".jsp";
	}
}
