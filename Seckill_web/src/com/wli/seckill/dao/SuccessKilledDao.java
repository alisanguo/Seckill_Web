package com.wli.seckill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wli.seckill.po.SuccessKilled;

/**
 * 
 * 秒杀成功明细dao接口   
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 上午10:52:36
 */
public interface SuccessKilledDao {
	
	/**
	 * 
	* @Description: 插入秒杀明细
	* @param @param seckillId
	* @param @param userPhone
	* @param @return  
	* @return int 影响行数
	*
	 */
	int insert(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
	
	/**
	 * 
	* @Description: 根据seckillId查询秒杀明细，附带秒杀商品信息
	* @param @param seckillId
	* @param @return  
	* @return SuccessKilled 
	*
	 */
	List<SuccessKilled> queryBySeckillIdWithSeckill(@Param("seckillId")long seckillId);
	
	/**
	 * 
	* @Description: 根据seckillId和userPhone查询秒杀信息
	* @param @param seckillId
	* @param @param userPhone
	* @param @return  
	* @return SuccessKilled 
	*
	 */
	SuccessKilled queryBySeckillIdAndPhoneWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
