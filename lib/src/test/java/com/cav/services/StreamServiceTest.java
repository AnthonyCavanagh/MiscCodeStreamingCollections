package com.cav.services;

import java.util.List;

import org.junit.Test;

public class StreamServiceTest {

	@Test
	public void StreamSentence(){
		//Stream a string into a string
		StreamService service = new StreamServiceImpl();
		System.out.println(service.streamSentance("Now, let's create a function, which would split a comma separated String into a list of String using Stream API:"));
	}
	
	@Test
	public void StreamSentenceToList(){
		//Stream a string into a string
		StreamService service = new StreamServiceImpl();
		printStrings(service.streamSentancetoList("Now, let's create a function, which would split a comma separated String into a list of String using Stream API:"));
	}
	
	@Test
	public void StreamSentenceReplaceWord(){
		//Stream a string into a string
		StreamService service = new StreamServiceImpl();
		System.out.println(service.streamSentanceReplaceWord("when is love, when is life", "when", "what"));
	}
	
	private void printStrings(List <String> words){
		words.stream().forEach(str -> System.out.println(str));
	}
}
