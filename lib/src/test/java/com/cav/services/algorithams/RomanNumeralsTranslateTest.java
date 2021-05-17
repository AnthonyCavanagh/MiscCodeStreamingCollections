package com.cav.services.algorithams;

import org.junit.Test;

public class RomanNumeralsTranslateTest {

	@Test
	public void integerToRoman(){
		
		RomanNumeralsTranslate service = new RomanNumeralsTranslate();
		System.out.println(service.integerToRoman(6));
	}
	
	@Test
	public void translateRomanNumerals(){
		RomanNumeralsTranslate service = new RomanNumeralsTranslate();
		service.translateRomanNumerals(9);
	}
	
}
