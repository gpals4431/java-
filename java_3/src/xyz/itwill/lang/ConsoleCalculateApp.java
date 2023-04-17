/*[0414] 7.*/
package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 사칙 연산식을 입력받아 연산결과를 계산하여 출력하는 프로그램 작성
//ex) 연산식 입력 >> 20 + 10
//    [결과]30
// => 입력 연산식에서 사용 가능한 연산자는 사칙 연산자(*,/,+,-)만 허용
// => 형식에 맞지 않는 연산식이 입력된 경우 에러 메세지 출력 후 프로그램 종료
// => 입력 연산식에 공백 입력이 가능하도록 처리
public class ConsoleCalculateApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		String cal, num1, num2 ;
		
	try {
		while(true) {
			
			System.out.print("연산식 입력 >> ");
			num1=scanner.nextLine().replace(" ", "");
			//System.out.print("연산식 입력 >> ");
			cal=scanner.nextLine().replace(" ", "");
			//System.out.print("연산식 입력 >> ");
			num2=scanner.nextLine().replace(" ", "");

			if(cal.equals("+")||cal.equals("-")||cal.equals("/")||cal.equals("*")) break;
			
			System.out.println("[에러]형식에 맞게 입력해 주세요.");
		}
		scanner.close();
		String tot = num1+cal+num2;
		String[] numArray=tot.split("\\+");
		String[] numArray1=tot.split("\\-");
		String[] numArray2=tot.split("\\*");
		String[] numArray3=tot.split("\\/");
	
			if(cal.equals("+")) {
				System.out.println("[결과] = "+(Integer.parseInt(numArray[0])+Integer.parseInt(numArray[1])));
				
			}else if(cal.equals("-")) {
				System.out.println("[결과] = "+(Integer.parseInt(numArray1[0])-Integer.parseInt(numArray1[1])));
		
			}else if(cal.equals("*")) {
				System.out.println("[결과] = "+(Integer.parseInt(numArray2[0])*Integer.parseInt(numArray2[1])));

			}else if(cal.equals("/")) {
				System.out.println("[결과] = "+(Integer.parseInt(numArray3[0])/Integer.parseInt(numArray3[1])));
			
			}
		}catch(NumberFormatException e) {
		
			System.out.println("[에러]정수값만 입력 가능합니다.");
		
		}catch( ArithmeticException e) {
		
			System.out.println("[에러]0으로 나눌 수 없습니다.");
			
		}catch( Exception e) {
		
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		
		}
	}
}

