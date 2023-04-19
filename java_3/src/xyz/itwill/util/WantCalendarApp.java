package xyz.itwill.util;

import java.io.WriteAbortedException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램 작성
public class WantCalendarApp {
	public static void main(String[] args) {
		int year;
		int  month;
		Calendar calendar = Calendar.getInstance();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("년 ");
		System.out.print("월 >>");
		
		
		year =scanner.nextInt();
		month =scanner.nextInt();
				
		calendar.set(year,month-1, 1);
		
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("                   "+calendar.get(Calendar.YEAR)+"년 "
				+(calendar.get(Calendar.MONTH)+1)+"월");
		System.out.println("===============================");
		System.out.println("  일  월  화  수  목  금  토  ");
		System.out.println("===============================");
		
		//[1일]을 출력하기 전까지의 요일을 공백으로 출력
		for(int i =1 ; i < week ; i++) {
			System.out.print("    ");
			
		}
		//1일부터 [월]의 마지막 날짜까지 출력
		for(int i =1; i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			//날짜 출력 >> 자릿수 맞춤
			if(i<=9) {
				System.out.print("   "+i);
				
			}else {
				System.out.print("  "+i);
				
			}
			
			week++;
			
			if(week%7==1) {//다음 출력값(일)이 일요일인 경우
				System.out.println();
			}
		}
		
	}
}
