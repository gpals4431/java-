/*04 20 2-1*/
package xyz.itwill.util;

//제네릭 타입의 필드가 선언된 클래스로 객체를 생성하여 사용하는 프로그램
//=> 제네릭 타입 대신 설정된 Java 자료형의 객체만 필드에 저장 가능 - 제한적인 객체 저장
//=> 필드값을 반환받아 명시적 객체 형변환 없이 사용 가능
public class GenericApp {
	public static void main(String[] args) {
		//제네릭 클래스를 사용할 경우 제네릭 타입 대신 사용된 Java 자료형을 전달하여 사용
		// >> 전달받은 자바 자료형을제네릭 타입 대신 사용하여 필드 또는 메소드 완성
		Generic<Integer> generic1 = new Generic<Integer>();//제네릭에 클래스 전달필요!
		//Generic<Integer> generic1 = new Generic<>();//생성자의 제네릭 타입의 자료형 생략 가능
		
		//제네릭 타입 대신 사용될 Java 자료형과 동일한 자료형의 객체를 전달받아 필드값 변경
		// >> 제네릭 타입 대신 사용될 자바 자료형과 다른 자료형의 객체를 전달한 경우 에러 발생
		generic1.setField(100);// 오토박싱이 발생 > 정수값이 integer 객체가 됨 >> 참조형 필드에 저장
		//generic1.setField(12.34);// 필드의 자료형이 integer기 때문에 double 에러 발생
		
		Integer returnObject1 = generic1.getField();
		
		System.out.println("필드값 = "+returnObject1);//오토언박싱 : integer 객체 > 정수값
		System.out.println("==================================================");
		Generic<Double> generic2 = new Generic<Double>();//필드의 자료형 Double
		
		generic2.setField(12.34);
		
		Double returnObject2 = generic2.getField();
		
		System.out.println("필드값 = "+returnObject2);//오토언박싱 : Double 객체 > 실수값
		System.out.println("==================================================");
		/* 
		제네릭 타입이 상속받지 못한 클래스로 사용할 경우 에러 발생  
		Generic<String> generic3 = new Generic<String>();//필드의 자료형 String
		
		generic3.setField("홍길동");
		
		String returnObject3 = generic3.getField();
		
		System.out.println("필드값 = "+returnObject3);//오토언박싱 : String 객체 > 문자열
		System.out.println("==================================================");
		*/
		
	}
}
