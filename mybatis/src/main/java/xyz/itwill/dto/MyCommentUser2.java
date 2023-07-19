/*제일 중요!!!!!!!!*/
package xyz.itwill.dto;

//MyComment 테이블(=메인 테이블)과 MyUser 테이블(=서브 테이블)의 컬럼값을 저장하기 위한 클래스
//=> 1:1 관계의 테이블 조인에 대한 검색결과를 저장하기 위한 클래스
//=> 포함관계를 이용하여 클래스 작성 - 기존의 클래스 재사용하여 새로운 클래스 작성 가능 
public class MyCommentUser2 {
	//mycomment 테이블(게시글정보)의 검색행을 객체로 저장하기 위한 필드 -검색행 1개
	//=> 필드에 반드시 객체를 저장해야만 포함관계(= 의존관계)가 성립 => 마이바티스가 객체를 제공함 => 반드시 수동매핑처리해야함!!, 자동안됨
	//=>
	private MyComment1 comment;
	//myuser 테이블(회원정보)의 검색행을 객체로 저장하기 위한 필드 - 검색행 1개
	private MyUser user;
	
	public MyCommentUser2() {
		// TODO Auto-generated constructor stub
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
}
