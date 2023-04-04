package basic;

//Java 자료형 : 원시형(PrimitiveType)과 참조형(ReferenceType)
//=> 원시형 : 값을 표현하기 위한 자료형 - byte, short, int, long, char, float, double, boolean 
//=> 참조형 : 특정 대상을 표현하기 위한 자료형 - 배열(Array), 클래스(Class), 인터페이스(Interface), 나열형(Enum)

//기본형 변수 : 원시형(기본형)으로 생성된 변수 - 값을 저장하기 위한 변수  ex) int num=100;
//참조형 변수 : 참조형으로 생성된 변수 - 특정 대상의 메모리 주소값을 저장하기 위한 변수  ex) String name="홍길동";
//=> 힙영역(HearArea)에 생성된 배열 또는 객체의 메모리 주소를 저장하여 접근하기 위해 사용
//=> 비교 연산자를 사용하여 참조변수를 비교할 경우 참조변수의 저장된 메모리 주소 비교
//=> 참조변수에 배열 또는 객체를 저장하지 않을 경우 초기값으로 null 저장
//null : 아무런 것도 없을 표현하기 위한 키워드

//Java 프로그램에서 사용하는 메모리 영역
//=> 메소드 영역(Method Area), 힙 영역(Heap Area), 스택 영역(Stack Area)
//1.메소드 영역 : 클래스 파일(XXX.class)의 Java 자료형(클래스, 인터페이스, 나열형)을 읽어 저장하는 영역
//2.힙 영역 : 배열 또는 객체를 저장하기 위한 영역 - new 연산자 이용
//=> 메모리에 이름 설정 불가능 : 참조변수에 객체(배열)의 메모리 주소(HashCode)를 저장하여 접근
//3.스택 영역 : 지역변수(기본형 변수 또는 참조형 변수)를 저장하기 위한 영역 - FILO(First In Last Out)

//배열(Array) : 같은 자료형의 값을 여러개 저장하기 위한 메모리를 할당받기 위해 사용하는 자료형(참조형)
//=> 일괄처리를 목적으로 사용하는 자료형 - 배열의 사용 목적
//=> 1차원 배열과 다차원 배열(2차원 배열, 3차원 배열 등)로 구분
//=> 1차원 배열 : 다수의 값을 저장하기 위한 자료형, 다차원 배열 : 다수의 배열을 저장하기 위한 자료형

public class ArrayApp {
	public static void main(String[] args) {	
		// 1차원 배열을 생성하여 참조변수에 생성된 배열의 메모리 주소(Hash Code)를 저장
		// 형식) 자료형[] 참조변수 = new 자료형[갯수]
		// => new 자료형[갯수] : 자료형의 값을 갯수만큼 저장 가능한 메모리 할당
		// => 자료형[](배열 자료형) 참조변수 : 1차원 배열의 메모리 주소를 저장하기 위한 참조변수 생성
		// => "자료형 참조변수[]" 형식으로 참조변수 생성 가능
		// 1차원 배열에서 값을 저장하기 위한 메모리 공간을 요소(element)로 표현
		// => 배열의 요소는 첨자(Index : 0부터 1씩 증가되는 정수값)를 이용하여 구분
		// => 생성된 배열의 요소에는 기본값(숫자형 : 0, 논리형 : false, 참조형 : null)이 자동 저장 /초기값을 주지않아도 자동 초기화됨
	
		int[] num=new int[3];
		//참조변수에 저장된 값을 출력할 경우 "자료형@메모리주소" 형식의 문자열로 변환되어 출력 
		System.out.println("num = "+num);
		System.out.println("======================================================");
		
		//참조변수와 배열의 요소를 구분하는 첨자를 사용하여 배열 요소에 접근이 가능
		//형식) 참조변수[첨자] - 배열의 요소 표현
		System.out.println("num[0]= "+num[0]);
		System.out.println("num[1]= "+num[1]);
		System.out.println("num[2]= "+num[2]);
		//배열의 요소를 구분하는 첨자를 잘못 사용한 경우 ArrayIndexOutOfBoundsException 예외(Exception) 발생 >>프로그램 강제 종료
		//System.out.println("num[3]= "+num[3]);
		System.out.println("======================================================");
		//참조변수.length : 배열 요소의 갯수를 제공하는 표현식
		System.out.println("num.length= "+num.length);
		System.out.println("======================================================");
		int index=0;
		//배열 요소를 구분하는 첨자는 변수 또는 연산식 사용하여 표현 가능
		num[index]=10;
		num[index+1]=20;
		num[index+2]=30;
		
		//for 구문을 사용하여 배열 요소에 대한 일괄처리 
		//=> for 구문의 초기식, 조건식, 증감식에서 사용하는 변수를 첨자로 표현하여 일괄처리 
		//=> 입력, 계산, 출력에 대한 일괄처리에 사용
		for(int i=0;i<num.length;i++) {
			System.out.println("num["+i+"] = "+num[i]);
		}
		System.out.println("======================================================");
		
		//배열 생성시 배열 요소의 기본값 대신 원하는 초기값 저장 가능
		//형식) 자료형[] 참조변수 = new 자료형[]{초기값....나열}; ->정석, 힙 영역에 만들어짐
		// => 블럭 내부에 작성된 초기값의 갯수만큼 배열에 요소의 갯수를 가지고 있는 배열 생성
		int[] su1 =new int[] {10,20,30};
		
		for(int i=0;i<su1.length;i++) {
			System.out.println("su1["+i+"] = "+su1[i]);
		}
		System.out.println("==============================================================");
		//블럭 내부에 값을 나열하여 배열 생성 가능
		//형식) 자료형[] 참조변수={초기값, 초기값, ... };
		int[] su2={10, 20, 30};
		
		//Java에서는 배열을 일괄처리하기 위해 향상된 for 구문 제공
		//형식) for(자료형 변수명 : 참조변수) { 명령; ... }
		// => 참조변수에 저장된 배열의 요소값을 커서(cursor)를 사용하여 차례대로 하나씩 
		//제공받아 변수에 저장하여 일괄처리하는 반복문
		// => 배열의 모든 요소값을 제공받은 후 반복문 종료
		// => 계산, 출력에 대한 일괄처리에 사용
		for(int temp:su2) {
			System.out.print(temp+"\t");
		}
		System.out.println();
		System.out.println("==============================================================");
		int[] array={54,70,64,87,96,21,65,76,11,34,56,41,77,80};
		
		//배열의 모든 요소값에 대한 합계를 계산하여 출력하는 프로그램 작성
		int tot=0;
		
		for(int i=0;i<array.length;i++) {
			tot += array[i];
		}
		
		System.out.println("합계 = "+tot);
		System.out.println("==============================================================");
		//배열 요소값이 30~60 범위의 정수값이 저장된 요소의 갯수를 계산하여 출력하는 프로그램 작성
		int count=0;
		
		for(int element : array) {
			if(element >= 30 && element <= 60) {
				count++;
			}
		}

		System.out.println("30~60 범위의 요소의 갯수 = "+count);
		System.out.println("==============================================================");
	}
}