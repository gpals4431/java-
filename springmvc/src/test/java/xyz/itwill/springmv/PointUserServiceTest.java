package xyz.itwill.springmv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill10.dto.PointUser;
import xyz.itwill10.service.PointUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class PointUserServiceTest {
	@Autowired
	private PointUserService pointUserService;
	
	@Transactional
	@Test
	public void testAddPointUser() throws Exception {
		PointUser user=PointUser.builder().id("abc123").name("ȫ�浿").build();
		
		PointUser addUser=pointUserService.addPointUser(user);
		
		log.info(addUser.toString());
	}
}












