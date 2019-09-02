package com.wtn.app.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wtn.app.exception.NumberToWordException;

public class Validator {
	
	private static Logger LOGGER = LoggerFactory.getLogger(Validator.class);
	
	public void validateNumber(int inputNumber) throws NumberToWordException {
		
		if(inputNumber > 999999999) {
			LOGGER.error("More than 999999999 value not allowed");
			throw new NumberToWordException("More than 999999999 value not allowed");
		}
		
		if(inputNumber <= 0) {
			LOGGER.error("Less than or equal to zero value not allowed");
			throw new NumberToWordException("Less than or equal to zero value not allowed");
		}
	}

}
