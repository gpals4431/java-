package xyz.itwill.jdbc;

/*
Class 객체(Clazz)를 수동으로 제공받는 방법
	1. Class.forName(String className) 메소드를 호출하여 반환받는 방법
	2. Object.getClass() 메소드를 호출하여 현재 사용중인 클래스에 대한 Class 객체 반환받는 방법
	3. [클래스명.class] 형식으로 표현하는 방법 > 외부 클래스 불러들여서 쓸 때 많이 사용
 */
public class StaticBlockApp {
	public static void main(String[] args) throws ClassNotFoundException {
	    /*
	    1.JVM은 ClassLoader 프로그램을 이용하여 클래스(Class 파일:컴파일에 저장된)를 읽어 메모리의 Method 영역에 저장 
		2.new 연산자로 메모리에 저장된 클래스(Class 객체 - Clazz)의 생성자를 호출하여 객체(object-instance)를 생성 - 메모리의 힙영역에 객체 생성 
		3.생성된 객체의 메모리 주소(HashCode)를 제공받아 참조변수를 생성하여 저장 - 참조변수는 메모리의 스택영역에 생성
		 */
		//StaticBlock sb=new StaticBlock();
		
		//참조변수에 저장된 메모리 주소로 객체를 참조하여 메소드 호출
		//sb.display();
		
		/*Class.forName(String className) : 문자열로 표현된 패키지가 포함된 클래스를 전달받아 ClassLoade 프로그램을 사용하여 
		 클래스를 읽어 메모리에 저장하는 메소드 >> Class 객체(Clazz) 반환
		 >> ClassNotFoundException 발생 : 해당 패키지에 클래스가 없는 경우 발생 - 일반예외 */
		Class.forName("xyz.itwill.jdbc.StaticBlock");
		// > 수동으로 클래스를 메모리에 저장, 스태틱 영역 실행은 한번만 이용 가능 > 불필요한 객체 생성이나 호출을 방지 하기위해서 정적 영역안에 객체 생성 후 호출
		
		//StaticBlock sb= new StaticBlock();
		//sb.display();
		
	}
}
