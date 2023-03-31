package example;

public class IfExample {
	public static void main(String[] args) {
		//변수에 저장된 문자값을 출력하세요.
		//단, 변수에 저장된 문자값이 소문자인 경우 대문자로 변환하여 출력하세요.
		char mun='x';
		if(mun>='a'&&mun<='z') {
			char m=(char)(mun-32);
				}

		System.out.println("mun = "+mun);
		System.out.println("mun = "+mun);
		System.out.println("============================================================");
		//변수에 저장된 정수값이 4의 배수인지 아닌지를 구분하여 출력하세요.
		int num=345644;
		if(num%4!=0) {
			System.out.println("= 4의 배수가 아니다.");
		}
		if(num%4==0)
			System.out.println("= 4의 배수이다");

		System.out.println("============================================================");
		//올해가 평년인지 윤년을 구분하여 출력하세요.
		// => 년도를 4로 나누어 나머지가 0인 경우 윤년
		// => 위 조건을 만족하는 년도 중 100으로 나누어 나머지가 0인 경우 평년
		// => 위 조건을 만족하는 년도 중 400으로 나누어 나머지가 0인 경우 윤년
		int year=2023;
		if(year%4!=0) {
			System.out.println("윤년");
		} else if(year%100==0) {
			System.out.println(year+"=평년");
		} else if(year%400==0) {
			System.out.println(year+"=윤년");
		}
		


		System.out.println("============================================================");
		//이름이 [홍길동]인 학생이 국어점수 89점, 영어점수 93점, 수학점수 95점을 받은 경우
		//총점과 평균, 학점을 계산하여 이름, 총점, 평균, 학점을 출력하세요.
		// => 국어,영어,수학 점수 중 하나라도 0~100 범위가 아닌 경우 프로그램 강제 종료
		//    System.exit(0) : 프로그램을 강제로 종료하는 메소드
		// => 평균을 이용한 학점 계산 : 100~90:A, 89~80:B, 79~70:C, 69~60:D, 59~0:F
		// => 평균은 소숫점 두자리까지만 출력하고 나머지는 절삭 처리 하세요.
		String name="홍길동";
		int kor=189, eng=93, mat=95;
		int tot=kor+eng+mat;
		double ave2= (tot/3.);
		double A=(int)(ave2*100+0.5)/(100.0);
		
		if(kor >= 0 && kor <= 100 && eng >= 0 && eng <= 100 && mat >= 0 && mat <= 100) {	
	
		String grade;
		if(A >= 90) {
			grade = "A";
		} else if(A >= 80) {
			grade = "B";
		} else if(A >= 70) {
			grade = "C";
		} else if(A >= 60) {
			grade = "D";
		} else {
			grade = "F";//모든 조건이 거짓인 경우 무조건 실행되는 명령
		}
		System.out.println("이름 : "+name+" 총점 :"+tot+" 평균 : "+(int)(A*10+0.5)/(10.0)+", 학점:"+grade);
		
		}else {
		System.out.println("[에러]0~100 범위를 벗어난 비정상적인 점수가 입력 되었습니다.");
	}
}
}

