/*0424 4*/
package xyz.itwill.io;

import java.io.File;
import java.io.IOException;

//File 클래스 : 파일(디렉토리 - 폴더) 관련 정보를 저장하기 위한 클래스
public class FileApp {
	public static void main(String[] args) throws IOException {
		/*
	 	 파일 클래스의 File(String pathname) 생성자를 이용하여 매개변수로 전달받은 시스템(OS)의
	 	 파일경로를 전달받아 파일 객체 생성 
	 	 >파일 경로 - 파일 위치 : 시스템에 존재하는 파일 위치를 표현하는 2가지 방법
	 	 -절대 경로 표현방법 : 파일 경로를 최상위 디렉토리(=드라이브(WINDOW), /(LINUX 등))를 기준으로 파일위치를 표현하는 방법 - 권장
	 	 -상대 경로 표현방법 : 현재 실행 프로그램의 작업 디렉토리를 기준으로 파일 위치를 표현하는 방법
	 	 >> 이클립스에서는 프로젝트 폴더를 작업 디렉토리로 처리
	 	 WINDOW 운영체제에서는 폴더(드라이브)와 파일을 구분하기 위한 \ 기호 사용
	 	 >> 자바에서는 \ 기호가 회피문자를 표현하는 용도로 사용
	 	 >> \기호를 문자로 사용하기위해 \\ 형태의 회피문자로 표현
		 */
		File fileOne = new File("c:\\data"); // >> 역슬래쉬 한번쓰면 > 회피문자
		
		
		//File.exists() : File 객체에 저장된 파일경로의 파일(디렉토리)이 시스템에 존재하지
		//않을 경우 [false]를 반환하고 존재할 경우 [true]를 반환하는 메소드
		if(fileOne.exists()) {
			System.out.println("c:\\data 폴더가 이미 존재합니다.");
		}else {
			//File.mkdir(=make 디렉토리) : File 객체에 저장된 파일경로의 디렉토리(폴더)를 생성하는 메소드
			fileOne.mkdir();
			System.out.println("c:\\data 폴더를 생성 하였습니다.");
			
		}
		System.out.println("==========================================================");
		
		//File fileTwo = new File("c:\\data\\itwill.txt");

		// 윈도우 제외 나머지 OS는 /로 파일과 폴더를 구분 >> /etc/itwill.txt -Linux, mac 등 , 
		// 자바에서는 파일 경로를 표현하기위한 \\ 대신 / 문자 사용 가능 window도 사용할 수 있다
		File fileTwo = new File("c:/data/itwill.txt");//부모:data, 자식 itwill 을 같이 받아서 사용 절대경로로 
		
		
		if(fileTwo.exists()) {
			
			System.out.println("c:\\data\\itwill.txt 파일이 이미 존재합니다.");
		}else {
			//File.createNewFile() : File 객체에 저장된 파일경로의 파일을 생성하는 메소드
			fileTwo.createNewFile();
			
			System.out.println("c:\\data\\itwill.txt 파일를 생성 하였습니다.");
		}
		System.out.println("==========================================================");
		//파일 클래스의 File(String parents, String child) 생성자를 이용하여 매개변수로 부모(디렉토리)와 자식(파일)을
		//전달받아 파일 객체를 생성
		File fileThree = new File("c:/data", "itwill.txt");
			
		if(fileThree.exists()) {
			//delete(): 파일 객체에 저장된 파일경로의 파일을 삭제하는 메소드
			fileThree.delete();
			System.out.println("c:\\data\\itwill.txt 파일을 삭제.");
		}else {
			System.out.println("c:\\data\\itwill.txt 파일이 존재하지 않음.");
		}
		System.out.println("==========================================================");
		/*파일 경로를 상대경로 표현방식으로 전달하여 File 객체 생성
		 >> 현재 프로그램의 작업 디렉토리(프로젝트 폴더)를 기준으로 파일 경로 설정
		 >> 상대경로 표현 방법은 [..] 기호를 사용하여 상위 디렉토리를 표현하며 [./파일] 형식으로
		 작업 디렉토리에 존재하는 파일이나 하위 디렉토리 표현
		 */ 
		File fileFour = new File("src");// ./src :원래 표현식, 현재 디렉토리 밑에 존재하는 하위 디렉토리라는 뜻 하지만 어차피 현재라 생략가능
		
		if(fileFour.exists()) {
			//File.toString : File 객체에 저장된 파일 경로를 문자열로 반환하는 메소드
			System.out.println("파일경로 = "+fileFour/*.toString()*/); // 상대경로만 출력됨, toSting 참조변수를 출력하면 자동호출
			//File.getAbsolutePath : File 객체에 저장된 파일경로를 절대경로 표현방법의 문자열로 반환하는 메소드
			System.out.println("파일경로 = "+fileFour.getAbsolutePath());
		}else {
		
			System.out.println("작업 디렉토리에 [src]디렉토리가 없음");
		}
		System.out.println("==========================================================");
		
		File filefive = new File("c:/");
		
		//File.isDirectory :  File 객체에 저장된 파일 경로의 파일이 디렉토리인 아닌 경우 [false]를 반환하고 반대는 [true] 반환 
		if(filefive.isDirectory()) {
			//File.listFiles() :  File 객체에 저장된 파일경로의 디렉토리의 파일이나
			//하위 디렉토리 목록을 File 객체 배열로 반환하는 메소드
			File[] subFiles = filefive.listFiles();
			
			System.out.println(filefive+"폴더의 자식 목록>>");
			for(File file : subFiles) {
				//isFile : file 객체에 저장된 파일 경로의 파일이 일반파일이 아닌 경우 [false]를 반환하고 반대는 [true] 반환
				if(file.isFile()) {
					System.out.println("파일 = "+file);

				}else {
					System.out.println("폴더 = "+file);
					
				}
			}
		}
	}
}
