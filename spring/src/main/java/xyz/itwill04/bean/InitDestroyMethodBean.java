package xyz.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean ?΄??€? κΈ°λ³Έ ??±? ?ΈμΆ? ###");
	}
	
	public void init() {
		System.out.println("*** InitDestroyMethodBean ?΄??€? init() λ©μ? ?ΈμΆ? ***");
	}
	
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean ?΄??€? destroy() λ©μ? ?ΈμΆ? ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean ?΄??€? display() λ©μ? ?ΈμΆ? ***");
	}
}
