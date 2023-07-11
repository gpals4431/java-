package example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
// => 1~100 범위의 정수 난수값을 제공받도록 작성
// => 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
// => 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
// => 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료
// => 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
// => 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성
public class UpAndDownExample {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int su=0;
		int computer=(int)(Math.random()*100);
		
		//정답 상태를 저장하기 위한 변수
		// => false : 정답을 못맞춘 상태 , True: 정답 맞춘상태
		boolean result=false;
		
		for(int i=1; i<=10; i++) {
			int user;
			while(true) {
			 System.out.print(i+" 번째 1~100 범위의 정수 난수값 >> ");
			 user=scanner.nextInt();
			 if(user>=1 && user<=100) break;
			System.out.print("[에러] 1~100범위가 아닙니다");
			System.out.println();
		 }
				if(user==computer) {
					 System.out.println("축하합니다."+i+"번만에 맞췄습니다");
					 result=true;
					 break;
				 }else if(user>computer) { 
					 System.out.println(user+"보다 작은값을 입력하세요.");
					 
				 }else if(user<computer) {
					 System.out.println(user+"보다 큰값을 입력하세요.");
				 	
				 }
		}
		
				if(!result) {//정답을 맞추지 못한 경우
					System.out.println("정답을 맞추지 못했습니다. 정답 = "+computer+"입니다.");
				}
			
			/*if(user>computer) {
					 System.out.println("작은값입력");
					 su++;
				 }else if(user<computer) { 
					 System.out.println("큰값 입력");
					 su++;
				 }else if(user==computer||i>10) {
					 System.out.print("난수값 ="+computer+"이고, "+su+"번 출력하였습니다");
				 	break;
			*/
				 	}
			}
		 
	
//시작 >> 난수값 저장 >> 반복문 10번 >> 1~100범위 값 입력 >> 정상적이지 않을 경우 반복 >> 빠져나간 후 비교 >> 

		
	
	


