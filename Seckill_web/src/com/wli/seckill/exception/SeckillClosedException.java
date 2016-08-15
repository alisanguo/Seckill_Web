package com.wli.seckill.exception;

/**
 * 
 *秒杀关闭异常
 * @author ali  
 * @version  0.8 
 * 2016年6月16日 下午9:14:50
 */
public class SeckillClosedException extends RuntimeException {

	public SeckillClosedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillClosedException(String message) {
		super(message);
	}

	
}
