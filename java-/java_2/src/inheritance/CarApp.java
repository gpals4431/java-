package inheritance;

public class CarApp {
	public static void main(String[] args) {
		Car car = new Car("산타페","홍길동");
		
		System.out.println("모델명 = "+car.getModelName());
		System.out.println("소유자명 = "+car.getUserName());
		System.out.println("==============================================");
		/*
		//object 클래스에 있는 toString()라는 메소드 호출 
		// toString - 참조변수에 저장된 객체를 참조하여 "클래스명@메모리주소"형식의 문자열로 변환하여 반환하는 메소드
		System.out.println("car.toString() = "+car.toString());
		//참조변수를 출력할 경우 자동으로 toString메소드 호출
		System.out.println("car = "+car);
		*/

		//Object 클래스의 toString()메소가 아닌 Car 클래스의 toString()메소드 자동 호출
		System.out.println("car = "+car);
		System.out.println("==============================================");
		
		//문자열이 저장된 String객체를 생성하여 메모리주소를 참조변수에 저장
		String name = "홍길동";//>>홍길동의 문자열로 String객체를 만든것 그 객체의 메모리주소를 name참조변수에 저장
		
		//String 클래스에 오버라이드 선언된  toString()메소드 호출
		// => String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		//System.out.println("name = "+name.toString());
		//String 클래스의 참조변수를 출력할 경우 자동으로 String클래스의 toString() 메소드 호출
		System.out.println("name = "+name);
		
		
	}
}
