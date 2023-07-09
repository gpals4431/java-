package basic;

//while : 조건에 의해 명령을 반복 실행
//=> 반복의 횟수가 명확하지 않은 경우 사용하는 반복문
//형식) while(조건식) { 명령; 명령; ... }
//=> 조건식의 결과가 참인 경우 명령을 반복 실행하고 거짓인 경우 반복문 종료
//=> 조건식 생략 불가능
//=> 블럭 내부에 작성된 명령을 0번 이상 실행

//형식) do { 명령; 명령; ... } while(조건식)
//=> 블럭 내부에 작성된 명령을 1번 이상 실행

public class WhileApp {
	public static void main(String[] args) {
 //"java programming을 화면에 5번 출력하는 프로그램 작성
		int i=1;
		while(i<=5){
			System.out.println("java programming");
			i++;
		}
		System.out.println("======================================");
		//1~100까지의 정수들의 합계를 계산하여 출력하는 프로그램 작성
		int j=1, tot=0;
		do {
			tot+=j;
			j++;
		}while(j<=100);
		System.out.println("1~100 정수의 합계 = "+ tot);
		System.out.println("======================================");
		//A4용지를 반으로 계속 접어서 펼쳤을 때, 사각형 모양의 갯수가 500개 이상이
		//만들어지려면 몇 번 접어야 하는지를 계산하여 출력하는 프로그램 작성
		
		int cnt=0;//접는 횟수
		int gae=1;//사각형 모양의 갯수
		//4각형 모양의 갯수가 500개 미만인 경우 반복처리하고 500개 이상인 경우 반복문 종료
		
		while(gae<500){//a4용지를 반으로 계속 접기 위한 행위를 제공하는 반복문
			cnt++;//접는 획수는 1씩 증가
			gae*=2;	//사각형 모양의 갯수는 2배 증가
		}
		System.out.println(cnt+"번 접으면 "+gae+"개의 사각형이 만들어집니다.");
		System.out.println("======================================");
		
		//1~X 범위의 정수들의 합계가 300 이상이 만들어지려면 X가 얼마인지 계산하여 출력하는 프로그램 작성
		//1+2+3+...+x>=300
		int x=0, sum=0;//x: 1씩 증가되는 정수값 저장, sum: 누적 결과(합계)저장
		while(sum<300){
			x++;
			sum+=x;
		}
		 	System.out.println("1~"+x+" 범위의 정수들의 합계 ="+sum);
	}
}
