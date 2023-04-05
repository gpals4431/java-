package example;

public class ArrayExample {
   public static void main(String[] args) {
      //사람들의 나이를 저장한 배열 생성하여 참조변수에 저장      
      int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
      
      //배열에 저장된 모든 사람들의 나이 평균을 계산하여 출력하세요.
      
      int sum=0;
      for(int i=0; i<age.length;i++) {
         sum+=age[i];
      }
         //double ave=(double)sum/age.length;
         System.out.println("평균 ="+sum/age.length);
         System.out.println("===============================================================");
         //배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
         //ex) 10대 = 3명
         //    20대 = 4명
         //    ...
         //    60대 = 1명
         
      /*   int cnt10=0;
         int cnt20=0;
         int cnt30=0;
         int cnt40=0;
         int cnt50=0;
         int cnt60=0;
         
         //연령별 인원수를 누적하기 위한 선택문
         for(int cnt : age) {
            if(cnt<20) {
               cnt10++;
            }else if(cnt<30){
               cnt20++;
            }else if(cnt<40) {
               cnt30++;
            }else if(cnt<50) {
               cnt40++;
            }else if(cnt<60) {
               cnt50++;
            }else{
               cnt60++; 
            }
         }
         System.out.println("10대"+cnt10+"명");
         System.out.println("20대"+cnt20+"명");
         System.out.println("30대"+cnt30+"명");
         System.out.println("40대"+cnt40+"명");
         System.out.println("50대"+cnt50+"명");
         System.out.println("60대"+cnt60+"명");
         */
         int[] cnt=new int[6];
   
        //      int[] age={27,16,22,36,57,60,43,23,14,29,44,52,59,51,39,33,11};
         for(int nai : age) {
        	
        	 cnt[nai/10-1]++;
        	 
        	 }
            for(int i = 0;i<cnt.length;i++)
            	System.out.println((i+1)+"0대 = "+cnt[i]+"명");
             }
         
   }
         
         
        
   