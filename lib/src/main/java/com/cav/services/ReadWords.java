package com.cav.services;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import com.cav.models.WordModel;

public interface ReadWords {
	
	public List<String> readWords(String path);
	
	public List<WordModel> loadWordsStream(List<String>list, int index);
	

	
	public void replaceWordsParallel(ConcurrentMap <String, WordModel> wordMap, List <WordModel> replacements);

	void replaceWordsStream(ConcurrentMap<String, WordModel> wordMap, List<WordModel> replacement);
	void replaceWordsStreamNullCheck(ConcurrentMap<String, WordModel> wordMap, List<WordModel> replacement);
	


}
