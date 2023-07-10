package basic;

import java.util.Scanner;

//스트림 : 시냇물이 흘러가는 모양, 실제 값이 전달되는 개체(통로)
//System.out : 프로그램의 값을 출력 스트림을 사용하여 화면에 전달하는 기능을 제공하는 객체 
//System.in : 키보드로부터 입력된 값을 입력 스트림울 사용하여 프로그램에 전달하는 기능을 제공하는 객체

//사용자로부터 키보드로 이름과 나이를 입력받아 화면에 출력하는 프로그램 작성


public class ScannerApp {
	public static void main(String[] args) {
		//Scanner클래스 : 입력 스트림(키보드 - System.in, 파일 등)을 전달받아 원하는 자료형으로 
		//값을 입력받기 위한 기능을 제공하는 클래스
		//Scanner 객체를 생성하여 참조변수에 저장
		//=>참조 변수를 사용하여 참조변수에 저장된 객체의 메소드를 호출하여 필요한 기능 구현 
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("이름 입력 >>");
		//scanner.nextline(); : 입력스트림에 전달된 값(입력값)을 문자열로 변환하여 반환하는 메소드
		//키보드로 입력된 값을 문자열로 반환받아 변수에 저장 
		// => 키보드 입력값이 없는 경우 프로그램의 흐름(스레드)이 일시중지
		// => 키보드로 값을 입력한 후 엔터(Enter)를 입력하면 프로그램의 흐름이 재실행
		String name = scanner.nextLine();
		
		System.out.print("나이 입력 >>");
		//scanner.nextInt(); : 입력값을 정수값으로 변환하여 반환하는 메소드		
		//키보드로 입력된 값을 정수값으로 반환받아 변수에 저장
		// => 키보드로 입력된 값이 정수값이 아닌 경우 예외(Exception) 발생
		int age=scanner.nextInt();
		
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살 입니다.");
		//scanner.close() : scanner 객체가 사용한 입력스트림을 제거하는 메소드
		scanner.close();
	}
}
