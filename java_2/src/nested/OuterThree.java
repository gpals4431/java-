package nested;

public class OuterThree {
	private int outerNum;
	
	public OuterThree() {
		// TODO Auto-generated constructor stub
	}
	
	public OuterThree(int outerNum) {
		super();
		this.outerNum = outerNum;
	}


	public int getOuterNum() {
		return outerNum;
	}
	public void setOuterNum(int outerNum) {
		this.outerNum = outerNum;
	}
	public void outerDisplay() {
		System.out.println("outerNum = "+outerNum);
		
		
	}
	public void local() {
		//로컬(지역)클래스
		class InnerThree{
			int innerNum;
			
			void innerDisplay() {
				System.out.println("innerNum = "+innerNum);
			}
		}
		
		//지역클래스가 선언된 메소드에서만 객체를 생성하여 필드 또는 메소드 참조가능
		InnerThree innerThree = new InnerThree();
		innerThree.innerNum=200;
		innerThree.innerDisplay();
	}

}
