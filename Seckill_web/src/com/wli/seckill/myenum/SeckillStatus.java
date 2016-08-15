package com.wli.seckill.myenum;

/**
 * 
 * 执行秒杀后状态枚举 
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 下午8:50:10
 */
public enum SeckillStatus {
	
	SUCCESS(1,"秒杀成功"),
	END(2,"秒杀结束"),
	REPEAT_KILL(2,"重复秒杀"),
	REWRITE(3,"数据篡改"),
	ERROR(4,"系统异常");
	
	private int status;
	
	private String info;
	
	private SeckillStatus(int status, String info) {
		this.status = status;
		this.info = info;
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
	
	public static SeckillStatus statusOf(int index){
		for(SeckillStatus st:values()){
			if(index==st.getStatus()){
				return st;
			}
		}
		return null;
	}
	
	
}
