package xyz.itwill.springmv;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill10.dto.PointBoard;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.service.PointBoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
public class PointBoardServiceTest {
	@Autowired
	private PointBoardService pointBoardService;
	
	@Test
	public void test1() throws Exception {
		//PointBoard board=PointBoard.builder().writer("abc123").subject("테스트").build();
		PointBoard board=PointBoard.builder().writer("xyz123").subject("테스트").build();
		
		//게시글은 이미 삽입 처리 됨 예외가 발생전에 삽입되었기때문에
		//pointuserservice에서 abc123만 등록해줌 게시글 작성자없는 경우 예외발생
		//문제점: 예외 발생전에 실행된 게시글 삽입에 대한 sql명령은 이미 dbms서버에 전달되어 실행된 상태로 
		//pointboard 테이블에 비정상적 게시글 저장
		PointUser user = pointBoardService.addPointBoard(board);///게시글 삽입 처리
		
		log.info(pointBoardService.getPointBoardList().toString());
		log.info(user.toString());
	}
	
	@Test
	public void test2() throws Exception {
		PointUser user = pointBoardService.removePointBoard(1);///게시글 삽입 처리
		log.info(user.toString());
		log.info(pointBoardService.getPointBoardList().toString());
		
	}
}
