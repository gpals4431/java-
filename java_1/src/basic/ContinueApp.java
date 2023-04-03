package basic;



public class ContinueApp {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			if(i==3)continue;
			System.out.println(i+"\t");
		}
		
		System.out.println();
		System.out.println("============================================");
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3)continue;//for(int j=1;j<=5;j++)반복문 재실행
				System.out.println(i+"+"+j);
			}
		}
		System.out.println();
		System.out.println("============================================");
	}
}
