package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

//DTO Ŭ���� : DAO Ŭ������ �޼ҵ忡�� ����ϱ� ���� ���� ǥ���ϱ� ���� Ŭ����
// => ���̺��� Java Ŭ������ ǥ���Ͽ� ��ü�� �����Ͽ� ����ϱ� ���� �ۼ�

/*���� ������̼� ����ϸ� �̾ȿ� builderŬ������ ������ 
Student Ŭ������ Studentbilder Ŭ������ Student ��ü�� �����Ͽ� ��ȯ�޾� �����ϴ� ���� ������
studentbiilder() �޼ҵ带 ȣ���� ���� ��ü�� �����޾� �ʵ� ���� �޼ҵ�� �ʵ尪�� �����Ͽ� 
build() �޼ҵ�� student ��ü�� ��ȯ�޾� ���*/
@Data
@Builder
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}