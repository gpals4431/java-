/*[0414] 2.*/
package xyz.itwill.exception;

public class ExceptionThrowApp {
	//예외가 발생된 명령의 메소드에서 예외처리를 하지않고 발생된 예외를 메소드를 호출한 명령으로 전달 가능
	public static void display() throws ArrayIndexOutOfBoundsException {
		int[] array = {10,20,30,40,50};
		
		for(int i=0;i<=array.length;i++) {
			System.out.println("array["+i+"] = "+array[i]);
		}

	}
	
	public static void main(String[] args) {
		try {
		display();//같은 클래스의 정적메소드는 클래스표현 없이 메소드호출
		//ExceptionThrowApp.display();//클래스가 같아서 생략해도됨, 정적메소드는 클래스를 이용하여 호출 가능
		
	} catch ( ArrayIndexOutOfBoundsException e) {
		System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
	}
}
}