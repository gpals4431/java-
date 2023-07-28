package xyz.itwill05.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

//Ŭ���� �ۼ��� �ʿ��� �޼ҵ带 �ڵ����� �������ִ� Lombok ���̺귯���� ����ϴ� ���
//1.Lombok ���̺귯���� ������Ʈ ���� ó�� - ���̺� ��� : pom.xml
//2.��Ŭ����(IDE)�� �����ϰ� �ܼ�(��� ������Ʈ - cmd)�� ������ �������� ������ �� Lombok ���̺귯����
//����� ���� �����(Local Repository - ����� ������ .m2 ����)�� ���̺귯�� ������ �̵�
//3.�ֿܼ��� Jar ���α׷� �����Ͽ� Lombok ���̺귯���� ��Ŭ������ ����� �� �ֵ��� ����
// => Jar ���α׷� ���� ��� : java -jar lombok-1.18.28.jar
// => Ž���⿡�� ���� ������� ���̺귯�� ������ �̵��Ͽ� Jar ������ ����Ŭ���Ͽ� ���� ����
//4.Jar ���α׷��� �����Ͽ� ������ ��ġâ(Installer)���� Lombok ���̺귯���� ����� ��Ŭ������ �����Ͽ� Lombok ��ġ 
// => ��Ŭ������ �ڵ����� ã�� �� ���� ��� ��Ŭ������ ��ġ�� ������ �����Ͽ� Lombok ��ġ
//5.��Ŭ������ �����Ͽ� Ŭ������ �ۼ��� �� Lombok ���̺귯���� �����ϴ� ������̼� ����Ͽ� Ȯ��
// => @Setter, @Getter, @ToString, @Date, @AllArgsConstructor, @RequiredArgsConstructor ��
// => ��Ŭ������ ������� �ʴ� ��� ��Ŭ���� ��ġ ������ �̵��Ͽ� eclipse.ini ���� ���� 
// => eclipse.ini ���Ͽ��� javaagent �Ӽ��� lombok ��θ� �����ο��� ����η� ���� -javaagent:lmbok.jar    
//@NoArgsConstructor : �Ű������� ���� �����ڸ� �ڵ� �����Ͽ� �����ϴ� ������̼�
//@AllArgsConstructor : ��� �ʵ忡 �ʱⰪ�� ������ �� �ִ� �Ű������� �ִ� �����ڸ� �ڵ� ����
//=> ��� �ʵ忡 �ʱⰪ�� ������ �� �ִ� �Ű������� �ִ� ������ ����
//@RequiredArgsConstructor : Ư�� �ʵ忡 �ʱⰪ�� ������ �� �ִ� �Ű������� �ִ� �����ڸ� �ڵ� ����
//=> final �����ڸ� ����Ͽ� ����� �ʵ忡 �ʱⰪ ����
//=> @NoArgsConstructor ������̼ǰ� ���� ��� �Ұ���
//@Setter : Ŭ������ ����� ��� �ʵ忡 ���� Setter �޼ҵ带 �ڵ� �����Ͽ� �����ϴ� ������̼�
//=> �ʵ忡 @Setter ������̼��� ����ϸ� �ʵ忡 ���� Setter �޼ҵ带 �ڵ� �����Ͽ� ����
//@Getter : Ŭ������ ����� ��� �ʵ忡 ���� Getter �޼ҵ带 �ڵ� �����Ͽ� �����ϴ� ������̼�
//=> �ʵ忡 @Getter ������̼��� ����ϸ� �ʵ忡 ���� Getter �޼ҵ带 �ڵ� �����Ͽ� ����
//@ToString : Ŭ������ toString �޼ҵ带 �ڵ� �����Ͽ� �����ϴ� ������̼�
//=> Ŭ������ ����� ��� �ʵ��� ���� ���ڿ��� ��ȯ�ϴ� ����� ����
//@Data : �⺻ ������, Setter, Getter, toString, equals, haseCode ���� �����ϴ� ������̼�
//@Builder : Ŭ������ builder Ŭ������ �ڵ� �����Ͽ� �����ϴ� ������̼�
//=>builder Ŭ���� : ��ü ������ ��ü �ʵ忡 �ʿ��� ���� �����ϱ� ���� ����� �����ϴ� Ŭ����
//=> �����ں��� �������� ������ �ʵ��� ������ ������� �ʱ�ȭ �۾� �� 
//�����ڿ� ���� �ʵ��� ���� �˾Ƽ� ó�� ���� ������� �޼ҵ常 ȣ���ϸ�� -> �ʱ�ȭ ó���� ����
// �Ű������� ����� �������� @builder ������̼��� ����ϸ� ������ �Ű������� �ʱ�ȭ ó���ϱ� ����
//�ʵ忡�� ���� ������ �� �ִ� �޼ҵ� ���� - test ���α׷� ���鶧 ���� ���
//@Slf4j : �α� �̺�Ʈ�� �߻��ϴ� logger ��ü�� ����� �ʵ�(log)�� �ڵ� �����Ͽ� �����ϴ� ������̼�

//������̼� ���� �߿�X
@AllArgsConstructor
@Data
@Builder
public class Member {
	private String id;
	private String name;
	private String email;
	
	
}








