package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wli.seckill.dto.Exporser;
import com.wli.seckill.dto.SeckillExecution;
import com.wli.seckill.exception.SeckillException;
import com.wli.seckill.po.Seckill;
import com.wli.seckill.service.SeckillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml"
})
public class SeckillServiceTest {
	
	@Autowired
	private SeckillService seckillService;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testQueryList() {
		for(Seckill s:seckillService.queryList()){
			logger.info("s={}",s);
		}
	}

	@Test
	public void testQueryById() {
		logger.info("seckill={}",seckillService.queryById(1000));
	}

	@Test
	public void testSeckillLogic() {
		long seckillId=1000;
		try{
			Exporser e=seckillService.exporseSeckillUrl(seckillId);
			SeckillExecution se= seckillService.executeSkill(seckillId, e.getMd5()
					, 13545899117L);
			logger.info("result={}",se);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
	}


}
