//05-16 -7

package xyz.itwill.student;

//DTO(Date Transfer Object)클래스 : DAO 클래스의 메소드에 필요한 정보(값)를 매개변수로 전달하거나
//또는 메소드에 실행결과를 저장하여 반환하기 위한 클래스 - db연동 안했을 경우 VO(Value Object=값 저장 목표로 만든 클래스) 클래스
// >> 테이블의 컬럼과 1:1로 매핑되는 필드 선언 - Getter & Setter 
// >> 필드의 이름은 컬럼의 이름과 동일하게 작성하는 것을 권장

/*
 이름       널?       유형            
-------- -------- ------------- 
NO       NOT NULL NUMBER(4)     
NAME              VARCHAR2(50)  
PHONE             VARCHAR2(20)  
ADDRESS           VARCHAR2(100) 
BIRTHDAY          DATE 
 */

//Student 테이블에 저장된 하나의 행(학생 정보)을 저장하여 전달하기 위한 DTO 클래스 - 컬럼값 저장 필드 선언
public class StudentDTO {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(int no, String name, String phone, String address, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return no+"\t"+name+"\t"+phone+"\t"+address+"\t"+birthday+"\t";
	}
	
	
}
