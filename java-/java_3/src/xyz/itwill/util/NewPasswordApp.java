/*0419 2*/
package xyz.itwill.util;

import java.util.Random;
import java.util.UUID;

public class NewPasswordApp {
	//새로운 비밀번호를 생성하여 반환하는 메소드 - Random 클래스 이용
	public static String newPasswordOne() {
		Random random = new Random();
		
		//비밀번호로 사용될 문자들이 저장된 문자열을 생성하여 저장
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		
		StringBuffer password = new StringBuffer();
		for(int i=1;i<=10;i++) {
			password.append(str.charAt(random.nextInt(str.length())));
			//length만큼의 난수로 제공받은 위치의 문자를 하나씩 열개를 제공받아 버퍼에 추가
		}
		
		return password.toString();//문자열로 반환해주세요
		
	}
	//새로운 비밀번호를 생성하여 반환하는 메소드 - UUID 클래스 이용
	public static String newPasswordTwo() {
		//UUID 클래스 : 범용적으로 사용되는 식별자를 생성하기 위한 기능을 메소드로 제공하는 클래스 
		//UUID.randomUUID() : 식별자를 생성하여 식별자가 저장된 UUID 객체를 반환하는 메소드
		// => UUID 객체에 저장된 식별자는 숫자와 영문자(소문자), 4개의 '-' 문자를 조합하여 36개의 
		//문자가 구성된 문자열로 생성 
		//UUID.toString : UUID 갹채애 저장된 식별자를 문자열(String 객체)로 변환하여 반환하는 메소드
		return UUID.randomUUID().toString().replace("-", "").substring(0,10).toUpperCase();
		
	}
	public static void main(String[] args) {
		System.out.println("새로운 비밀번호 -1 = "+newPasswordOne());
		System.out.println("새로운 비밀번호 -2 = "+newPasswordTwo());
		
	}
}
