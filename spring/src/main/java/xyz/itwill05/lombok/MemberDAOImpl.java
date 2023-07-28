package xyz.itwill05.lombok;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository//스프링 빈이 됨
public class MemberDAOImpl implements MemberDAO {
	public MemberDAOImpl() {
		log.info("MemberDAOImpl 클래스의 기본 생성자 호출");
	}
	@Override
	public int insertMember(Member member) {
		log.info("MemberDAOImpl 클래스의 insertMember() 호출");
		return 0;
	}
	@Override
	public int updateMember(Member member) {
		log.info("MemberDAOImpl 클래스의 updateMember() 호출");
		return 0;
	}
	@Override
	public int deleteMember(String id) {
		log.info("MemberDAOImpl 클래스의 deleteMember() 호출");
		return 0;
	}
	@Override
	public Member selectMember(String id) {
		log.info("MemberDAOImpl 클래스의 selectMember() 호출");
		return null;
	}
	@Override
	public List<Member> selectMemberList() {
		log.info("MemberDAOImpl 클래스의 selectMemberList() 호출");
		return null;
	}


}
