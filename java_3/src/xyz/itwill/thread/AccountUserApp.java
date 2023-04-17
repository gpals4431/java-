package xyz.itwill.thread;


//다중 스레드 프로그램의 문제점
// => 다수의 스레드가 run()메소드의 명령을 실행할 경우 같은 객체의 메소드를 호출하여 필드값(공유값)을 변경할 경우
//잘못된 처리 결과 발생 가능
public class AccountUserApp {
	public static void main(String[] args) {
		//account 클래스로 객체를 생성하여 저장 = 은행계좌 생성
		Account account = new Account(10000);
		/*
		 * 
		 * //단일 스레드를 이용하여 클래스로 객체를 생성해 저장 // => 은행계좌를 사용하는 사용자를 여러개 생성하여 같은 은행계좌를 사용하도록
		 * 설정 AccountUser one= new AccountUser(account, "홍길동"); AccountUser two= new
		 * AccountUser(account, "임꺽정"); AccountUser three= new AccountUser(account,
		 * "전우치");
		 * 
		 * //단일 스레드를 이용하여 은행꼐좌 사용자를 이용한 은행계좌의 입금 처리 >>동시에 처리 불가능
		 * one.getAccount().deposit(one.getUsename(), 5000);//잔액 15000
		 * two.getAccount().deposit(two.getUsename(), 5000);//잔액 2만
		 * three.getAccount().deposit(three.getUsename(), 5000);//잔액 2만 5천
		 * 
		 */
		
		//스레드를 여러개 생성하여 동시에 입(출)금 처리 
		// => 새로운 스레드가 생성되어 run()메소드의 명령실행 - 입금처리
		new AccountUser(account, "홍길동").start();
		new AccountUser(account, "임꺽정").start();
		new AccountUser(account, "전우치").start();
		
		
		
	}
}
