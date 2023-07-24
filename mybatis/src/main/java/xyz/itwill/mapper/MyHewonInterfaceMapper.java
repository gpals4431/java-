package xyz.itwill.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import xyz.itwill.dto.MyHewon;

//mybatis �����ӿ�ũ�� Interface ����� ���� ���ϸ� ����Ͽ� ���� ��� ����
// => �������̽��� �߻�޼ҵ忡 ���� ������̼��� ����Ͽ� SQL ��� ���
public interface MyHewonInterfaceMapper {
	//�߻�޼ҵ忡 ��ϵ� SELECT ����� �⺻������ �˻����� �ڵ� �����Ͽ� ��ü�� ����
	// => �ڵ� ���� ����� ����Ͽ� �˻����� ��ü�� �����ϱ� ���� �˻����� �÷���� ��ü��
	//������ Ŭ������ �ʵ���� �����ϰ� �ۼ�
	// => �˻����� �÷���� Ŭ������ �ʵ���� �ϳ��� ���� ���� ��� ��ü ��� NULL ����
	//@Results : �˻����� ��ü�� �����Ͽ� �����ϱ� ���� ���� ������ �����ϴ� ������̼�
	// => XML ����� ���� ���Ͽ��� resultMap ������Ʈ�� ������ ��� ����
	//value �Ӽ� : �˻����� �÷����� ��ü �ʵ忡 �����ϱ� ���� ���������� �����ϴ� Result
	//������̼ǿ� ������ ����� �迭�� �Ӽ��� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Results(value = {
		//@Result : �˻����� �÷����� ��ü �ʵ忡 �����ϱ� ���� ������ �����ϴ� ������̼�
		// => XML ����� ���� ���Ͽ��� id ������Ʈ(result ������Ʈ)�� ������ ��� ����
		//column �Ӽ� : �˻����� �÷���(�÷���)�� �Ӽ������� ����
		//property �Ӽ� : �˻����� �÷����� ����� ��ü�� �ʵ���� �Ӽ������� ����	
		@Result(column = "hewon_id", property = "id")	
		, @Result(column = "hewon_name", property = "name")	
		, @Result(column = "hewon_phone", property = "phone")	
		, @Result(column = "hewon_email", property = "email")	
		, @Result(column = "hewon_status", property = "status")	
	})
	@Select(value = "select * from myhewon order by hewon_id")
	List<MyHewon> selectHewonList();

	//@Results ������̼��� ���� ������ �ٸ� �߻�޼ҵ忡�� ���� �Ұ��� - ���������� ȿ���� ����
	@Results(value = {
		@Result(column = "hewon_id", property = "id")	
		, @Result(column = "hewon_name", property = "name")	
		, @Result(column = "hewon_phone", property = "phone")	
		, @Result(column = "hewon_email", property = "email")	
		, @Result(column = "hewon_status", property = "status")	
	})
	@Select("select * from myhewon where hewon_name=#{name} order by hewon_id")
	List<MyHewon> selectNameHewonList(String name);

	/*
	@Results(value = {
		@Result(column = "hewon_id", property = "id")	
		, @Result(column = "hewon_name", property = "name")	
		, @Result(column = "hewon_phone", property = "phone")	
		, @Result(column = "hewon_email", property = "email")	
		, @Result(column = "hewon_status", property = "status")	
	})
	//@SelectProvider : SQL ����� �����Ͽ� ��ȯ�ϴ� Ŭ����(SQL Builder Ŭ����)�� �޼ҵ带  
	//ȣ���Ͽ� SELECT ����� ��ȯ�޾� ����ϴ� ������̼�
	// => Interface ����� ���� ���Ͽ��� ���� SQL ����� �����ϱ� ���� ����ϴ� ������̼�
	//SQL Builder Ŭ���� : SQL ��ü�� �޼ҵ带 ȣ���Ͽ� SQL ����� �ۼ��ϰ� SQL ��ü�� �����
	//SQL ����� ��ȯ�ϴ� ����� �����ϴ� Ŭ����
	//type �Ӽ� : SQL Builder Ŭ����(Class ��ü)�� �Ӽ������� ����
	//method �Ӽ� : SQL Builder Ŭ������ SQL ����� �����ϴ� ��ȯ�ϴ� �޼ҵ带 �Ӽ������� ����
	@SelectProvider(type = MyHewonProvider.class, method = "selectDynamicName")
	List<MyHewon> selectDynamicHewonList(String name);
	*/
	
	@Results(value = {
		@Result(column = "hewon_id", property = "id")	
		, @Result(column = "hewon_name", property = "name")	
		, @Result(column = "hewon_phone", property = "phone")	
		, @Result(column = "hewon_email", property = "email")	
		, @Result(column = "hewon_status", property = "status")	
	})
	//@SELECT ������̼��� value �Ӽ������� script ������Ʈ�� ����ϸ� SQL ��� �ۼ��� Interface
	//���� ���Ͽ��� ���� SQL ���� ������Ʈ ��� ����
	// => value �Ӽ������� �迭�� �����Ͽ� SQL ����� ���������� �ۼ� ���� 
	@Select({"<script>select hewon_id, hewon_name, hewon_phone, hewon_email, hewon_status from myhewon"
			,"<if test=\"name != null and name != ''\">where hewon_name = #{name}</if>" 
			,"order by hewon_id</script>"})
	List<MyHewon> selectDynamicHewonList(String name);
}