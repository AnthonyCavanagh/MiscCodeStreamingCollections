package com.cav.services;

import java.util.List;

public interface FilterCharectors {

	boolean checkIsDuplicateLettersStream(String word);

	List<Character> removeDuplicateLettersStream(String word);

	boolean checkIsDuplicateLettersLoop(String word);
	
	String replaceLettersLoop(Character oldChar, char newChar, String sentance);
	
	String replaceLettersStream(List <Character>  oldChar, char newChar, String sentance);
	
	String filterReplaceLettersStream(char newChar, String sentance);

	List<Character> removeDuplicatesStream(String word);

	

}
