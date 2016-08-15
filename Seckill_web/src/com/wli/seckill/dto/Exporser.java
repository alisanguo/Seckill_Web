package com.wli.seckill.dto;

/**
 * 
 * 秒杀接口信息类   
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 下午8:23:53
 */
public class Exporser {
	
	private boolean exposed;
	
	private long seckillId;
	
	private long beginTime;
	
	private long endTime;
	
	private long nowTime;
	
	private String md5;

	public Exporser(boolean exposed, long seckillId, String md5) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
		this.md5 = md5;
	}

	public Exporser(boolean exposed, long seckillId, long beginTime, long endTime, long nowTime) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.nowTime = nowTime;
	}

	public boolean isExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getNowTime() {
		return nowTime;
	}

	public void setNowTime(long nowTime) {
		this.nowTime = nowTime;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@Override
	public String toString() {
		return "Exporser [exposed=" + exposed + ", seckillId=" + seckillId + ", beginTime=" + beginTime + ", endTime="
				+ endTime + ", nowTime=" + nowTime + ", md5=" + md5 + "]";
	}
	
	
	
	
	
	
}
