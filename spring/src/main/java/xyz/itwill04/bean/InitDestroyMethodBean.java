package xyz.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean �⺻ ������ ȣ�� ###");
		
	}
	public void init() {
		System.out.println("*** InitDestroyMethodBeanŬ������ Init() �޼ҵ� ȣ�� ***");
		
	}
	public void destroy() {
		System.out.println("*** InitDestroyMethodBeanŬ������ destroy() �޼ҵ� ȣ�� ***");
		
	}
	public void display() {
		System.out.println("*** InitDestroyMethodBeanŬ������ display() �޼ҵ� ȣ�� ***");
		
	}
	
}
