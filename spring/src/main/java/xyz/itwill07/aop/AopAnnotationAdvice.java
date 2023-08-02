
package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
//@Aspect : �ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ带 �����Ͽ� �����ϱ� ���� ����� �����ϴ� ������̼�
// => Spring Bean Configuration File�� aspect ������Ʈ�� ������ ��� ����
@Aspect
public class AopAnnotationAdvice {
	//@Pointcut : Ÿ�ٸ޼ҵ带 �����ϱ� ���� ������̼�
	// => �޼ҵ带 ȣ���Ͽ� Pointcut ǥ�������� ������ Ÿ�ٸ޼ҵ带 �����޾� �޾� ���
	// => Spring Bean Configuration File�� pointcut ������Ʈ�� ������ ��� ����
	//value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� Pointcut ǥ������ �Ӽ������� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Pointcut("within(xyz.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}
	
	//@Before : Ÿ�ٸ޼ҵ��� �ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼� 
	// => Spring Bean Configuration File�� before ������Ʈ�� ������ ��� ����
	//value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� Pointcut ǥ������ �Ӽ������� ����
	// => @Pointcut ������̼��� ����� �޼ҵ� ȣ���Ͽ� Pointcut ǥ������ ���� �޾� ��� ����
	// => �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	//@Before("within(xyz.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		log.info("[before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	//@Before : Ÿ�ٸ޼ҵ��� �ٽɰ����ڵ� ���� �Ŀ� ���ܿ� ������� ������ ����� Ⱦ�ܰ����ڵ带 �����ϱ����� ������̼�
	@After("aopPointCut()")
	public void afterLog() {
		log.info("[after] �ٽɰ����ڵ� ���� �Ŀ� ���ܿ� ������� ������ ����� Ⱦ�ܰ����ڵ�");	
	}
	
	//=>returning �Ӽ�: Ÿ�ٸ޼ҵ��� ��ȯ���� ���޹޾� �����ϱ� ���� �Ű������� �̸��� �Ӽ����� ����
	@AfterReturning(value="aopPointCut()", returning ="object")
	public void afterReturningLog(Object object) {
		log.info("[afterReturning] �ٽɰ����ڵ� ���������� ���� �Ŀ� ����� Ⱦ�ܰ����ڵ�");	
		
	}
	
	//throwing �Ӽ� :
	@AfterThrowing(value="aopPointCut()", throwing="exception")
	public void afterThrowingLog() {
		log.info("[afterThrowing] �ٽɰ����ڵ� ����� ���ܰ� �߻��� �� ����� Ⱦ�ܰ����ڵ�");	
		
	}
	
	@Around("aopPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("[before] �ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		Object result=joinPoint.proceed();
		log.info("[after] �ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");	
		return result;
	}
}
