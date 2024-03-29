package inheritance;

//강사 정보(강사번호, 강사명, 강의과목)를 저장하기 위한 클래스
//=> 강사번호와 이름 관련 속성과 행위는 AcademyPerson 클래스를 상속받아 작성
public class AcademyInstructor extends AcademyPerson {
	private String subject;
	
	public AcademyInstructor() {
		// TODO Auto-generated constructor stub
	}

	public AcademyInstructor(int num, String name, String subject) {
		super(num, name);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("강사번호 ="+getNuml());
		System.out.println("강사명 ="+getName());
		System.out.println("강의과목 ="+subject);
	}
}

