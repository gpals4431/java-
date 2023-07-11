package oop;

public class StudentApp {
	public static void main(String[] args) {
	/*	Student student1 = new Student(1000, "홍길동" , 90, 90);
		Student student2 = new Student(1000, "임꺽정" , 94, 98);
		Student student3 = new Student(1000, "전우치" , 91, 80);
		Student student4 = new Student(1000, "일지매" , 76, 82);
		Student student5 = new Student(1000, "장길산" , 84, 86);
		
		//student1.calcTot(); >> 은닉화처리되어서 에러발생(not visible)
		
		
	 	student1.calcTot(); 
		student2.calcTot(); 
		student3.calcTot();
		student4.calcTot(); 
		student5.calcTot();
		
		student1.display();
		student2.display();
		student3.display();
		student4.display();
		student5.display();
		System.out.println("==========================");
		student1.setKor(100);//값이 중간에 바꼇을때 수정하고자 set메소드 사용
		//student1.calcTot();
		student1.display();
	}
	
	 * //객체를 저장할 수 있는 참조요소가 5개인 배열 생성 // => 배열의 참조요소에는 기본적으로 [null]이 초기값으로 저장
	 * Student[] students =new Student[5];//객체가 아니고 객체의 메모리주소를 저장할 요소를 여러개 만들어준것
	 * 
	 * students[0] = new Student(1000, "홍길동" , 90, 90);//실제 객체
	 * students[1] = new Student(1000, "임꺽정" , 94, 98);
	 * //students[2] = new Student(1000, "전우치" , 91,80); 
	 * students[3] = new Student(1000, "일지매" , 76, 82); 
	 * students[4] = new Student(1000, "장길산" , 84, 86); 
	 * // 하나를 빼먹으면 객체x >> 참조변수에 [null]이 저장된 상태에서 객체의
	 * 메소드를 호출할 경우, NullPointerException 발생 - 예외가 발생된 지점에서 프로그램 강제종료
	 * 
	 * //반복문을 사용하여 배열의 참조요소에 저장된 객체의 메소드를 일괄적으로 호출하여 처리 for(int i=0;
	 * i<students.length; i++) { //참조변수에 [null]이 저장되어 있지않은 경우 메소드 호출 // =>
	 * NullPointerException를 방지할 수 있는 선택문 if(students[i]!=null) {
	 * students[i].display();
	 *  }
	 * System.out.println("==========================");
	 * 
	 * }
	 */
		
		Student[] students = 
			{new Student(1000, "홍길동" , 90, 90),
				new Student(1000, "임꺽정" , 94, 98),
				new Student(1000, "전우치" , 91, 80),
				new Student(1000, "일지매" , 76, 82),
				new Student(1000, "장길산" , 84, 86)
				};
		
		int total=0;//모든 학생들의 점수합계를 저장하기 위한 변수
		//배열의 참조요소에 저장된 객체의 메모리 주소를 차례대로 제공받아 변수에 저장하여
		//처리하는 향상된 for 구문을 사용하여 일괄처리
		for(Student student : students) {
			student.display();
			
			//정적 필드는 클래스를 이용하여 접근해 사용 가능 - public 접근 제한자로 설정된 경우
			// => 객체로 접근 가능하지만 경고 발생
			//Student.total+=student.getTot();//학생 총점을 반환받아 총합계 변수에 누적하여 저장
			//정적 필드가 private접근 제한자로 설정된 경우 메소드를 이용하여 접근 가능
			// => 정적 메소드는 객체가 아닌 클래스를 이용하여 호출 가능
			Student.setTotal(Student.getTotal()+student.getTot());
			
		}
		System.out.println("===================================");
		//모든 학생들의 점수의 합계를 계산하여 출력
		System.out.println("총합계 = "+Student.getTotal());
		System.out.println("===================================");
	}
}
	

