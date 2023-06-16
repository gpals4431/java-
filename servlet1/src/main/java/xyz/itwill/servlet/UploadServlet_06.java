package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//[multipart/form-data]로 전달된 경우 request 객체로부터 입력스트림(ServletInputStream)을 제공받아 
//임시 파일에 저장한 후 전달값과 전달파일을 구분하여 처리 >> 복잡함
// => [multipart/form-data]를 처리하는 클래스를 사용하여 처리하는 것을 권장함

//[multipart/form-data]를 처리하는 클래스가 포함된 라이브러리
//=> Apache 그룹에서 배포한 commons-fileupload 라이브러리의 클래스 사용 – 선택적 파일 업로드, 서블릿에서 파일 검증 가능
//=> Oreilly 그룹에서 배포한 cos 라이브러리의 클래스 사용– 무조건적인 파일 업로드, 검증없이 server directory에 저장



//입력페이지에서 전달된 값과 파일명을 클라이언트에게 전달하여 응답하는 서블릿
//=> 전달파일은 서버 디렉토리에 저장 - 파일 업로드 처리
@WebServlet("/upload.itwill")
public class UploadServlet_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(request.getMethod().equals("GET")) {//get방식(비정상적 요청)으로 요청하면 다시 filupload페이지로 이동  
			response.sendRedirect("fileupload.html");
			return;
		}
		//몸체부에 저장된 multipart/form-data를 가져올 수 있는 입력스트림 >> 임시파일로 multipart/form-data를 저장 
		//>> 저장된 임시파일을 따로따로 가져다 처리하기가 복잡함 >> 클래스 라이브러리를 이용하여 처리
		//request.getInputStream();

		/*
		request.setCharacterEncoding("utf-8");
		
		//form 태그로 전달된 [multipart/form-data]는 절대로 getParameter로 가져올 수 없음
		String uploader=request.getParameter("uploader");
		*/
		
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 파일 경로를 반환받아 저장
		//=> 이클립스의 작업 디렉토리(Work Space)가 아닌 WAS 프로그램이 사용하는 웹디렉토리(WebApps)의 
		//파일 시스템 경로를 반환
		//주의> WAS 프로그램이 실행(Start)될 때 이클립스의 작업 디렉토리의 파일을 웹디렉토리의 자원으로 변환하여 저장 - 동기화 처리  
		//=> 작업 디렉토리에 업로드 파일이 없으므로 동기화 처리되면 웹디렉토리에 업로드된 파일이 소멸  
		String saveDirectory=request.getServletContext().getRealPath("/upload");      
	    System.out.println("saveDirectory = "+saveDirectory);// > 동기화되면 사라짐 이클립스는 업로드 됏나안됏나 확인용
	      
		//cos 라이브러리의 MultipartRequest 클래스로 객체 생성 => 모든 전달파일을 서버 디렉토리에 저장 - 자동 업로드 처리
		//MultipartRequest 객체 : [multipart/form-data]로 전달받은 값과 파일을 처리하기 위한 객체  
		//MultipartRequest(HttpServletRequest request, saveDirectory[, int maxPostSize][, String encoding][, FileRenamePolicy policy]) 생성자를 이용하여 객체 생성
		// request: 요청 정보가 저장된 HttpServletRequest 객체 전달
		// saveDirectory: 전달 파일이 저장될 서버 디렉토리의 파일 시스템 경로 전달
		// maxPostSize: 전달파일의 용량을 제한하기 위한 크기(Byte)를 전달 - 생략시 크기는 무제한
		// encoding: 전달값을 제공받기 위한 문자형태 전달 - 생략시 서유럽어 기본값으로 사용 
		// policy: FileRenamePolicy 객체 전달 - 생략시 전달파일로 기존파일을 덮어씌우기(오버라이드)
		// FileRenamePolicy 객체 : 업로드될 파일의 이름과 같은 이름의 파일이 서버 디렉토리에 이미 존재할 경우,
		//업로드될 파일의 이름을 변경하는 기능을 제공하는 객체
		//=> FileRenamePolicy 인터페이스를 상속받은 자식 클래스로 객체를 생성
		MultipartRequest mr= new MultipartRequest(request, saveDirectory, 20*1024*1024
				,"utf-8", new DefaultFileRenamePolicy()/*이거 제거하면 오버라이드*/ );
		
		//MultipartRequest 객체를 이용하여 전달값을 반환받아 저장
		//MultipartRequest.getParameter(String name) 또는 getParameterValues(String name) 메소드 호출
		String uploader=mr.getParameter("uploader");
		
		//MultipartRequest 객체를 이용하여 전달 파일명을 반환받아 저장
		//=>MultipartRequest.getOriginalFileName(string name) : 매개변수로 전달된 이름의 파일명(입력된 원본 파일명)을 반환하는 메소드
		//String uploadfile=mr.getOriginalFileName("uploadfile");//uploadfile html문서의 파일 name값
		//String file1=mr.getOriginalFileName("file1");
		//String file2=mr.getOriginalFileName("file2");
		
		//=>MultipartRequest.getFilesystemName(string name) : 매개변수로 전달된 이름의 파일명(업로드 처리된 파일명)을 반환하는 메소드
		// => FileRenamePolicy 객체를 사용한 경우 호출하는 메소드
		String file1=mr.getFilesystemName("file1");
		String file2=mr.getFilesystemName("file2");
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>파일업로드</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+uploader+"</p>");
		out.println("<p>파일-1 = "+file1+"</p>");
		out.println("<p>파일-2 = "+file2+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
