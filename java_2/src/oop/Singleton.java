package oop;

//싱글톤 디자인 패턴을 적용하여 작성된 클래스 - 싱글톤 클래스
public class Singleton {
	private static Singleton _instance;
	
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	
	//정적영역	
	static {
		_instance = new Singleton();
	}
	//시스템 필드에 저장된 객체를 반환하는 메소드
	public static Singleton getInstance() {
		return _instance;
		
	}
	//인스턴스 메소드
	public void display() {
		System.out.println("싱글톤 클래스의 display() 메소드 호출");
		
	}

}
