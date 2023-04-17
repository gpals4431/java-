/* 0417 4*/
package xyz.itwill.thread;

public class MultiThreadApp {
	//JVM에 의 main 스레드가 생성되어 main() 메소드를 호출하여 명령 실행
	//=>main 메소드에 의해 전달된 예외는 JVM이 자동으로 예외처
	public static void main(String[] args) throws InterruptedException {
		
		//스레드 객체를 사용하여 스타트 메소드외에 다른 메소드를 호출하지 않을 경우 참조변수에 객체를 저장하지 않고
		//객체를 생성하여 직접 메소드를 호출
		new MultiThreadOne().start();//스레드 객체로 새로운 스레드를 생성하기 위한 메소드
		
		
		MultiThreadTwo two =new MultiThreadTwo();
		new Thread(new Thread(two)).start(); // >> run메소드를 오버라이드한것과 똑같은 효과
		
		
		
		for(char i='A'; i <'Z'; i++) {
			System.out.print(i);
			
			Thread.sleep(500);
		}
	}
}
