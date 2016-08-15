package com.wli.seckill.po;

import java.util.Date;


/**
 * 
 * 秒杀库存对应实体
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 上午10:33:03
 */
public class Seckill {
	
	private long seckillId;
	
	private String name;
	
	private int number;
	
	private Date beginTime;
	
	private Date endTime;
	
	private Date createTime;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}
	
	
}
