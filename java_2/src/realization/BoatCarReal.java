package realization;

public class BoatCarReal implements BoatCar {

	@Override//>>실체화
	public void run() {
		System.out.println("땅 위를 달리는 능력");
		
	}

	@Override
	public void navigate() {
		System.out.println("바다를 항해하는 능력");
	
	}

	@Override
	public void floating() {
		System.out.println("공중에 떠있는 능력");
		
	}

}
