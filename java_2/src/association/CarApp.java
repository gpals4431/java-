package association;

public class CarApp {
	public static void main(String[] args) {
		//엔진 생성
		Engine engine = new Engine();
		
		//engine.displayEngine(); >> 초기값으로 저장되어있음 그래서 setter호출
		engine.setFualType("경유");		
		engine.setDisplacement(2000);
		
		//engine.displayEngine();
		
		
		//자동차 생성
		Car carOne = new Car();
		
		carOne.setModelName("소렌토");
		carOne.setProductionYear(2020);
		//Setter 메소드를 호출하여 매개변수로 엔진정보(엔진 객체)를 전달받아 필드에 저장
		// => 인위적인 포함관계 성립
		carOne.setCarEngine(engine);
		
		carOne.displayCar();
		System.out.println("=============================================================");
		//자동차 생성 >> 엔진을 생성하여 필드에 저장 - 포함관계 성림 
		// => 생성자를 호출하여 매개변수에 엔진정보(엔진객체)를 전달받아 필드에 저장
		Car carTwo = new Car("산타페", 2023, new Engine("휘발유", 3000));
		
		carTwo.displayCar();
		System.out.println("=============================================================");
		System.out.println(carOne.getModelName()+"의 엔진정보 >>");
		engine.displayEngine();
		System.out.println("=============================================================");
		System.out.println(carTwo.getModelName()+"의 엔진정보 >>");
		//자동차(Car객체)에 저장된 엔진정보(Engine 필드값 - Engine객체)을 Getter메소드로
		//반환받아 Engine객체의 메소드 호출
		carTwo.getCarEngine().displayEngine();
		
	}
}
