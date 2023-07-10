package xyz.itwill.dto;
/*
 이름   널?       유형            
---- -------- ------------- 
WORD NOT NULL VARCHAR2(50)  
URL           VARCHAR2(100) 

insert into suggest values('JAVA','https://www.oracle.com');
insert into suggest values('Spring','https://spring.io');
insert into suggest values('Servlet','https://www.servlets.com');
insert into suggest values('eclipse','https://www.eclipse.org');
insert into suggest values('jQuery','https://www.jquery.com');
insert into suggest values('apache','https://www.apache.org');
insert into suggest values('tomcat','https://tomcat.apache.org');
insert into suggest values('아이티윌','https://www.itwill.xyz');
insert into suggest values('다음','https://www.daum.net');
insert into suggest values('네이버','https://www.naver.com');
insert into suggest values('구글','https://www.google.com');
*/
public class SuggestDTO {
	private String word;
	private String url;
	
	public SuggestDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
