package xyz.itwill07.aop;

public class ExecutionTimeBean {
	public void one() {
		//System.currentTimeMillis() : �ý����� ���糯¥�� �ð������� Ÿ�ӽ������� ��ȯ�ϴ� �޼ҵ�
		//Ÿ�ӽ�����(TimeStamp) : ��¥�� �ð��� ���������� ��ȯ�� �� - ��¥�� �ð��� ���� ���� ����
		//long startTime=System.currentTimeMillis();
		
		long count = 0;
		for (long i = 1; i <= 10000000000L; i++) {
			count++;
		}
		System.out.println("count =" + count);

		/*
		 * long endTime=System.currentTimeMillis();
		 * System.out.println("ExecutionTimeBean Ŭ������ one() ����ð� ="+(endTime-startTime)+
		 * "ms");
		 */
	}

	public void two() {
		//long startTime=System.currentTimeMillis();
		long count = 0;
		for (long i = 1; i <= 20000000000L; i++) {
			count++;
		}
		System.out.println("count =" + count);
		/*
		 * long endTime=System.currentTimeMillis();
		 * System.out.println("ExecutionTimeBean Ŭ������ one() ����ð� ="+(endTime-startTime)+
		 * "ms");
		 */
	}
}
