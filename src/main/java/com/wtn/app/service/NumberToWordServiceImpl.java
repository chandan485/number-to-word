package com.wtn.app.service;

import static com.wtn.app.Constants.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wtn.app.exception.NumberToWordException;
import com.wtn.app.validate.Validator;


public class NumberToWordServiceImpl implements NumberToWordService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(NumberToWordServiceImpl.class);
	private Validator validator = new Validator();
	
	@Override
	public String convertNumberToWord(int inputNumber) throws NumberToWordException {
		LOGGER.info("Input Number is {} ", inputNumber);
		validator.validateNumber(inputNumber);

		String current = EMPTY;
		int place = 0;

		do {
			int n = inputNumber % 1000;
			if (n != 0) {
				String s = convertLessThanOneThousand(n);
				current = s + UPTO_MILLION[place] + current;
			}
			place++;
			inputNumber = inputNumber / 1000;
		} while (inputNumber > 0);

		LOGGER.info("Number to word : {{}} ", current.trim());
		return current.trim();
	}
	
	private String convertLessThanOneThousand(int inputNumber) {
        String current;
        
        if (inputNumber % 100 < 20){
            current = UPTO_NINETEEN[inputNumber % 100];
            inputNumber = inputNumber/100;
        }
        else {
            current = UPTO_NINETEEN[inputNumber % 10];
            inputNumber = inputNumber/10;
            
            current = UPTO_NINETY[inputNumber % 10] + current;
            inputNumber = inputNumber/10;
        }
        if (inputNumber == 0) return current;
        return UPTO_NINETEEN[inputNumber] + HUNDRED_AND + current;
    }
}
