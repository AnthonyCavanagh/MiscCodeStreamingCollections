package com.cav.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class IsDuplicateTest {

	@Test
	public void testLoop(){
		
		FilterCharectors build = new FilterCharectorsImpl();
		System.out.println(build.checkIsDuplicateLettersLoop("qwertyuiopasdfghjklzxcvbnmm"));
		System.out.println(build.checkIsDuplicateLettersLoop("qwertyuiopasdfghjklzxcvbnm"));
		System.out.println(build.checkIsDuplicateLettersLoop("qwertyuiopasdfghjklzxcvbnm111111111111111111111111111111"));
		System.out.println(build.checkIsDuplicateLettersLoop("qwertyuiopasdfghjklzxcvbnm11111111111111111111111111111m"));
		
	
	}
	
	@Test
	public void testStream(){
		FilterCharectors build = new FilterCharectorsImpl();
		System.out.println(build.checkIsDuplicateLettersStream("qwertyuiopasdfghjklzxcvbnmm"));
		System.out.println(build.checkIsDuplicateLettersStream("qwertyuiopasdfghjklzxcvbnm"));
		System.out.println(build.checkIsDuplicateLettersStream("qwertyuiopasdfghjklzxcvbnm111111111111111111111111111111"));
		System.out.println(build.checkIsDuplicateLettersStream("qwertyuiopasdfghjklzxcvbnm11111111111111111111111111111m"));
	}
	
	@Test
	public void testStreamRemoveDuplicates(){
		FilterCharectors build = new FilterCharectorsImpl();
		printList(build.removeDuplicatesStream("qwertyuiopasdfghjklzxcvbnmm"));
		printList(build.removeDuplicatesStream("qwertyuiopasdfghjklzxcvbnm"));
		printList(build.removeDuplicatesStream("qwertyuiopasdfghjklzxcvbnm111111111111111111111111111111"));
		printList(build.removeDuplicatesStream("qwertyuiopasdfghjklzxcvbnm11111111111111111111111111111m"));
	}
	
	@Test
	public void testStreamRemoveDuplicatesLetters(){
		FilterCharectors build = new FilterCharectorsImpl();
		printList(build.removeDuplicateLettersStream("qwertyuiopasdfghjklzxcvbnmm"));
		printList(build.removeDuplicateLettersStream("qwertyuiopasdfghjklzxcvbnm"));
		printList(build.removeDuplicateLettersStream("qwertyuiopasdfghjklzxcvbnm111111111111111111111111111111"));
		printList(build.removeDuplicateLettersStream("qwertyuiopasdfghjklzxcvbnm11111111111111111111111111111m"));
	}
	
	
	@Test
	public void replaceCharectors(){
		FilterCharectors build = new FilterCharectorsImpl();
		System.out.println(build.replaceLettersLoop('e', 'A', "This example demonstrates"));
		List <Character> lst = new ArrayList<Character>();
		lst.add('e');
		System.out.println(build.replaceLettersStream(lst, 'A', "This example demonstrates"));
		System.out.println(build.filterReplaceLettersStream('X', "The1lady@and1the£tramp0"));
	}
	
	void printList(List <Character> list){
		System.out.println();
		list.forEach( c ->System.out.print(c));
	}
}
