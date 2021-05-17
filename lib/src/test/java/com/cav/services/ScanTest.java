package com.cav.services;

import java.util.Scanner;

import org.junit.Test;

public class ScanTest {

	
	@Test
	public void testScan(){
		String str = "abcde";
		Scanner scan = new Scanner(str);
		str = scan.next();
		char a;
		for(int index=0; index < str.length(); index++){
			a=str.charAt(index);
			System.out.println(a);
		}
	}
	
	@Test
	public void testReplace(){
		String sentence ="The rain in spain falls in spain";
		sentence = sentence.replaceAll("spain", "England");
		System.out.println(sentence);
		
		sentence ="The rain in spain falls in Spain";
		sentence = sentence.replaceAll("spain", "England");
		System.out.println(sentence);
		
		sentence ="The rain in spain falls in Spain";
		sentence = sentence.replaceAll("(?i)spain", "England");
		System.out.println(sentence);
	}
	
	@Test
	public void testQuestionMark(){
		
		boolean isHere = false;
		int count = isHere ? printRight() : printLeft();
		
	}
	
	private int printLeft(){
		System.out.println("Running left method");
		return 0;
		
		
	}
	
	private int printRight(){
		System.out.println("Running right method");
		return 1;
	}
	
}
