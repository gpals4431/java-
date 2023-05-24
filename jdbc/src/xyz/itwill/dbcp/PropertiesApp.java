//05-16 -2
package xyz.itwill.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
properties 파일 : 프로그램 실행에 필요한 값을 제공하기 위한 텍스트 파일 - 확장자 : ~.properties 
> 프로그램 실행한 값이 변할 가능성이 있어서 변수에 직접 저장하지않고 파일에 저장해 실행시마다 읽어드려 사용
 >> 프로그램을 변경하지 않고 properties 파일의 내용을 변경하여 프로그램 실행 결과 변경 가능
 >> 프로그램의 유지보수 효율성 증가
 >> properties 파일에서 제공되는 값은 문자열만 가능
 >> properties 파일에서는 영문자, 숫자, 일부 특수문자를 제외한 나머지 문자는 유니코드로 변환되어 처리
*/

//user.properties 파일에 저장된 값을 얻어와 출력하는 프로그램 작성
public class PropertiesApp {
	public PropertiesApp()throws IOException {
		//properties 파일을 읽기 위한 입력스트림 생성 >> properties 경로를 제공받아 FileInputStream 클래스로 객체 생성
		//FileInputStream  in = new FileInputStream("src/xyz/itwill/dbcp/user.properties");//>>다른사람은 경로가 다를 수 있음 > 프로그램 배포시 파일 경로에 문제 발생 가능
		
		//object.getclass() : 현재 실행중인 클래스에 대한 Class 객체(Clazz)를 제공받는 방법
		//Class.getClassLoader(): 클래스를 읽어 메모리에 저장된 ClassLoader 객체를 반환하는 메소드
		//ClassLoader.getResourceAsStream(String name) :  리소스 파일에 대한 입력 스트림을 생성하여 반환하는 메소드 
		InputStream in = getClass().getClassLoader().getResourceAsStream("src/xyz/itwill/dbcp/user.properties");//>> 배포할때는 클래스로만 배포할 수 있음
		
		//Properties 객체 생성 - 다수의 엔트리(Entry= Key와 Value) 저장
		// >> Properties 클래스는 Map 인터페이스의 자식클래스 : 이름과 값이 쌍으로 존재함
		// >> Properties 파일의 이름(Name=Key)과 값(Value)을 하나의 엔트리(Entry)로 저장하기 위한 객체
		
		Properties properties = new Properties();//다수 엔트리 저장할 수 있는 객체
		
		//properties.load(inputStream in) : 입력스트림으로 properties 파일을 제공받아 파일에 저장된 이름과 값으로 properties객체에 엔트리를 추가하는 메소드
		properties.load(in);//입력 스트림을 이용해 properties 파일이 가진 이름과 값 =한줄 의 정보를 가져와 3개의 엔트리 자동 추가
		
		//properties.get(String Key) : properties 객체에 저장된 엔트리에서 맵키(MapKey)를 전달받아 맵값(Map Value)를 반환하는 메소드 
		// >> 맵 값은 object 객체로 반환되므로 반드시 명시적 객체 형변환 후 사용 가능
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		System.out.println("아이디="+id);//아이디가 변경되어도 파일만 고치면 됨 > 수정 편함
		System.out.println("비밀번호="+password);
		System.out.println("이름="+name);
		
	}
	
	public static void main(String[] args) throws IOException {//>get.class는 static 클래스라 가져올 수 없음
			new PropertiesApp();
	}
}
