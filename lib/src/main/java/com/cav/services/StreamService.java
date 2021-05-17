package com.cav.services;

import java.util.List;

public interface StreamService {

	String streamSentance(String sentance);

	List <String> streamSentancetoList(String sentance);

	String streamSentanceReplaceWord(String sentance, String oldWord, String newWord);
	
	String streamSentanceReplaceWordStream(String sentance, String oldWord, String newWord);
}
