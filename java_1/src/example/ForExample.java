package example;

public class ForExample {
	public static void main(String[] args) {
		//본인 이름을 화면에 7번 출력하세요.
		//ex) 홍길동 홍길동 홍길동 홍길동 홍길동 홍길동 홍길동
		for(int i=1;i<=7;i++) {
			System.out.print("홍길동");
		}
		System.out.println();
		System.out.println("=========================================");
		//1~10 범위의 정수 중 홀수를 화면에 출력하세요.
		//ex) 1     3     5     7     9
		
		//for(int i=1;i<=10;i+=2) {
		//	System.out.print(i+"\t");
		
		for(int i=1; i<=10;i++) {
			if(i%2!=0) {
				System.out.print(i+"\t");
			}
		}
		System.out.println();
		System.out.println("=========================================");
		//1~100 범위의 정수에서 3의 배수들의 합계와 5의 배수들의 합계를 계산하여
		//3의 배수의 합계에서 5의 배수의 합계를 뺀 결과값을 출력하세요.
		//ex) 결과 = 633
		int tot1=0;
		int tot2=0;
		//int tot3=tot1-tot2;이렇게 될 경우 tot3출력안됨, 포문 뒤에 배열만 됨
		
		for(int i=1;i<=100;i++) {
			if(i%3==0)  
			tot1+=i;
			if(i%5==0) 
			tot2+=i;
		}
		int tot3=tot1-tot2;//누적해야하기때문에 0으로 저장
		System.out.println(tot3);
		System.out.println("=========================================");
		//구구단 중 7단을 화면에 출력하세요.
		//ex) 7 * 1 = 7
		//    7 * 2 = 14
		//    ...
		//    7 * 8 = 56
		//    7 * 9 = 63
		int a=7;
		for(int i=1;i<=9;i++) {
			System.out.println(a+"*"+i+"="+a*i+"\t");
		}
		System.out.println("=========================================");
		
		//5!의 결과값을 출력하세요.(5! = 5 * 4 * 3 * 2 * 1)
		//ex) 5! = 120
		//int x=1;
		//for(int i=5;i>=1;i--) {
		//	x*=i;
		//
		int num=5, fac=1;
		for(int i=num;i>=1;i--)
			fac*=1;
	
			System.out.println(num+"!="+fac);
			}



		//두 변수에 저장된 정수값 사이의 정수들을 화면에 출력하세요.
		//단, 한 줄에 정수값이 7개씩 출력되도록 프로그램을 작성하세요.
		//ex) 36    27    38     39     40     41     42
		//    43    44    45     46     47     48     49
		//    50    51    52     53     54     55     56
		//    57
		int begin=36, end=57;
		int x = 0;{//출력 갯수를 저장할 변수
		for(int i=begin;i<=end;i++) {
			System.out.print(i+"\t");
			x++;				
			if(x%7==0) {
				System.out.println();
				}
			}
		System.out.println();
		System.out.println("=========================================");
		}
}
		

	
	
	


