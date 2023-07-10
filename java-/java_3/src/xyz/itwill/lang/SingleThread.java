/* 0417 3-1*/
package xyz.itwill.lang;

public class SingleThread {
	public void display() {
		/*
		System.out.println("SigleThread 클래스의 display() 메소드 시작");
		
		
		System.out.println(Thread.currentThread().getName()+"[main] 스레드에의해 main()메소드 명령실행");
		
		System.out.println("SigleThread 클래스의 display() 메소드 시작");
	*/
	
		for(char i='a'; i <'z'; i++) {
			System.out.println(i);
		}
	}
}
