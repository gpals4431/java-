package xyz.itwill07.aop;

import java.util.List;

//�ٽɰ��ɸ��(Core Concern Module) : �ٽɰ����ڵ�� �ۼ��� �޼ҵ�� ����� Ŭ����
//=> �ٽɰ����ڵ� : ������ ó���� ���� �ʼ����� ��� = ���x, ������ ó���� �ʿ��� ��ɸ� �ۼ� 
public class HewonDAOImpl implements HewonDAO{

	@Override
	public int insertHewon(Hewon hewon) {
		System.out.println("*** HewonDAOImpl Ŭ������ insertHewon() �޼ҵ� ȣ�� *** ");
		return 0;
	}

	@Override
	public Hewon selectHewon(int num) {
		System.out.println("*** HewonDAOImpl Ŭ������ selectHewon() �޼ҵ� ȣ�� *** ");
		return null;
	}

	@Override
	public List<Hewon> selectHewonList() {
		System.out.println("*** HewonDAOImpl Ŭ������ selectHewonList() �޼ҵ� ȣ�� *** ");
		return null;
	}
	
}
