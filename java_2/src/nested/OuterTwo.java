package nested;

public class OuterTwo {
	private int outerNum;
	
	public OuterTwo() {
		// TODO Auto-generated constructor stub
	}
	
	public OuterTwo(int outerNum) {
		super();
		this.outerNum = outerNum;
	}
	
	public int getOuternum() {
		return outerNum;
	}
	
	public void setOuternum(int outerNum) {
		this.outerNum = outerNum;
	}
	
	public void outerDisplay() {
		System.out.println("outerNum = "+outerNum);
		/*
		 * InnerTwo innerTwo = new InnerTwo(200);
		 * System.out.println("innerNum = "+innerTwo.innerNum); innerTwo.innerDisplay()
		 */
	}
	
	
	//정적 내부 클래스: static 제한자를 사용하여 클래스 선언
	//>>정적 내부 클래스에서는 static 제한자를 사용하여 필드 또는 메소드 선언 가능
	public static class InnerTwo{
		private int innerNum;
		private static int StaticNum = 300;
		
		public InnerTwo() {
			// TODO Auto-generated constructor stub
		}

		public InnerTwo(int innerNum) {
			super();
			this.innerNum = innerNum;
		}

		public int getInnerNum() {
			return innerNum;
		}

		public void setInnerNum(int innerNum) {
			this.innerNum = innerNum;
		}

		public static int getStaticNum() {
			return StaticNum;
		}

		public static void setStaticNum(int staticNum) {
			StaticNum = staticNum;
		}
		public void innerDisplay() {
			System.out.println("innerNum = "+innerNum);
			System.out.println("staticNum = "+StaticNum);
			
			//System.out.println("outerNum = "+outerNum);
			// outerDisplay();
	}

	}


}
