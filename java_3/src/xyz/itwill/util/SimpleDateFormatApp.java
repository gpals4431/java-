/*0419 5*/
package xyz.itwill.util;

/*0419 5-1*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//java.text 패키지 :  값을 변환하는 기능의 클래스가 선언된 패키지

//simpleDateFormat 클래스 : date 객체와 string 객체를 서로 변환하기 위한 기능을 메소드로 제공하기 위한 클래스
public class SimpleDateFormatApp{
	public static void main(String[] args) {
		
	Date now = new Date();//시스템에 날자와 시간 저장
	
	//SimpleDateFormat 클래스로 객체를 생성하기 위한 매개변수에 날짜와 시간에 대한 패턴정보를
	//문자열 전달받아 객체로 (날짜와 시간을 임의의 문자로 표현)를 사용하여 표현된 문자열을 생성하는 생성자를 사용
	// >> 패턴정보 : 패턴문자를 사용하여 표현된 문자열
	// >> 패턴문자 : y(년), M(월) ,d(일) ,E(요일) , AM||PM(오전||오후) h(시:12) , H(시 :24), m(분), s(초)
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");//매개변수 형태로 패턴정보를 저장해줌
	
	String printDate = dateFormat.format(now);

	System.out.println("현재날짜 = "+printDate);
	//dateFormat.applyPattern : 객체에 저장된 패턴정보를 변경하는 메소드
	
	dateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");//패턴 정보를 바꿀수도 있음
	
	System.out.println("현재날짜 = "+dateFormat.format(now));
	
	String want = "2000-01-01 00:00:00";
	try {
		//SimpleDateFormat.parse(String str) : 객체에 저장된 패턴정보와 동일한 문자열을 전달받아 
		// 원하는 날짜와 시간이 저장된 Date 객체를 생성하여 반환하는 메소드
		// >> SimpleDateFormat 객체에 저장된 패턴정보와 일치하지 않는 문자열이 전달된 경우  ParseException 발생 가능 -예외처리
		Date wantDate = dateFormat.parse(want);//String 객체 >> Date 객체
		System.out.println("wantDate = "+wantDate);
		
	}catch(ParseException e) {
		System.out.println("error : 형식에 맞게 날짜와 시간을 입력해주세요.");
		
	}
	
	
	}
}
