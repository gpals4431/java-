package xyz.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean ?´?˜?Š¤?˜ ê¸°ë³¸ ?ƒ?„±? ?˜¸ì¶? ###");
	}
	
	public void init() {
		System.out.println("*** InitDestroyMethodBean ?´?˜?Š¤?˜ init() ë©”ì†Œ?“œ ?˜¸ì¶? ***");
	}
	
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean ?´?˜?Š¤?˜ destroy() ë©”ì†Œ?“œ ?˜¸ì¶? ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean ?´?˜?Š¤?˜ display() ë©”ì†Œ?“œ ?˜¸ì¶? ***");
	}
}
