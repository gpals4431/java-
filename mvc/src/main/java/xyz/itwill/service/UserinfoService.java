package xyz.itwill.service;

import java.sql.SQLException;
import java.util.List;

import xyz.itwil.exception.AuthFailException;
import xyz.itwil.exception.ExistsUserinfoException;
import xyz.itwil.exception.UserinfoNotFoundException;
import xyz.itwill.dao.UserinfoModelTwoDAO;
import xyz.itwill.dto.UserinfoDTO;

/*
 service 클래스 : 모델 클래스의 요청 처리 메소드에서 데이터 처리 기능을 메소드로 제공하기 위한 클래스
 => 단위 프로그램(모듈 프로그램) : 컴퍼넌트(Component)
 => 다수의 DAO 클래스의 메소드를 호출하여 데이터 처리에 필요한 기능을 제공 - 모듈화 처리 
 => 데이터베이스 관련 기능 구현시 발생되는 모든 문제에 대한 인위적 예외 발생 - 모델 클래스에서 예외 발생
 */
public class UserinfoService{
	//싱글톤 권장
	private static UserinfoService _service;
	
	public UserinfoService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_service=new UserinfoService();
	}
	public static UserinfoService getService() {
		return _service;
		
	}
	
	//회원정보를 전달받아 userinfo 테이블에 삽입하는 메소드
	//=> 매개변수로 전달받은 회원정보의 아이디가 userinfo 테이블에 저장된 기존 회원정보의 
	//아이디와 중복될 경우 인위적 예외 발생
	public void addUserinfo(UserinfoDTO userinfo) throws SQLException, ExistsUserinfoException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())!=null) {
			throw new ExistsUserinfoException("이미 사용중인 아이디를 입력하였습니다.");//사용자 정의 예외클래스를 이용하여 인위적 예외 발생
		}
		UserinfoModelTwoDAO.getDAO().insertUserinfo(userinfo);
	}
		/*
		 회원정보를 전달받아 userinfo 테이블에 저장된 회원정보를 변경하는 메소드
		 => 전달받은 회원정보가 userinfo 테이블에 없는 경우 인위적 예외 발생 
		 */
	public void modifyUserinfo(UserinfoDTO userinfo) throws SQLException, UserinfoNotFoundException{
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		UserinfoModelTwoDAO.getDAO().updateUserinfo(userinfo);
	}
	
	//아이디를 전달받아 userinfo 테이블에 삭제하는 메소드
	//=> 매개변수로 전달받은 회원정보가 userinfo 테이블에 없는 경우 인위적 예외 발생 
	public void removeUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		UserinfoModelTwoDAO.getDAO().deleteUserinfo(userid);
		
	}
	//아이디를 전달받아 userinfo 테이블에 저장된 회원정보를 검색하여 dTO객체로 반환하는 메소드
	//=> 매개변수로 전달받은 아이디의 회원정보가 userinfo 테이블에 없는 경우 인위적 예외 발생
	public UserinfoDTO getUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
		if(UserinfoModelTwoDAO.getDAO().selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("회원정보가 존재하지 않습니다.");
		}
		return userinfo;
	}
	
	//userinfo 테이블에 저장된 회원정보를 검색하여 List객체로 반환하는 메소드
	public List<UserinfoDTO> getUserinfoList() throws SQLException, UserinfoNotFoundException{
		return UserinfoModelTwoDAO.getDAO().selectUserinfoList();
		
	}
	
	//로그인정보(아이디와 비밀번호)를 전달받아 인증 처리하는 메소드
	//=> 인증실패시 인위적 예외를 발생시킴 - 예외가 발생하지않은 경우 인증 성공
	public void auth(String userid, String password) throws SQLException, AuthFailException{
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().selectUserinfo(userid);
		if(userinfo==null|| !userinfo.getPassword().equals(password)) {
			throw new AuthFailException("입력된 아이디가 잘못되거나 비밀번호가 맞지않습니다.");
		}
	}
	
}
