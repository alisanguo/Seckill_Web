package com.wli.seckill.exception;

public class RepeatSkillException extends RuntimeException{

	public RepeatSkillException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatSkillException(String message) {
		super(message);
	}
	
	
}
