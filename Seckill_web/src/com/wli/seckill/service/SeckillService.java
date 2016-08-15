package com.wli.seckill.service;

import java.util.List;

import com.wli.seckill.dto.Exporser;
import com.wli.seckill.dto.SeckillExecution;
import com.wli.seckill.exception.RepeatSkillException;
import com.wli.seckill.exception.SeckillClosedException;
import com.wli.seckill.exception.SeckillException;
import com.wli.seckill.myenum.SeckillStatus;
import com.wli.seckill.po.Seckill;

public interface SeckillService {
	
	/**
	 * 
	* @Description: 查询秒杀商品列表
	* @param @return  
	* @return List<Seckill> 
	*
	 */
	List<Seckill> queryList();
	
	/**
	 * 
	* @Description: 根据id查询
	* @param @param seckillId
	* @param @return  
	* @return Seckill 
	*
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 
	* @Description: 暴露秒杀接口,秒杀开启则返回秒杀信息，否则返回秒杀时间和系统时间
	* @param @param seckillId  
	* @return void 
	*
	 */
	Exporser exporseSeckillUrl(long seckillId);
	
	/**
	 * 
	* @Description: 执行秒杀
	* @param @param seckillId
	* @param @param md5
	* @param @return  
	* @return SeckillStatus 
	*
	 */
	SeckillExecution executeSkill(long seckillId, String md5,long userPhone)
	 throws SeckillClosedException,RepeatSkillException,SeckillException;
	
	
}
