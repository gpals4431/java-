package xyz.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean ?��?��?��?�� 기본 ?��?��?�� ?���? ###");
	}
	
	public void init() {
		System.out.println("*** InitDestroyMethodBean ?��?��?��?�� init() 메소?�� ?���? ***");
	}
	
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean ?��?��?��?�� destroy() 메소?�� ?���? ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean ?��?��?��?�� display() 메소?�� ?���? ***");
	}
}
