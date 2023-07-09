/*04 20 6*/
package xyz.itwill.util;

//학번, 이름을 저장하기 위한 클래스
// >> VO(Value Object)클래스 : 값 저장 목적의 객체를 생성하기 위한 클래스
public class Student {
	private int num;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//object 클래스(부모)의 toString()메소드를 오버라이드 선언
	// >> VO클래스의 필드값을 반환받아 확인하기 위해 사용
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "학번 ="+num+ ", 이름 = "+name;
		
	}
	
}
