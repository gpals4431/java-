/*04 20 5*/
package xyz.itwill.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//List 인터페이스를 상속받은 콜렉션 클래스 - ArrayList, Vector, LinkedList 등
//=> List 객체를 요소를 차례대로 저장(순서 존재) - 첨자(Index)를 이용하여 요소를 구분하여 사용 가능
//=> List 객체에 저장된 요소를 검색하는 속도가 비효율적
public class ListApp {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		//List.add(E element) : List 객체에 요소를 추가하는 메소드
		// => list객체에 요소가 차례대로 저장
		list.add("홍길동");
		list.add("임꺽정");
		list.add("전우치");
		list.add("일지매");
		
		//List.toString() : List 객체에 저장된 모든 요소(객체)를 문자열로 변환하여 반환하는 메소드
		//System.out.println("list.toString() = " +list.toString());
		System.out.println("list = " +list);
		System.out.println("======================================================");
		list.add("임꺽정");
		System.out.println("list = " +list);
		System.out.println("======================================================");
		//list.size() : list 객체에 저장된 요소의 갯수를 반환하는 메소드
		System.out.println("요소의 갯수 = "+list.size());
		System.out.println("======================================================");
		//list.get(int index) : list 객체에서 index위치에 저장된 요소값(객체)를 반환하는 메소드 
		System.out.println("3번째 위치에 저장된 문자열 = "+list.get(2));
		System.out.println("======================================================");
		//list.add(int index, E element) : list 객체에서 index위치에 요소값(객체)를 삽입하는 메소드 
		list.add(4,"장길산");
		System.out.println("list = " +list);
		System.out.println("======================================================");
		//list.remove(E element) : 매개변수로 전달받은 객체와 동일한 요소를 list 객체에서 삭제하는 메소드 - 첫번째 검색 요소만
		//list.remove("임꺽정");
		list.remove(5);//list객체에서 index위치의 요소를 삭제하는 메소드
		System.out.println("list = " +list);
		System.out.println("======================================================");
		//list.set(int index, E element) : List 객체에서 index위치의 요소값(객체)를 변경하는 메소드 
		list.set(1, "임걱정");
		System.out.println("list = " +list);
		System.out.println("======================================================");
		
		//List객체에 저장된 모든 요소에 대한 일괄처리 - 일반 for구문 이용
		for(int i = 0; i< list.size(); i++) {
			System.out.print(list.get(i)+" ");
			
		}
		System.out.println();
		System.out.println("======================================================");
		//List객체에 저장된 모든 요소에 대한 일괄처리 - Iterator 객체 이용
		
		//list.iterator() : list 객체에 저장된 요소를 반복처리할 수 있는 iterator객체를 반환하는 메소드
		Iterator<String> iterator =list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next()+" ");
		}
		System.out.println();
		System.out.println("======================================================");
		//List객체에 저장된 모든 요소에 대한 일괄처리 - 향상된 for문 아용
		for(String str : list) {
			System.out.println(str+" ");
		}
		System.out.println();
		System.out.println("======================================================");
		//Collections.sort(list) : 매개변수로 전달받은 List객체의 요소를 정렬하는 메소드, 배열처럼 정렬하고 싶을때 collection사용
		//Collections클래스: List 객체의 요소를 관리하기 위한 기능의 메소드를 제공하는 클래스
		Collections.sort(list);//오름차순 설명
		System.out.println("list = " +list);
		System.out.println("======================================================");
		//list.clear() : list 객체에 저장된 모든 요소를 삭제하여 초기화 처리하는 메소드
		list.clear();
		//list.isEmpty() : list객체에 요소가 저장되어 있는 경우 false 반환, 저장된 요소가 없는 경우 true 반환 
		if(list.isEmpty()) {
			System.out.println("list 객체에 저장된 요소가 하나도 없습니다");//댓글이 없습니다
		}
		System.out.println("======================================================");
		//Arrays.asList(E... element) : 0개 이상의 요소값(객체)이 저장된 List 객체를 생성하여 반환하는 메소드
		List<Integer> numberList =Arrays.asList(10,20,30,40,50);
		System.out.println("list = " +numberList);
		System.out.println("======================================================");
		
	}
}
