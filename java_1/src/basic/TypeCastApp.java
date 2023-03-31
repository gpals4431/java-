package basic;

//자료형 변환(TypeCast): 값의 자료형을 일시적으로 변환하여 사용하는 방법
// => 자동 형변환(JVM이 실행할 때 해줌), 강제 형변환(프로그래머) 
public class TypeCastApp {
	public static void main(String[] args) {
		// 자동 형변환 : 자료형이 다른 값을 연산하기 위해 JVM(Java Virtual Machine :
		// Java 프로그램을 실행하기 위한 가상의 플랫폼)이 자료형을 일시적으로 변환
		// => 표현의 범위가 작은 자료형의 값이 큰 자료형의 값으로 형변환되어 연산 처리된다.
		// => byte >> short >> char(0~65535) >> int >> long >> float >> double
		System.out.println("결과 =" + (3 + 1.5));// 3(int)+1.5(double) >> 3.0(double)+1.5(double)>>4.5(double)

		double su = 10;// 10 >> 10.0
		System.out.println("su=" + su);

		System.out.println("결과 =" + (35 / 10));// int/int >>int 실수가 될 수 없음
		System.out.println("결과 =" + (35.0 / 10.0));// double/double
		System.out.println("결과 =" + (35.0 / 10));// double/int>>double/double(자동형변환)>>double
		System.out.println("결과 =" + (35 / 10.));// int/double >>double/double>>double

		int kor = 95, eng = 90;// 점수입력
		int tot = kor + eng;// 총점 계산
		//double ave= tot/2;//평균 계산 - 연산 결과값: 정수값(92) >> 실수값(92.0) ->정수/정수를 실수(double)에 입력하면서 .0만 생김.
		double ave = tot / 2.;// 평균 계산 - 실수값(92.5)
		System.out.println("총점 =" + tot + ", 평균=" + ave);

		// int 자료형보다 작은 자료형의 값은 무조건 int 자료형으로 형변환되어 연산 처리.
		byte su1 = 10, su2 = 20;
		// byte su3=su1+su2;//byte+byte>>int+int>>int : byte 변수에 저장 불가능
		int su3 = su1 + su2;
		System.out.println("su3=" + su3);
		// 강제 형변환: 프로그래머가 Cast 연산자를 사용하여 원하는 자료형의 값을 일시적으로
		// 변환하여 명령을 작성하는 방법 - (자료형)값
		int num = (int) 12.3;// (int)12.3>>12
		System.out.println("num =" + num);

		int num1 = 95, num2 = 10;
		// double num3=num1/num2; //연산결과 9.0
		double num3 = (double) num1 / num2;// 연산결과 9.5, 강제형변환 연산자는 제일 먼저 실행
		System.out.println("num=" + num3);

		// 큰 정수값은 _기호를 사용하여 표현 가능
		int num4 = 100_000_000, num5 = 30;
		// 정수값에 대한 연산 결과는 4Byte(-2148483648~2147483647)로만 표현 가능
		// 문제점) 정수값에 대한 연산 결과값이 4Btye로 표현 가능한 범위를 벗어난 경우 쓰레기값 발생
		// => 변수에 쓰레기값이 저장되어 잘못된 결과값 출력-실행오류
		// num6= num4*num5;//오버플로우: 자릿수가 넘어가서 나머지값이 나옴, 유일하게 쓰레기값이 나옴.
		// 해결법) 정수값에 대한 연산 결과값이 8byte로 표현될 수 있도록 강제 형변환
		// =>8byte의 연산 결과값을 저장하기 위해 변수를 long자료형으로 선언
		long num6 = (long) num4 * num5;
		System.out.println("num6=" + num6);

		double number = 1.23456789;
		System.out.println("number =" + number);

		// 소숫점 2자리 위치까지만 출력되도록 명령 작성
		System.out.println("number(내림)=" + (int) (number * 100) / 100.0);
		System.out.println("number(반올림)=" + (int) (number * 100 + 0.5) / 100.0);
		System.out.println("number(올림)=" + (int) (number * 100 + 0.9) / 100.0);

	}
}
