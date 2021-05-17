package com.cav.timestamp.services;

import java.time.LocalDateTime;
import java.util.List;

import com.cav.timestamp.cache.WordCache;
import com.cav.timestamp.model.WordTimeStamp;

public class LoadWordsImpl implements LoadWords {

	List <String> words;
	
	public LoadWordsImpl(List<String> words) {
		super();
		this.words = words;
	}
	
	@Override
	public Object call() throws Exception {
		generateWords(words);
		return null;
	}
	
	private void generateWords(List<String> words){
		words.forEach(w->createWord(w));
	}
	
	private void createWord(String word){
		LocalDateTime now = LocalDateTime.now();
		WordCache.wordCache.add(new WordTimeStamp(word, now));
	}

}
