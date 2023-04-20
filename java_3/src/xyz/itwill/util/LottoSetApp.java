/*04 20 4*/
package xyz.itwill.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//1~45 범위의 정수형 난수값을 6개 제공받아 출력하는 프로그램 작성
// => 6개의 난수값은 서로 중복되지 않도록 작성하며 오름차순 정렬하여 출력
public class LottoSetApp {
	public static void main(String[] args) {
		//Integer 객체만 요소로 저장 가능한 set 객체(hashset 객체)생성
		Set<Integer> lottoSet = new HashSet<Integer>();
		Random random = new Random();
		
		while(true) {
			//1~45 범위의 정수형 난수값을 set 객체의 요소로 저장
			// => Set 객체에는 동일한 객체를 요소 저장 불가
			lottoSet.add(random.nextInt(45)+1);
			// set 객체에 저장된 요소의 갯수가 6인 경우 반복문 종료
			if(lottoSet.size() == 6) break;
			
		}
		
		//Set.toArray(E[] a) : Set 객체에 저장된 모든 요소값(객체)을 
		//매개변수로 전달받은 배열 요소에 저장하는 메소드  - set객체를 배열로 변환
		Integer[] lotto = lottoSet.toArray(new Integer[0]);//인티저 배열형태로 전달, 
		//[0]에 아무 숫자나 넣어도 상관없음 >>배열의 요소의 갯수가 중요한게아니고 어떤 요소값이 들어가 있는지가 중요함
		
		
		//Arrays.sort(object[] a): 매개변수로 전달받은 배열의 모든 요소값을 문자열로 변환하여 반환하는 메소드
		Arrays.sort(lotto);
		
		System.out.println("행운의 숫자 = "+Arrays.toString(lotto));
			
			
			
		
		
		
		
		
		
	}
}
