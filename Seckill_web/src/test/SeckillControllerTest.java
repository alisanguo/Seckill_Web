package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wli.seckill.controller.SeckillController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-web.xml","classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml"})
public class SeckillControllerTest {
	
	@Autowired
	private SeckillController seckillController;
	
	@Test
	public void testReduceNumber() {
		System.out.println(seckillController);
	}

	

}
