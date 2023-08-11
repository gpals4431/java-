package xyz.itwill10.dto;
/*
이름      널?       유형            
------- -------- ------------- 
IDX     NOT NULL NUMBER        
WRITER           VARCHAR2(20)  
SUBJECT          VARCHAR2(100) 
ORIGIN           VARCHAR2(100) 
UPLOAD           VARCHAR2(100)
 */

import org.springframework.web.multipart.MultipartFile;

public class FileBoard {
	private int idx;
	private String writer;
	private String subject;
	private String origin;
	private String upload;
	
	private MultipartFile multipartFile;
	
}
