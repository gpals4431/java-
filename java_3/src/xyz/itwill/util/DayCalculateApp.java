package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램 작성
//ex) 생년월일 입력 ex.2000-01-01 >> 2023-04-18
// [결과] 태어난지 <1일> 지났습니다.
// >> 형식에 맞지않는 생년월일을 입력한 경우 에러메세지 출력 후 프로그램 종료
public class DayCalculateApp {
	public static void main(String[] args) {
	
		String bday;
		Scanner scanner = new Scanner(System.in);
		System.out.print("생년월일 >> ");
		bday =scanner.nextLine();
		

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		//
		
		
		
		
		
		
	}
}