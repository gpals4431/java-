package xyz.itwill.dto;

//MyComment 테이블(=메인 테이블)과 MyUser 테이블(=서브 테이블)의 컬럼값을 저장하기 위한 클래스
//=> 1:1 관계의 테이블 조인에 대한 검색결과를 저장하기 위한 클래스
//=> 포함관계를 이용하여 클래스 작성 - 기존의 클래스 재사용하여 새로운 클래스 작성 가능 
public class MyReplyUser {
	//MyReply 테이블(게시글정보)의 검색행을 객체로 저장하기 위한 필드 -검색행 1개/
	private MyReply reply;
	
	//myuser 테이블(회원정보)의 검색행을 객체로 저장하기 위한 필드 - 검색행 1개
	private MyUser user;
	
	public MyReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public MyReply getReply() {
		return reply;
	}

	public void setReply(MyReply reply) {
		this.reply = reply;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
	 
}
