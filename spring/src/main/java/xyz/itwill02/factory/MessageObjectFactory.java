package xyz.itwill02.factory;

//Factory 디자인 패턴이 적용된 클래스 - Factory 클래스(Provider Class)
//=> 프로그램 개발에 필요한 객체를 생성하여 제공하는 클래스 - 컨테이너
public class MessageObjectFactory {
	//Factory 클래스에 의해 제공될 객체를 구분하기 위한 상수(Constant)
	public static final int HELLO_MSG=1;
	public static final int HI_MSG=2;
	//매개변수에 전달된 값을 비교하여 필요한 객체를 생성하여 반환하는 메소드
	//=> 인터페이스를 상속받은 클래스로 객체를 생성하여 반환
	static MessageObject getMessageObject(int messageObject) {
		MessageObject object =null;
		switch(messageObject) {
		case HELLO_MSG:
			object = new HelloMessageObject();
			break;
		case HI_MSG:
			object = new HelloMessageObject();
			break;
		}
		return object;
	}
}