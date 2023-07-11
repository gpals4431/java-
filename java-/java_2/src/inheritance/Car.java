package inheritance;

//자동차 정보(모델명, 소유자명)를 저장하기 위한 클래스
// => 클래스 선언시 상속받은 부모클래스가 없는경우 기본적으로 Object 클래스를 자동으로 상속
// => 모든 자바 클래스는 Object를 상속받아 사용 가능
//Object클래스 : 모든 자바 클래스의 최선조 클래스(뿌리), 모든 자식들을 저장해서 참조할 수 있음
// => Object 클래스로 생성된 참조변수에는 모든 클래스로 생성된 객체 저장 가능
public class Car/*extends Object*/ {
	private String modelName;
	private String userName;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	

	public Car(String modelName, String userName) {
		super();//부모클래스가 있다 >> object클래스
		
		
		this.modelName = modelName;
		this.userName = userName;
	}


	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//object클래스의 toString메소드를 오버라이드 선언
	// => 오브젝트 클래스의 toString메소드는 숨겨지고 Car클래스의 toString 메소드 호출
	// => VO클래스에서는 필드값을 문자열로 변환하여 반환하는 명령 작성 - 필드값 확인
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "모델명 =" + modelName+", 소유자명 ="+userName;
		
	}
}
