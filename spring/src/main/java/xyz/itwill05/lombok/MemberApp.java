package xyz.itwill05.lombok;

public class MemberApp {
	public static void main(String[] args) {
		Member member1=new Member("abc123", "ȫ�浿","abc@itwill.xyz");
		
		System.out.println("id ="+member1.getId());
		System.out.println("name ="+member1.getName());
		System.out.println("email ="+member1.getEmail());
		System.out.println("================================================");
		//Member Ŭ������ ������ ���������� ����� ��� Member Ŭ������ toString()�޼ҵ� ȣ��
		System.out.println(member1);
		System.out.println("================================================");
		//Ŭ������.builder() : Ŭ���� ���ο� �ۼ��� Builder Ŭ������ ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ� 
		//=> Builder ��ü�� �ʵ���� ���� �̸��� �޼ҵ带 ȣ���Ͽ� �ʵ尪 ����
		//=> Builder.build() : Ŭ������ ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		Member member2 = Member.builder()
				.id("xyz789")
				.name("�Ӳ���")
				.email("xyz@itwill.xyz")
				.build();
		System.out.println(member2);
		System.out.println("================================================");
	}
}