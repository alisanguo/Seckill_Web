package com.wli.seckill.po;

import java.util.Date;

/**
 * 
 * 秒杀成功明细实体   
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 上午10:33:37
 */
public class SuccessKilled {
	
	private long seckillId;
	
	private long userPhone;
	
	private Date createTime;
	
	private short status;
	
	private Seckill seckill;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	
	
	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + seckillId + ", userPhone=" + userPhone + ", createTime=" + createTime
				+ ", status=" + status + "]";
	}
	
	
}
