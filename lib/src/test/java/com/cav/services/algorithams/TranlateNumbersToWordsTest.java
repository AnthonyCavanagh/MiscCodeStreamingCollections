package com.cav.services.algorithams;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TranlateNumbersToWordsTest {
	
	@Test
	public void tranlateNumbersToWordsTestThree(){
		TranlateNumbersToWords translate = new TranlateNumbersToWords();
		assertEquals("one",translate.buildString("1"));
		assertEquals("eleven",translate.buildString("11"));
		assertEquals("twenty",translate.buildString("20"));
		assertEquals("twentytwo",translate.buildString("22"));
		assertEquals("twohundredtwentytwo",translate.buildString("222"));
		assertEquals("twohundred",translate.buildString("200"));
		assertEquals("twohundredone",translate.buildString("201"));
	}
	
	@Test
	public void tranlateNumbersToWordsTestTemp(){
		TranlateNumbersToWords translate = new TranlateNumbersToWords();
		
	}
	
	@Test
	public void tranlateNumbersToWordsTestFour(){
		TranlateNumbersToWords translate = new TranlateNumbersToWords();
		assertEquals("onethousand",translate.buildString("1000"));
		assertEquals("onethousandone",translate.buildString("1001"));
		assertEquals("onethousandten",translate.buildString("1010"));
		assertEquals("onethousandtwentyfive",translate.buildString("1025"));
		assertEquals("onethousandonehundredtwentyfive",translate.buildString("1125"));
		
		
		
	}

}
