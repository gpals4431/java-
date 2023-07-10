package inheritance;

//학생 정보(학생번호, 이름, 수강과목)를 저장하기 위한 클래스
// => 학생번호와 이름 관련 속성과 행위는 AcademyPerson 클래스를 상속받아 작성
public class AcademyStudent extends AcademyPerson{
	private String course;
	
	public AcademyStudent() {
		// TODO Auto-generated constructor stub
	}

	public AcademyStudent(int num, String name, String course) {
		super(num, name);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("학생번호 ="+getNuml());
		System.out.println("수강과목 ="+getName());
		System.out.println("수강과목 ="+course);
	}
}
