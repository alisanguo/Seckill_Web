package com.wli.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.wli.seckill.dao.SeckillDao;
import com.wli.seckill.dao.SuccessKilledDao;
import com.wli.seckill.dto.Exporser;
import com.wli.seckill.dto.SeckillExecution;
import com.wli.seckill.exception.DataRewriteException;
import com.wli.seckill.exception.RepeatSkillException;
import com.wli.seckill.exception.SeckillClosedException;
import com.wli.seckill.exception.SeckillException;
import com.wli.seckill.myenum.SeckillStatus;
import com.wli.seckill.po.Seckill;
import com.wli.seckill.po.SuccessKilled;
import com.wli.seckill.service.SeckillService;

@Service
public class SeckillServiceImpl implements SeckillService{
	
	@Autowired
	private SeckillDao seckillDao;
	
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	private final String salt="adsfhoind@#$%^&&*%%;',,vmjfdjfndsba";
	
	private org.slf4j.Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public List<Seckill> queryList() {
		return seckillDao.queryList(0, 4);
	}

	public Seckill queryById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}
	
	/**
	 * 暴露秒杀接口,秒杀开启则返回秒杀信息，否则返回秒杀时间和系统时间
	 * 
	 */
	public Exporser exporseSeckillUrl(long seckillId) {
		Seckill seckill=seckillDao.queryById(seckillId);
		long beginTime=seckill.getBeginTime().getTime();
		long endTime=seckill.getEndTime().getTime();
		long nowTime=new Date().getTime();
		
		if(beginTime>nowTime||endTime<nowTime){
			return new Exporser(false, seckillId, beginTime, endTime, nowTime);
		}
		
		String md5=getMD5(seckillId);
		return new Exporser(true, seckillId, md5);
	}

	private String getMD5(long seckillId) {
		String str=seckillId+salt;
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}
	
	@Transactional
	/**
	 * 
	* @Description: 执行秒杀
	* @param @param seckillId
	* @param @param md5
	* @param @return  
	* @return SeckillStatus 
	*
	 */
	public SeckillExecution executeSkill(long seckillId, String md5,long userPhone)  throws SeckillClosedException,RepeatSkillException,SeckillException{
		
		try{
			if(md5==null||!md5.equals(getMD5(seckillId))){
				throw new DataRewriteException("seckill data rewrite");
			}else{
				int updateCount=seckillDao.reduceNumber(seckillId, new Date());
				if(updateCount<=0){
					throw new SeckillClosedException("seckill closed");
				}else{
					int insertCount;
					try{
						insertCount=successKilledDao.insert(seckillId, userPhone);
					}catch(DuplicateKeyException de){
						throw new RepeatSkillException("repeat seckill");
					}
					//if(insertCount==1){
						SuccessKilled successKilled=successKilledDao.queryBySeckillIdAndPhoneWithSeckill(seckillId, userPhone);
						return new SeckillExecution(seckillId, SeckillStatus.SUCCESS, successKilled);
					//}
					/*if(insertCount<=0){
						throw new RepeatSkillException("repeat seckill");
					}else{
						SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(seckillId);
						return new SeckillExecution(seckillId, SeckillStatus.SUCCESS, successKilled);
					}*/
				}
			}
		}catch(SeckillException e){
			throw e;
		}catch(RepeatSkillException e){
			throw e;
		}catch(DataRewriteException e){
			throw e;
		}catch(Exception e){
			logger.error("秒杀失败",e);//声明式事务只有在RuntimeException才回滚
			throw new SeckillException("秒杀失败"+e.getMessage());
		}
		
		
		
	}

	
	
	

}
