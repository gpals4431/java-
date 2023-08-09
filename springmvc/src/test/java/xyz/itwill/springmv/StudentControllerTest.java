package xyz.itwill.springmv;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
//�׽�Ʈ Ŭ���������� �����ڸ� ���������
public class StudentControllerTest {
	//WebApplicationContext ��ü�� �����޾� �����ϱ� ���� �ʵ� ���� - ������ ����
	//=>WebApplicationContext ��ü : SpringMVC ���α׷����� ������ �����̳� ����� �����ϱ� ���� ��ü
	@Autowired
	private WebApplicationContext context;
	
	//MockMvc ��ü�� �����ϱ� ���� �ʵ� ���� - ������ ���� �Ұ��� 
	//=> MockMvc ��ü : Ŭ���̾�Ʈ ��ſ� ��û�� ������ �������� �����ϱ� ���� ��ü
	private MockMvc mvc;//���� �߿�!!!!
	
	//@Before: �׽�Ʈ �޼ҵ� ȣ������ ����� ����� �ۼ��� �޼ҵ忡 �����ϴ� ������̼� - �ʱ�ȭ ó���� ���� ���
	@Before//junit���� �����ϴ� ���̺귯�� ����ؾ���!
	public void setup() {
		//build() : ��¥ MockMvc ��ü �����Ͽ� ��ȯ
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		log.info("MockMvc ��ü ����");
	}
	
	@Test
	public void testStudentDisplay() throws Exception{
		//�Ű������� ��û url �ּҸ� ���޹޾� GET ������� �����α׷��� ��û�ϴ� �޼ҵ�
		//=> ��û �������� ���� url �ּ��� ��û ���� ����(������Ʈ �޼���)�� ����� builder ��ü ��ȯ
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		log.info(result.getModelAndView().getViewName());
		log.info(result.getModelAndView().getModel().toString());
	}
	

}	























