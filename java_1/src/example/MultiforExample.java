package example;

public class MultiforExample {
	public static void main(String[] args) {
		//★★★★★
		//★★★★
		//★★★
		//★★
		//★
		for(int i=5; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		/*
		 * for(int i=1; i<=5; i++) {
		 *  for(int j=1; j<=(6-i); j++)
		 *   { System.out.print("★"); }
		 * System.out.println(); }
		 */

		System.out.println("===============================================================");
		//1 2 3 4 5 >>j
		//★★★★★
		//☆★★★★
		//☆☆★★★
		//☆☆☆★★
		//☆☆☆☆★
		for(int i=1; i<=5;i++) {
			for(int j=1; j<=5; j++) {
				if(i<=j) {
				System.out.print("★");
			}
			else {
				System.out.print("☆");
			}
		}			
			System.out.println();
		}
		/*
		 * for(int i=1; i<=5; i++) {
		 *  for(int j=1; j<=(i-1); j++)
		 * System.out.print("☆");
		 *  for(int j=1; j<=(6-i); j++)
		 *   { System.out.print("★"); }
		 * System.out.println(); }
		 */


		System.out.println("===============================================================");
		//★
		//★★★
		//★★★★★
		//★★★★★★★
		//★★★★★★★★★
		
		for(int i=0;i<=4;i++) {
			for(int j=1; j<=(2*i+1); j++) {
				System.out.print("★");
				}
			System.out.println();
			}
			/*
			 * for(int i=1;i<=5;i++) {
			 *  for(int j=1; j<=i*2-1; j++) {
			 * System.out.print("★"); }
			 *  System.out.println(); }
			 */
		

		System.out.println("===============================================================");
		// 1 2 3 4 5 >>j
		//★☆☆☆★
		//☆★☆★☆
		//☆☆★☆☆
		//☆★☆★☆
		//★☆☆☆★

		for(int i=1; i<=5;i++) {
			for(int j=1; j<=5; j++) {
				if(i==j || i*j==5 ||i*j==8)  {//(i==j||i+j==6)
				System.out.print("★");
			}
			else {
				System.out.print("☆");
			}
		}			
			System.out.println();
		}

		
		System.out.println("===============================================================");
	}
}
