package basic;

//break : switch 구문 또는 반복문을 강제로 종료하기 위해 사용하는 제어문

public class BreakApp {
	public static void main(String[] args) {
		//반복문은 조건식이 결과가 거짓인 경우 반복문 종료
		for(int i=1; i<=5; i++) {
			if(i==3)break;//if 구문의 조건이 참인 경우 break구문을 이용하여 반복문 종료
			System.out.print(i+"\t");
		}
		System.out.println();
		System.out.println("================================================");
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3)break;//for(int j=1;j<=5;j++)반복문 종료
				System.out.println("i ="+i+", j ="+j);
			}
		}
		System.out.println("================================================");
		//반복문 작성시 반복문을 구분하기 위한 식별자(라벨명) 선언 가능
		//형식)라벨명:반복문
		loop:
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				//break 라벨명 : 라벨명으로 지정된 반복문 종료
				if(j==3)break loop;//for(int i=1;i<=5;i++) 반복문 종료
				System.out.println("i ="+i+", j ="+j);
			}
		}
		System.out.println("================================================");

	}
}
