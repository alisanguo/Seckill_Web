package com.wli.seckill.dto;

/**
 * 
 * 传给前端的秒杀信息实体   
 * @author ali  
 * @version  0.8 
 * 2016年6月18日 下午8:27:38
 */
public class SeckillResut<T> {
	
	private boolean success;
	
	private T data;
	
	private String error;
	

	public SeckillResut(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}
	
	

	public SeckillResut(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}



	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
