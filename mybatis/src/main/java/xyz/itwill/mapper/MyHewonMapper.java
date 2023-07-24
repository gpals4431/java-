package xyz.itwill.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import xyz.itwill.dto.MyHewon;

public interface MyHewonMapper {
	int insertHewon(MyHewon hewon);
	List<MyHewon> selectHewonList();
	List<MyHewon> selectDiscriminatorHewonList();
	List<MyHewon> selectStatusHewonList(int status);
	String selectBeanHewonId(MyHewon hewon);
	//HashMap Ŭ����(Map �������̽�)�� �Ű������� ������ ��� ���׸��� ��Ű�� [String] Ŭ������
	//�����ϰ� �ʰ��� [Object] Ŭ������ �����Ͽ� ���
	String selectMapHewonId(Map<String, Object> map);
	int insertMapHewon(Map<String, Object> map);
	List<Map<String, Object>> selectMapHewonList();
	//@Param : �߻�޼ҵ��� �Ű������� ����� ���� XML ����� ���� ������ ������Ʈ���� �����Ͽ�
	//SQL ��ɿ��� ����� �� �ֵ��� �����ϴ� ������̼�
	//value �Ӽ� : �Ű������� ����� ���� XML ����� ���� ������ ������Ʈ�� ��ϵ� SQL 
	//��ɿ��� ����� �� �ִ� �ĺ��ڸ� �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	String selectParamHewonId(@Param(value = "name") String name,@Param("email") String email);
	List<MyHewon> selectSearchHewonList(Map<String, Object> map);
	List<MyHewon> selectNameHewonList(String name);
	List<MyHewon> selectDynamicNameHewonList(String name);
	List<MyHewon> selectDynamicHewonList(Map<String, Object> map);
	int updateHewon(MyHewon hewon);
	int updateDynamicHewon(MyHewon hewon); 
	List<MyHewon> selectMultiDynamicHewonList(List<String> idList);
}