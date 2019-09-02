package com.wtn.app.exception;

public class NumberToWordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7375083519735703643L;
	
	public NumberToWordException(String message){
		super(message);
	}
	
	public NumberToWordException(String message, Throwable e){
		super(message, e);
	}

}
