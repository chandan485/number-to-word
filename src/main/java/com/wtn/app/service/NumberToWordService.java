package com.wtn.app.service;

import com.wtn.app.exception.NumberToWordException;

public interface NumberToWordService {
	
	public String convertNumberToWord(int inputNumber) throws NumberToWordException;
}
