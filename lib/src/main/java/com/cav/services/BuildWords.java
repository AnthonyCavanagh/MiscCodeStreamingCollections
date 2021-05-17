package com.cav.services;

import java.util.List;
import java.util.Map;

import com.cav.models.Word;

public interface BuildWords {
	
	List <Word> loadWordsLoop(List <String>words);
	
	List <Word> loadWordsStream(List <String>words);
	
	List <Word> loadWordsParrallStream(List <String>words);
	
	List <Word> filterWordsLoop(List <Word>words);
	
	List <Word> filterWordsRegexLoop(List <Word>words);
	
	List <Word> filterWordsStreamLoop(List <Word>words);
	
	List <Word> filterWordsStream(List <Word>words);
	
	List<Word> twoFilterWordsLoop(List<Word> words);
	
	List<Word> twoFilterWordsStream(List<Word> words);
	
    Map<Long, Word> mapWordsLoop(List <Word>words);
	
	Map<Long, Word> mapWordsStream(List <Word>words);
	
	Map<Long, List<Word>> mapWordsListLoop(List <Word>words);
	
	Map<Integer, List<Word>> mapWordsListStream(List <Word>words);

	List<Word> loadWordsIter(List<String> words);
	
	List<Word> sortWordsStream(List <Word>words);
	
	List<Word> sortWordsDuplicateStream(List <Word>words);
	
	Map <String, Word> streamIntoMap(List <Word>words);
	

	Map <String, Word> filterMap(Map<String, Word> wordmap, String partialKey);

}
