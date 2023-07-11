package inheritance;

//정규직 사원 정보(사원번호, 사원이름, 연봉)를 저장하기 위한 클래스 
// => Employee클래스 상속받아 작성

public class EmployeeRegular extends Employee{
	private int anuualSalary;
	
	public EmployeeRegular() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeRegular(int empNo, String empName, int anuualSalary) {
		super(empNo, empName);
		this.anuualSalary = anuualSalary;
	}

	public int getAnuualSalary() {
		return anuualSalary;
	}

	public void setAnuualSalary(int anuualSalary) {
		this.anuualSalary = anuualSalary;
	}
	
	//급여를 계산해 반환하는 메소드
	public int computeSalary() {
		return anuualSalary/12;
		
	}
	
	@Override
	public int computePay() {
		// TODO Auto-generated method stub
		return anuualSalary/12;
	}
	/*@Override 오버라이드 선언시 에러 발생
	public int computeIncentive() {
		// TODO Auto-generated method stub
		return 1000000000;
	}
	*/
}
