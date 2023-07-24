package xyz.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xyz.itwill.dto.MyMember;

//mybatis �����ӿ�ũ������ �������̽��� �̿��Ͽ� ���� ������ �ۼ� ����
// => �߻�޼ҵ忡 ���� ������̼�(Mapper Annotation)�� ����Ͽ� SQL ����� �ۼ��Ͽ� ���
public interface MyMemberInterfaceMapper {
	//@Insert : �߻�޼ҵ忡 INSERT ����� ����ϱ� ���� ������̼�
	//value �Ӽ� : �߻�޼ҵ忡 ��ϵ� SQL ����� �Ӽ������� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Insert(value = "insert into mymember values(#{id}, #{name} , #{phone} , #{email})")
	//�߻�޼ҵ��� �Ű��������� SQL ��� �ۼ��� �ʿ��� ��ü(��)�� ���޹ޱ� ���� �����ϸ�
	//�߻�޼ҵ� ��ȯ���� �������� ��ü(��)�� �����ޱ� ���� Java �ڷ����� ����
	int insertMember(MyMember member);
	
	//@Update : �߻�޼ҵ忡 UPDATE ����� ����ϱ� ���� ������̼�
	@Update("update mymember set name=#{name}, phone=#{phone}, email=#{email} where id=#{id}")
	int updateMember(MyMember member);
	
	//@Delete : �߻�޼ҵ忡 DELETE ����� ����ϱ� ���� ������̼�
	@Delete("delete from mymember where id=#{id}")
	int deleteMember(String id);
	
	//@Select : �߻�޼ҵ忡 SELECT ����� ����ϱ� ���� ������̼�
	@Select("select id, name, phone, email from mymember where id=#{id}")
	MyMember selectMember(String id);
	
	@Select("select id, name, phone, email from mymember order by id")
	List<MyMember> selectMemberList();
}