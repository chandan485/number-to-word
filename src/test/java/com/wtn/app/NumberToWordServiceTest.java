package com.wtn.app;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wtn.app.exception.NumberToWordException;
import com.wtn.app.service.NumberToWordService;
import com.wtn.app.service.NumberToWordServiceImpl;

public class NumberToWordServiceTest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(NumberToWordServiceTest.class);
	
	NumberToWordService numberToWordService;
	
	@Before
	public void setUp() {
		numberToWordService = new NumberToWordServiceImpl();
	}
	
	@After
	public void tearDown(){
		numberToWordService = null;
	}
	
	@Test
	public void testConvertNumberToWord_withPositiveNumber() throws NumberToWordException {

		LOGGER.info("Running testConvertNumberToWord_withPositiveNumber..");

		assertEquals("one hundred and five", numberToWordService.convertNumberToWord(105));
		assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",
				numberToWordService.convertNumberToWord(56945781));
	}

	@Test
	public void testConvertNumberToWord_withMaxNumber() throws NumberToWordException {

		LOGGER.info("Running testConvertNumberToWord_withMaxNumber..");
		assertEquals(
				"nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine",
				numberToWordService.convertNumberToWord(999999999));
	}
   	
	@Test(expected = NumberToWordException.class)
	public void testConvertNumberToWord_withExceptionForNegetiveNumber() throws NumberToWordException {
		
		LOGGER.info("Running testConvertNumberToWord_withExceptionForNegetiveNumber..");
		numberToWordService.convertNumberToWord(-1);
	}
	
	@Test(expected = NumberToWordException.class)
	public void testConvertNumberToWord_withExceptionForLargerNumber() throws NumberToWordException {
		
		LOGGER.info("Running testConvertNumberToWord_withExceptionForLargerNumber..");
		numberToWordService.convertNumberToWord(1000000000);
	}

}
