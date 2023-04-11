package inheritance;

//사람에 대한 번호와 이름을 저장하기 위한 클래스
// => 학원, 강사, 직원에 대한 공통적인 속성과 행위를 표현하기 위한 클래스
// => 학원 인적자원 관련 클래스가 반드시 상속받아야 되는 부모 클래스
public class AcademyPerson {
	private int num;
	private String name;
	
	public AcademyPerson() {
		// TODO Auto-generated constructor stub
	}

	public AcademyPerson(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNuml() {
		return num;
	}

	public void setNuml(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void  display() {
		System.out.println("번호 ="+num);
		System.out.println("이름 ="+name);
		
	}
	
	
}
