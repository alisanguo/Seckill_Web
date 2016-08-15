package test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wli.seckill.dao.SeckillDao;
import com.wli.seckill.po.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
	
	@Autowired
	private SeckillDao SeckillDao;
	
	@Test
	public void testReduceNumber() {
		SeckillDao.reduceNumber(1000, new Date());
	}

	@Test
	public void testQueryList() {
		for(Seckill s:SeckillDao.queryList(0, 100)){
			System.out.println(s);
		}
	}

	@Test
	public void testQueryById() {
		System.out.println(SeckillDao.queryById(1001));
	}

}
