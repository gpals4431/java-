package xyz.itwill.dto;

import java.util.List;

//MYCOMMENT 와 MYUSER, MYREPLY(MYUSER 테이블)테이블을의 컬럼값을 저장하기위한 클래스 
public class MyCommentReplyUser {
	//MYCOMMENT 테이블(게시글의 정보)의 검색결과를 제공받아 저장하기 위한 필드 - 검색행 : 1개
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	//MYUSER 테이블(회원 정보)의 검색결과를 객체로 제공받아 저장하기 위한 필드 - 검색행 : 1개
	private MyUser user;
	
	//MYREPLY 테이블(댓글 정보)와 MYUSER(댓글에 대한 회원 정보)의 검색결과가 요소로 저장된 List 객체를 제공받아 저장하기 위한 필드 - 검색행 : 0개 이상
	private List<MyReplyUser> replyUserList;

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public List<MyReplyUser> getReplyUserList() {
		return replyUserList;
	}

	public void setReplyUserList(List<MyReplyUser> replyUserList) {
		this.replyUserList = replyUserList;
	}
	
	
	
	
	
	
	

}
