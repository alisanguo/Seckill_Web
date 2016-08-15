package com.wli.seckill.exception;

/**
 * 
 * 秒杀相关异常 
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 下午9:11:05
 */
public class SeckillException extends RuntimeException{

	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillException(String message) {
		super(message);
	}
	
	
}
