package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wli.seckill.dao.SuccessKilledDao;
import com.wli.seckill.po.SuccessKilled;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SuccessKilledDaoTest {
	
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsert() {
		System.out.println(successKilledDao.insert(1003, 13545899119L));
	}

	@Test
	public void testQueryByIdWithSeckill() {
		List<SuccessKilled> sk=successKilledDao.queryBySeckillIdWithSeckill(1000);
		System.out.println(sk);
		//System.out.println(sk.getSeckill());
	
	}

}
