package basic;

/*자료형(dataType): 값을 표현하기 위한 키워드 또는 특정 대상을 표현하기 위한 식별자 ->값이나 특정 대상을 저장하기 위한 변수를 선언하기 위해 사용
1. 원시형(PrimiriveType):값을 표현하기 위한 자료형-키워드로 만들어짐
-> 숫자형(정수형, 실수형, 문자형)-연산 가능 , 논리형
2. 참조형(ReferenceType): 특정 대상을 표현하기 위한 자료형-식별자(클래스)로 만들어짐
-> String class:문자열을 표현하기 위한 자료형(클래스)*/


public class DataTypeApp {
	public static void main(String[] args) {	
		//정수형(IntegerType) 리터럴 : 소숫점이 없는 숫자값
		// => Java에서 정수형 리터럴은 기본적으로 4Byte(Integer)로 표현 >> -2147483648~2147483647
		System.out.println("<<정수형(IntegerType)>>");
		System.out.println("정수형(10진수 100) = "+100);//숫자값 - 10진수 정수형 리터럴 출력
		//println() 메소드는 정수값을 무조건 10진수로 변환하여 출력
		System.out.println("정수값(8진수 100) = "+0100);//0숫자값 - 8진수 정수형 리터럴
		System.out.println("정수형(16진수 100) = "+0x100);//0x숫자값 - 16진수 정수형 리터럴 출력
		System.out.println("정수형(10진수 100) = "+100L);//숫자값L or l - 10진수 정수형 리터럴(8byte-LongType) 출력
		
		System.out.println("정수값= "+2147483647);//4Byte(Integer)로 표현 >> -2147483648~2147483647
		//4byte로 표현 불가능한 정수값은 정수값 뒤에[L]을 붙여 8byte의 LongType의 정수값으로 표현
		System.out.println("정수값= "+2147483649L);//Byte로 표현 불가능한 정수값을 사용한 경우 에러 발생
		
		//정수값을 표현하기 위한 자료형(키워드) - byte(1Byte), short(2Byte), int(4Byte), long(8Byte)
		byte a1=12;//1Byte: -128~127
		short a2=32767;//2Byte: -32768~32767
		int a3=2147483647;//4Byte: -2147483678~2147483647
		long a4=2147483648L;//8Byte
		
		System.out.println("a1="+a1);
		System.out.println("a2="+a2);
		System.out.println("a3="+a3);
		System.out.println("a4="+a4);
		
		//int a5=100L;//값에 대한 손실이 발생할 수 있으므로 에러 발생
		long a5=100;//자료형이 큰 변수에 작은 리터럴 저장 가능, 에러는 없지만 가독성이 떨어짐.
		System.out.println("a5="+a5);
		System.out.println("=====================================================================");
		//실수형(DoubleType) 리터럴 : 소숫점이 있는 숫자값
		// => Java에서 정수형 리터럴은 기본적으로 8Byte(Double)로 표현 >> 부동 소수점 형식으로 숫자값 표현
		System.out.println("<<실수형(DoubleType)>>");
		System.out.println("실수값(4byte)="+12.3F);//실수값F>>4Byte 실수형 리터럴(FloatType)
		double c1=2.3;
		float c2=3.14F; //실수는 무조건 8byte로 표시 어떤 값이든 double로 표현하거나 뒤에 F를 넣음
		System.out.println(c1);
		System.out.println("실수값(8byte)="+12.3);//실수값>>8Byte 실수형 리터럴(DoubleType)
		//println()메소드는 실수값이 아주 작거나 큰 경우 지수 형태로 변환하여 출력
		System.out.println("실수값(8byte)="+0.000000000123);
		//실수값을 지수형태로 표현하여 사용 가능
		System.out.println("실수값(8byte)="+1.23E+10);
		
		//실수값을 표현하기 위한 자료형 - float(4Byte), double(8Byte)
		float b1=1.23456789F;//가수부(소숫점밑 자리수)를 표현하기 위한 크기(정밀도): 7자리 
		double b2=1.23456789;//가수부를 표현하기 위한 크기(정밀도): 15자리
		
		System.out.println("b1 ="+b1);
		System.out.println("b2 ="+b2);
		System.out.println("=====================================================================");
		
	}
}