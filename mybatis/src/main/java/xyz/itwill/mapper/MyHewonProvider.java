package xyz.itwill.mapper;

import org.apache.ibatis.jdbc.SQL;

//Provider Ŭ����(SQL Builder Ŭ����) : SQL ����� �����Ͽ� ��ȯ�ϴ� �޼ҵ尡 ����� Ŭ����
public class MyHewonProvider {
	//Java ������� ���� SQL ����� �����Ͽ� SQL ����� ��ȯ�ϴ� �޼ҵ�
	public String selectDynamicName(String name) {
		//SQL ��ü : SQL ��� �ۼ��� �ʿ��� �޼ҵ带 �̿��Ͽ� SQL ����� �����ϱ� ���� ��ü
		//SQL.toString() : SQL ��ü�� ����� SQL ����� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
		return new SQL() {{
			SELECT("hewon_id, hewon_name, hewon_phone");
			SELECT("hewon_email, hewon_status");
			FROM("myhewon");
			if(name != null && !name.equals("")) {
				WHERE("hewon_name = #{name}");
			}
			ORDER_BY("hewon_id");
		}}.toString();
	}
}