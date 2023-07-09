package basic;

/*자료형(dataType): 값을 표현하기 위한 키워드 또는 특정 대상을 표현하기 위한 식별자 ->값이나 특정 대상을 저장하기 위한 변수를 선언하기 위해 사용
1. 원시형(PrimiriveType):값을 표현하기 위한 자료형-키워드로 만들어짐(8가지)
-> 숫자형(정수형, 실수형, 문자형)-연산 가능 , 논리형
2. 참조형(ReferenceType): 특정 대상을 표현하기 위한 자료형-식별자(클래스)로 만들어짐
-> String class:문자열(문자그룹)을 표현하기 위한 자료형(클래스)*/

//Bit : 0 또는 1을 저장할 수 있는 *저장의 최소 단위
//Byte: 영문자 하나를 저장할 수 있는 *표현의 최소 단위 -8Bit
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
		double A1=2.3;
		float A2=3.14F; //실수는 무조건 8byte로 표시 어떤 값이든 double로 표현하거나 뒤에 F를 넣음
		System.out.println(A1);
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
		//문자형(CharacterType) 리터럴: ' '안에 하나의 문자를 표현
		// => Java에서 문자형 리터럴은 기본적으로 2Byte로 표현
		// => 문자형 리터럴은 일반문자외에 회피문자(제어문자)가 존재
		//회피문자(Escape Character) :프로그램에서 표현 불가능한 문자를 표현하기 위한 문자 - \ 기호 이용
		// => '\n': Enter , '\t' : Tab , '\'' : '문자, '\"' : "문자, '\\' : \문자, '\0': null문자 
		//문자형 리터럴은 내부적으로 약속된 정수값(0~65535)으로  표현 - 유니코드(Unicode)
		// => 'A': '65', 'a' : '97' , '0' : 48, '' : 32, '\n' : 13, '가' : 44032 -완성형
		System.out.println("<<문자형(CharacterType)>>");
		System.out.println("문자형(2byte)"+'A');
		System.out.println("문자형(2byte)"+'가');
		System.out.println("문자형(2byte)"+'\'');
		System.out.println("문자형(2byte)"+'\\');
		
		//문자값을 표현하기 위한 자료형 - char(2Byte)
		char c1='A';//문자형 변수에는 문자값에 대한 약속된 정수값이 저장
		char c2=65;//문자형 변수에는 문자값 대신 약속된 정수값 저장이 가능
		char c3='a'-32;
		
		System.out.println("c1="+c1);
		System.out.println("c1="+c2);
		System.out.println("c1="+c3);
		
		char c4=45001;
		System.out.println("c1="+c4);
		System.out.println("=====================================================================");
		
		//논리형 리터럴(BooleanType) : false 또는 true 
		// => Java에서 논리형 리터럴은 기본적으로 1Byte로 표현
		System.out.println("<<논리형(BooleanType)>>");
		System.out.println("논리값(1byte)"+false);
		System.out.println("논리값(1byte)"+true);
		//관계 연산자(비교 연산자)를 이용한 연산식의 결과값으로 논리형 리터럴을 사용한다
		System.out.println("논리값(1byte)"+(20>10));
		System.out.println("논리값(1byte)"+(20<10));
		
		//논리값을 표현하기 위한 자료형 - boolean(1byte)
		boolean d1=false;
		boolean d2=20>10;
		
		System.out.println("d1 ="+d1);
		System.out.println("d2 ="+d2);
		System.out.println("=====================================================================");
		
		//문자열(StringType) 리터럴: " " 안에 0개 이상의 문자들로 표현 -String 객체
		// => 문자열은 원시형(기본형)이 아닌 참조형으로 String class로 표현
		System.out.println("<<문자열(SpringType)>>");
		System.out.println("문자열 ="+"홍길동");
		System.out.println("문자열 ="+"유관순 열사가 \"대한독립 만세\"를 외쳤습니다.");
		
		//문자열을 표현하기 위한 자료형 : String class
		String name="임꺽정";//사실상 문자열리터럴이 아니라 String 객체라고 표현한다.
		System.out.println("이름="+name);
		System.out.println("=====================================================================");
	}
}