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
		//PointBoard board=PointBoard.builder().writer("abc123").subject("�׽�Ʈ").build();
		PointBoard board=PointBoard.builder().writer("xyz123").subject("�׽�Ʈ").build();
		
		//�Խñ��� �̹� ���� ó�� �� ���ܰ� �߻����� ���ԵǾ��⶧����
		//pointuserservice���� abc123�� ������� �Խñ� �ۼ��ھ��� ��� ���ܹ߻�
		//������: ���� �߻����� ����� �Խñ� ���Կ� ���� sql����� �̹� dbms������ ���޵Ǿ� ����� ���·� 
		//pointboard ���̺� �������� �Խñ� ����
		PointUser user = pointBoardService.addPointBoard(board);///�Խñ� ���� ó��
		
		log.info(pointBoardService.getPointBoardList().toString());
		log.info(user.toString());
	}
	
	@Test
	public void test2() throws Exception {
		PointUser user = pointBoardService.removePointBoard(1);///�Խñ� ���� ó��
		log.info(user.toString());
		log.info(pointBoardService.getPointBoardList().toString());
		
	}
}
