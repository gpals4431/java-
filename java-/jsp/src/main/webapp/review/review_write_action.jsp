<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="java.net.http.HttpResponse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/security/login_check.jspf" %>
<%-- 게시글(새글 또는 답글)을 전달받아 REVIEW 테이블에 삽입하고 [review/review_lisk.jsp]문서로 
이동하기 위한 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서
=> 로그인 상태의 사용자만 요청가능한 JSP 문서
[multipart/form-date]형태로 값이 전달되므로 COS 라이브러리의 multipartRequest 클래스를 사용하여 처리
=> 전달받은 [/review_images] 서버 디렉토리에 업로드 처리하여 저장  --%>

<%
	//get방식으로 요청 - 비정상적인 요청 ->몸체부(=body)에는 post만 문서의 결과값을 저장할 수 있기때문에
	if(request.getMethod().equals("GET")){
		response.sendRedirect(request.getContextPath()+"index.jsp?group=error&worker=error_400");
		return;
	}

	//전달파일을 저장할 서버 디렉토리(웹자원)의 파일 시스템 경로를 반환받아 저장
	//request.getServletContext() == 가진 내장객체 application
	//String saveDirectory = application.getRealPath()
	//웹자원의 실제 경로를 c드라이브로
	String saveDirectory = request.getServletContext().getRealPath("/review_images");
	
	//multipartrequest 객체 생성 - 모든 전달파일을 서버 디렉토리에 업로드 처리하여 저장
	//=>COS.JAR 라이브러리 파일을 프로젝트에 반드시 빌드 처리
	MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory
			, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	//전달값을 반환받아 저장
	int ref=Integer.parseInt(multipartRequest.getParameter("ref"));
	int restep=Integer.parseInt(multipartRequest.getParameter("restep"));
	int relevel=Integer.parseInt(multipartRequest.getParameter("relevel"));
	String pageNum=multipartRequest.getParameter("pageNum");
	String subject=multipartRequest.getParameter("subject");
	int status=1;//전달값이 없는 경우 초기값 저장 - 일반글
	//체크박스라 무조건 값이 잇는것을 아니라 검증 필요
	if(multipartRequest.getParameter("secret")!=null){//전달값이 있는 경우 - 비밀글
		status=Integer.parseInt(multipartRequest.getParameter("secret"));
	}
	String content=multipartRequest.getParameter("content");
	String reviewimg=multipartRequest.getFilesystemName("reviewimg");//업로드 처리된 파일명 반환받아 저장.
	
	//REVIEW_SEQ 시퀀스의 다음값을 검색하여 반환하는 DAO클래스의 메소드 호출
	//=>게시글의 글번호(num 컬럼값)로 저장
	//=> 새글인 경우에는 게시글의 그룹번호(ref 컬럼값)으로 저장, 두개의 컬럼에 동일한 값이 들어가야함,,,?
	//seq_nextval가 dao에 2개가 들어가면 ex)values(seq_nextval,?,seq_nextval)이면 원래는 1, 1저장을 원하지만 실제로는 1,과 2가 저장됨 따로따로 저장안됨..
	int num=ReviewDAO.getDao().selectNextNum();
	
	//게시글을 작성한 클라이언트의 ip주소를 반환받아 저장
	//request.getRemoteAddr(): jsp 문서를 요청한 클라이언트의 ip 주소를 반환하는 메소드
	//=> 이클립스에 등록되어 동작되는 was 프로그램은 기본적으로 ipv6의 128bit 형식의 ip주소 제공
	//32Bit 형식(IPV4)의 IP 주소를 제공받을 수 있도록 이클립스의 실행 환경 변경
	//=> MENU > RUN > RUN CONFIGURATIONS... > APACHE TOMCAT > 사용중인 APACHETOMCAT 선택
	// > ARGUMENTS > VMARGUMEMTS > [-Djava.net.preferIPv4Stack=true]추가 > Apply
	String ip=request.getRemoteAddr();
	
	//게시글을 새글과 답글로 구분하여 REVIEW 테이블의 컬럼값에 저장될 변수값 변경
	//=>[review_write.jsp]문서에서 hidden 타입으로 전달된 값이 저장된 ref, restep, relevel 변수값 변경 
	//변수값 변경 -새글 : 초기값(0,0,0) 저장/ 답글 - 부모 게시글의 정보 저장
	if(ref==0){//새글인 경우
		//REVIEW 테이블의 ref 컬럼값으로 시퀀스의 다음값(num 변수값)을 저장하고 restep 컬럼과 
		//relevel 컬럼에는 restep 변수값(0)과 relevel 변수값(0)을 저장
		ref=num;
	}else{//답글인 경우
		//REVIEW 테이블에 저장된 기존 게시글에서 REF 컬럼값이 REF 변수값(부모글)과 같은 게시글 중
		//RESTEP 컬럼값이 RESTEP 변수값(부모글)보다 큰 모든 게시글의 RESTEP 컬럼값을 1 증가되도록 변경 처리
		//=>새로운 답글이 기존 답글보다 먼저 검색되도록 기존 답글의 순서를 증가
		//=>REF 변수값과 RESTEP 변수값을 전달받아 REVIEW 테이블의 RESTEP컬럼값을 변경하는 DAO클래스 메소드 호출
		ReviewDAO.getDao().updateRestep(ref, restep);
		
		//REVIEW 테이블의 ref 컬럼값에는 ref 변수값(부모글)을 저장하고 restep 컬럼과 
		//relevel 컬럼에는 restep 변수값(부모글)과 relevel 변수값(부모글)을 1 증가하여 저장
		restep++;
		relevel++;
		
	}
	
	//DTO객체를 생성하고 전달값 또는 변수값으로 필드값 변경
	ReviewDTO review=new ReviewDTO();
	review.setNum(num);
	review.setReviewid(loginMember.getId());
	review.setSubject(subject);
	review.setContent(content);
	review.setReviewimg(reviewimg);
	review.setRef(ref);
	review.setRestep(restep);
	review.setRestep(restep);
	review.setRelevel(relevel);
	review.setIp(ip);
	review.setStatus(status);
	
	//게시글을 전달받아 review 테이블에 삽입하는 dao클래스의 메소드 호출
	ReviewDAO.getDao().insertReview(review);
	
	//페이지 이동
	response.sendRedirect(request.getContextPath()+"index.jsp?group=review&worker=review_list&pageNum="+pageNum);
%>



