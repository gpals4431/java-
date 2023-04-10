package association;


//자동차 정보(모델명, 엔진정보, 생산년도)를 저장하기 위한 클래스
public class Car {
	private String modelName;
	private int productionYear;
	//엔진 정보를 저장하기 위한 필드 생성 - Engine 클래스를 자료형으로 선언된 필드
	// => 필드에는 생성자 또는 Setter 메소드를 사용하여 엔진 객체를 제공받아 저장 - 포함 관계(복합적 연관 관계-생명주기가 같은 경우 )
	
	private Engine carEngine;
	
	
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	public Engine getCarEngine() {
		return carEngine;
	}
	public void setCarEngine(Engine carEngine) {
		this.carEngine = carEngine;
	}
	//자동차 정보(필드값)를 출력하는 메소드
	public void display() {
		System.out.println("모델명 ="+modelName);
		System.out.println("생산년도 ="+productionYear);
		System.out.println("엔진정보 ="+carEngine);
		
	}
	
	
}
