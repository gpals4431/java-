package xyz.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//파일 다운로드 기능을 제공하기 위한 클래스
//=> BeanNameViewResolver 객체에 의해 실행되는 클래스 
//=> Spring Bean Configuration File(Servlet-context.xml)에 Spring Bean으로 등록
//BeanNameviewResolver 객체에 의해 실행될 클래스는 반드시 
public class FileDownload extends AbstractView{
	public FileDownload() {
		setContentType("application/download; utf-8");
	}
	//BeanNameviewResolver 객체에 의해 자동 호출되는 메소드 - 실행 메소드 
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Map 에 어떤 타입으로 저장된지 모르므로 꼭 형변환 해주기
		String uploadDirectory = (String)model.get("uploadDirectory");
		String originalFilename = (String)model.get("originalFilename");
		String uploadFilename = (String)model.get("uploadFilename");
		
		File file= new File(uploadDirectory, uploadFilename);
		
		response.setContentType(getContentType());
		response.setContentLengthLong((int)file.length());
		
		originalFilename = URLEncoder.encode(originalFilename, "utf-8");
		response.setHeader("Content-Disposition", "attachement;filename=\""+originalFilename);
		
		OutputStream out = response.getOutputStream();
		
		InputStream in = new FileInputStream(file);
		
		FileCopyUtils.copy(in, out);
		
		in.close();
		
	}

}
