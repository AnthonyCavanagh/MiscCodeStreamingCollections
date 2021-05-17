package com.cav.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FilterCharectorsImpl implements FilterCharectors{

	
	@Override
	/**
	 * Checks if there are duplicate letters only, returns true if there are duplicates
	 */
	public boolean checkIsDuplicateLettersStream(String word) {
		return  !word.chars().filter(c -> isLetter((char) c)).allMatch(new HashSet<>()::add);
	}
	
	@Override
	/**
	 * Removes duplicate letters 
	 * uses distict to remove duplictae letters. 
	 */
	public List<Character> removeDuplicatesStream(String word) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		List<Character>  words = word.chars().distinct().mapToObj(c -> (char)c).collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
		return words;
	}
	
	
	@Override
	public List<Character> removeDuplicateLettersStream(String word) {
		List<Character>  words = word.chars().filter(c -> isLetter((char) c)).distinct().mapToObj(c -> (char)c).collect(ArrayList::new, ArrayList::add,ArrayList::addAll);
		words.addAll(word.chars().filter(c -> !isLetter((char) c)).mapToObj(c -> (char)c).collect(ArrayList::new, ArrayList::add,ArrayList::addAll));
		return words;
	}
	@Override
	public boolean checkIsDuplicateLettersLoop(String word) {
		for (int index = 0; index < word.length(); index++) {
			Character cx = word.charAt(index);
			if(isAlpha(cx)) {
				for (int indey = 0; indey < word.length(); indey++) {
					Character cy = word.charAt(indey);
					if(cx.equals(cy) && index != indey){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public String replaceLettersLoop(Character oldChar, char newChar, String sentance) {
	   char[] chars =  sentance.toCharArray();
	   char []  newSentance = new char[chars.length];
	   for(int index = 0; index < chars.length; index++){
		   Character c = chars[index];
		   if(c.equals(oldChar)){
			   newSentance[index] = newChar;
		   } else {
			   newSentance[index] = c;
		   }
	   }
	   return String.valueOf(newSentance);
	}
	


	@Override
	public String replaceLettersStream(List <Character> oldChar, char newChar, String sentance) {
		return sentance.chars().map( c-> oldChar.contains((char) c)? newChar : c).collect(StringBuilder::new, (sb, c) -> sb.append((char)c), StringBuilder::append)
	    .toString();

	}
	

	@Override
	public String filterReplaceLettersStream(char newChar, String sentance) {
		return sentance.chars().map(c -> replaceChar((char) c, newChar)).collect(StringBuilder::new, (sb, c) -> sb.append((char)c),StringBuilder::append) .toString();
	}
	
	private char replaceChar(Character character, char newChar){
		if(Character.isLetter(character)){
			return character;
		}
		return newChar;
		
	}

	private boolean isLetter(Character character){
		return Character.isLetter(character);
	}
	
	private boolean isAlpha(Character character) {
		if (!(character >= 'A' && character <= 'Z') && !(character >= 'a' && character <= 'z')) {
			return false;
		}
		return true;
	}

	



	
	
}
