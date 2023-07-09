package basic;

public class MultiForApp {
	public static void main(String[] args) {
		int cnt=0;//이동 방법의 갯수를 저장하기 위한 변수
	
	for(int i=1; i<=3; i++) {//A나라>>섬 - 반복문
		for(int j=1; j<=4; j++) {//섬>>B나라 - 반복문
			cnt++;
		} 
	}
	
	System.out.println("이동방법의 갯수 = "+cnt);
	System.out.println("============================================");
		
	//★★★★★★★
	//★★★★★★★
	//★★★★★★★
	//★★★★★★★ 
	
	for(int i=1;i<=4;i++) {//행(Row)을 처리하기 위한 반복문
		for(int j=1; j<=7; j++) {//열(Column)을 처리하기 위한 반복문
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("============================================");
	//2★1=2   3★   4★ .... 8★   9★
	//2★2=4   3★   4★ .... 8★   9★
	//2★3   3★   4★ .... 8★   9★
	//2★4   3★   4★ .... 8★   9★
	//...
	//2★7   3★   4★ .... 8★   9★
	//2★8   3★   4★ .... 8★   9★
	//2★9   3★   4★ .... 8★   9★
	
	for(int k=2; k<=9; k++) {
	System.out.print(k+"단\t");}
	System.out.println();
	
	for(int i=1;i<=9;i++) {//행(Row)을 처리하기 위한 반복문
		for(int j=2; j<=9; j++) {//열(Column)을 처리하기 위한 반복문
			System.out.print(j+"*"+i+"="+j*i+"\t");
		}
		System.out.println();
	}
	System.out.println("============================================");
	//★            i=1 
  	//★★          i=2 
 	//★★★        i=3
	//★★★★      i=4
	//★★★★★    i=5
	for(int i=1;i<=5;i++) {//행(Row)을 처리하기 위한 반복문
		for(int j=1; j<=i; j++) {//열(Column)을 처리하기 위한 반복문
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("============================================");
	
	//★★★★★    i=5
	//★★★★      i=4
	//★★★        i=3
	//★★          i=2 
	//★            i=1 
	for(int i=5;i>=1;i--) {//행(Row)을 처리하기 위한 반복문
		for(int j=1; j<=i; j++) {//열(Column)을 처리하기 위한 반복문
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("============================================");
	//☆☆☆☆★     흰별 4개    i=1 
  	//☆☆☆★★     흰별 3개    i=2 
 	//☆☆★★★        i=3
	//☆★★★★      i=4
	//★★★★★    i=5
	for(int i=1;i<=5;i++) {//행(Row)을 처리하기 위한 반복문
		for(int j=1; j<=(5-i); j++) {//열(Column)을 처리하기 위한 반복문
			System.out.print("☆");
		}
		for(int j=1; j<=i; j++) {//열(Column)을 처리하기 위한 반복문
			System.out.print("★");
		}
		System.out.println();
	}
	System.out.println("============================================");
	
	//1 2 3 4 5 >>j
	//☆☆☆☆★      i=1 
  	//☆☆☆★★      i=2 
 	//☆☆★★★      i=3
	//☆★★★★      i=4
	//★★★★★      i=5
	for(int i=1;i<=5;i++) {//행(Row)을 처리하기 위한 반복문
		for(int j=1; j<=5; j++) {//열(Column)을 처리하기 위한 반복문
			if(i+j<6) {
				System.out.print("☆");
			}
			else {
				System.out.print("★");
			}
		}
		System.out.println();
	}
	System.out.println("============================================");
	}
}