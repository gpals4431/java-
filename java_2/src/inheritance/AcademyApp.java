package inheritance;

//학원 인적자원(학생, 강사, 직원) 관리 프로그램
public class AcademyApp {
	public static void main(String[] args) {
	//정보를 저장할 메모리 공간을 만들어줘야함 >> 배열
		
		/* 관리하기가 어려움
		//학생 정보(AcademyStudent객체)를 저장하기 위한 요소들이 존재하는 배열을 선언
		AcademyStudent[] students = new AcademyStudent[300]; //=참조변수가 300개, 학생을 저장할 공간을 300개 만든것과 동일
		
		//강사 정보(AcademyInstructor 객체)를 저장하기 위한 요소들이 존재하는 배열을 선언
		AcademyInstructor[] instructors = new AcademyInstructor[50]; 
		
		//직원 정보(AcademyStaff 객체)를 저장하기 위한 요소들이 존재하는 배열을 선언
		AcademyStaff[] staffs = new AcademyStaff[100]; 
		*/
		
		
		//사람 정보(AcademyPerson 객체)를 저장하기 위한 요소들이 존재하는 배열을 선언
		// => 배열요소에 학생정보(AcademyStudent 객체), 강사정보(AcademyInstructor 객체), 직원정보(AcademyStaff 객체) 저장 가능
		// => 부모클래스의 참조변수에는 자식 클래스의 생성자로 객체 생성하여 저장 가능
		AcademyPerson[] persons = new AcademyPerson[5];//AcademyPerson = 부모는 모든 자식들 저장 가능
		
		//자식클래스의 생성자로 객체를 생성하면 부모클래스의 객체를 먼저 생성한 후 
		//자식 클래스의 객체를 생성한다.
		// => 배열요소에는 부모클래스의 객체가 저장되어 부모클래스 메소드 호출
		// => 객체 형변환을 이용하면 배열 요소를 자식클래스의 객체를 일시적으로 저장하여 자식클래스의 메소드 호출 가능
		persons[0]=new AcademyStudent(1000, "홍길동", "웹개발자 과정");
		persons[1]=new AcademyInstructor(2000, "임꺽정", "Java");
		persons[2]=new AcademyStaff(3000, "전우치", "운영관리");
		persons[3]=new AcademyStudent(4000, "일지매", "웹디자인 과정");
		persons[4]=new AcademyStaff(5000, "장길산", "경영회계");
		
		
		//배열 요소에 저장된 객체를 하나씩 제공받아 참조변수에 저장하여 일괄처리
		for (AcademyPerson person : persons) {
			//★★★중요★★★오버라이드 선언되지않은 자식클래스의 메소드를 호출하기 위해서는 
			//명시적 객체 형변환을 이용하여 참조변수의 자식클래스의 객체 일시적으로 저장하여 자식 클래스의 메소드 호출 
			//문제점) 상속관계가 아닌 클래스로 명시적 객체 형변환 할 경우 ClassCastException 발생
			//해결방법) 참조변수로 객체 형변환 가능한 클래스를 확인한 후 명시적 객체 형변환 이용
			// => instanceof 연산자 사용하여 참조변수의 객체 형변환이 가능한 클래스 검사 >> 자식이 많으면 자식이 누구냐 물어봐줘야함
			//형식) 참조변수 instanceof 클래스 
     		// => 참조변수로 참조 가능한 클래스을 확인하여 [false] 또는 [true]를 제공하는 연산자
			
			if(person instanceof AcademyStudent) {
				System.out.println(((AcademyStudent)person).getCourse()+"의 학생정보 >>"); //>>예외발생
			} else if(person instanceof AcademyInstructor) {
				System.out.println(((AcademyInstructor)person).getSubject()+"의 강사정보 >>");
			} else if(person instanceof AcademyStaff) {
				System.out.println(((AcademyStaff)person).getDepart()+"의 직원정보 >>");
			}
			//오버라이드 선언된 자식클래스의 메소드는 묵시적 객체 형변환에 의해 부모클래스의 메소드를 호출하지 않고 자식클래스의 메소드 호출 
			
			//참조변수에 저장된 자식클래스의 객체에 의해 자식클래스의 메소드가 선택호출 (다른 클래스 메소드 호출 가능)
			// => 오버라이드에 의한 다형성 : 객체 형변환에 의해 참조변수에 저장된 객체에 따라 다른 자식 클래스의 메소드 선택 호출
			person.display();//오버라이드에 의한 묵시적 객체 형변환 발생 
			System.out.println("=====================================================");
			
			
			
			
			
		}
	}
}
