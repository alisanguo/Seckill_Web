package com.wli.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wli.seckill.po.Seckill;

/**
 * 
 * 秒杀库存dao接口
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 上午10:44:43
 */
public interface SeckillDao {
	
	/**
	 * 
	* @Description: 减库存
	* @param @param seckillId
	* @param @return  
	* @return int 
	*
	 */
	int reduceNumber(@Param("seckillId")long seckillId,@Param("skillTime")Date skillTime);
	
	/**
	 * 
	* @Description: 查询秒杀商品列表
	* @param @param offset
	* @param @param limit
	* @param @return  
	* @return List<Seckill> 
	*
	 */
	List<Seckill> queryList(@Param("offset")int offset,@Param("limit") int limit);
	
	/**
	 * 
	* @Description: 根据id查询秒杀商品
	* @param @param seckillId
	* @param @return  
	* @return Seckill 
	*
	 */
	Seckill queryById(@Param("seckillId")long seckillId);
	
}
