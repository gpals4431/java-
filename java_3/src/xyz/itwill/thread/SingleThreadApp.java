/* 0417 3*/
package xyz.itwill.thread;

import xyz.itwill.lang.SingleThread;

public class SingleThreadApp {
	public static void main(String[] args) {
		
		/*
		System.out.println("SigleThreadApp 클래스의 main() 메소드 시작");

		
		System.out.println(Thread.currentThread().getName()+"[main] 스레드에의해 main()메소드 명령실행");
		
		//객체를 생성하여 메소드를 호출한 경우 스레드가 메소드로 이동하여 메소드의 명령 실행
		// => 메소드의 명령을 모두 실행한 후 다시 현재 위치로 되돌아와 나머지 명령 실행
		new SingleThread().display();//객체를 생성해서 메소드를 한번만 쓰고 싶을때 메소드를 직접 호출
		
		System.out.println("SigleThreadApp 클래스의 main() 메소드 종료");
		
		*/
		
		
		for(char i='A'; i <'Z'; i++) {
			System.out.println(i);
		}
		new SingleThread().display();
		
	}
}
