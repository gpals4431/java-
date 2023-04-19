package javaexample;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
		String operation = new String();
		
		String[] operatorArray = {"+","-","*","/"};
		
		//연산식에서 연산자를 검색하여 시작위치(Index)를 반환받아 저장
		
		int index = -1;//연산자의 시작위치를 저장하기 위한 변수
		for(String operator : operatorArray) {
			//String.lastIndexOf : 끝부분부터 검색  >> 매개변수로 전달받은 문자열을 찾을 수 없는 경우 -1 반환
			index = operation.lastIndexOf(operator);
			
			//연산식에서 연산자가 검색된 경우 반복문 종료
			if(index != -1) break;
			
		//연산자가 없거나 연산자가 잘못된 위치에 있는 경우
		if(index <= 0 || index >=operation.length()-1) {//잘못된 연삭식
			System.out.println("[에러]연산식을 잘못입력하였습니다");
			System.exit(0);
		}
		}
		try {
			//첫번째 피연산자를 분리하여 정수값으로 변환하여 저장
			int num1 = Integer.parseInt(operation.substring(0,index));
			//연산자를 분리하여 저장 
			String operator = operation.substring(0,index+1);
			//두번째 피연산자를 분리하여 정수값으로 변환하여 저장
			int num2 = Integer.parseInt(operation.substring(index+1));
			//연산자를 비교하여 피연산자에 대한 연산결과를 계산하여 저장 
			int result  =0 ;
			
			switch (operator) {
			case "*": 
				result = num1 * num2 ; break;
			case "/": 
				result = num1 / num2 ; break;
			case "+": 
				result = num1 + num2 ; break;
			case "-": 
				result = num1 - num2 ; break;
			}
			
	
			
		}catch(NumberFormatException e) {
			System.out.println("에러 연삭식에 숫자가 아닌 값이 입력 되었습니다");
		}catch(ArithmeticException e ) {
			System.out.println("에러 0으로 나눌 수 없습니다");
		}catch( Exception e) {
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		}
		
		
	}
}



				