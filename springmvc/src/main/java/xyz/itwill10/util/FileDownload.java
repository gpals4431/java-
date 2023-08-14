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

//���� �ٿ�ε� ����� �����ϱ� ���� Ŭ����
//=> BeanNameViewResolver ��ü�� ���� ����Ǵ� Ŭ���� 
//=> Spring Bean Configuration File(Servlet-context.xml)�� Spring Bean���� ���
//BeanNameviewResolver ��ü�� ���� ����� Ŭ������ �ݵ�� 
public class FileDownload extends AbstractView{
	public FileDownload() {
		setContentType("application/download; utf-8");
	}
	//BeanNameviewResolver ��ü�� ���� �ڵ� ȣ��Ǵ� �޼ҵ� - ���� �޼ҵ� 
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Map �� � Ÿ������ ������� �𸣹Ƿ� �� ����ȯ ���ֱ�
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
