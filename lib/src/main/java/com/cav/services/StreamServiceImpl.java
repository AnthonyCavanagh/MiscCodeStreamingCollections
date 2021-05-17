package com.cav.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamServiceImpl implements StreamService{

	@Override
	public String streamSentance(String sentance) {
		return sentance.chars().map(ch -> ch).collect(StringBuilder::new, (sb, c) -> sb.append((char)c),StringBuilder::append) .toString();
	}
	
	@Override
	public List<String> streamSentancetoList(String sentance) {
		return Stream.of(sentance.split(" ")).collect(Collectors.toList());
	}

	@Override
	public String streamSentanceReplaceWord(String sentance, String oldWord, String newWord) {
		return sentance.replaceAll(oldWord, newWord);
	}

	
	
	
	private String replaceWord(String newWord){
			return newWord;
	}

	@Override
	public String streamSentanceReplaceWordStream(String sentance, String oldWord, String newWord) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
