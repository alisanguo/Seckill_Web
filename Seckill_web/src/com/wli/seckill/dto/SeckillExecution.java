package com.wli.seckill.dto;

import com.wli.seckill.myenum.SeckillStatus;
import com.wli.seckill.po.SuccessKilled;

/**
 * 
 * 执行秒杀后返回的秒杀状态信息  
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 下午8:45:59
 */
public class SeckillExecution {

	private long seckillId;
	
	private int status;
	
	private String info;
	
	private SuccessKilled successKilled;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId,SeckillStatus seckillStatus) {
		super();
		this.seckillId = seckillId;
		this.status = seckillStatus.getStatus();
		this.info = seckillStatus.getInfo();
	}
	
	

	public SeckillExecution(long seckillId,SeckillStatus seckillStatus, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.status = seckillStatus.getStatus();
		this.info = seckillStatus.getInfo();
		this.successKilled = successKilled;
	}

	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", status=" + status + ", info=" + info + ", successKilled="
				+ successKilled + "]";
	}
	
	

	
	
	
}
