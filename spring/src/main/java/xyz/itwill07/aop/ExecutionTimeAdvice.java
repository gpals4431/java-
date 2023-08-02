package xyz.itwill07.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExecutionTimeAdvice {
	/*
	 * //Ÿ�ٸ޼ҵ��� ����� ����Ǵ� ó���ð��� ����Ͽ� ����ϱ� ���� �޼ҵ� - Around Advice Method public Object
	 * timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable { long
	 * startTime=System.currentTimeMillis();
	 * 
	 * //Ÿ�ٸ޼ҵ��� ��� ���� - Ÿ�ٸ޼ҵ� ȣ�� Object returnValue =joinPoint.proceed();
	 * 
	 * long endTime=System.currentTimeMillis();
	 * 
	 * String className=joinPoint.getTarget().getClass().getSimpleName(); String
	 * methodName=joinPoint.getSignature().getName();
	 * 
	 * System.out.println(className+"Ŭ������"+methodName+"()�޼ҵ� ����ð� ="
	 * +(endTime-startTime)+"ms"); return returnValue; }
	 */
	
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�ٸ޼ҵ��� ��� �������� ���۵� ��� �ۼ�
		//StopWatch ��ü ; �ð��� �����ϱ� ���� ����� �����ϱ� ���� ��ü
		StopWatch stopWatch=new StopWatch();
		
		//stopWatch.start(): �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.start();
		
		//Ÿ�ٸ޼ҵ��� ��� ���� - Ÿ�ٸ޼ҵ� ȣ��
		Object returnValue =joinPoint.proceed();
		
		//stopWatch.stop(): �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.stop();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		//stopWatch.getTotalTimeMillis(): �ð� ���� ����� ms ������ ��ȯ�ϴ� �޼ҵ�
		System.out.println(className+"Ŭ������"+methodName+"()�޼ҵ� ����ð� ="
				+stopWatch.getTotalTimeMillis()+"ms");
		return returnValue;
	}
}
