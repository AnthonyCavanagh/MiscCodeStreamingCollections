package com.cav.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cav.models.WordModel;



public class ReadWordsImpl implements ReadWords{

	@Override
	/**
	 * Filter out Empty strings
	 */
	public List<String> readWords(String path) {
		try {
			Stream<String> lines = Files.lines(Paths.get(this.getClass().getResource(path).toURI()), Charset.defaultCharset());
			List<String> list = lines.filter(s ->!s.isEmpty()).collect(Collectors.toList());
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Collections.emptyList();
		
	}
	
	@Override
	public List<WordModel> loadWordsStream(List<String> words, int index) {
		return  words.stream().map(w -> buildWord(index , w)).collect(Collectors.toList());
	}

	
	@Override
	public void replaceWordsStream(ConcurrentMap <String, WordModel> wordMap, List<WordModel> replacement) {
		replacement.stream().forEach(w -> replaceWord(w, wordMap));
	}
	
	@Override
	public void replaceWordsStreamNullCheck(ConcurrentMap<String, WordModel> wordMap,
			List<WordModel> replacement) {
		replacement.stream().filter(Objects::nonNull).forEach(w -> replaceWord(w, wordMap));
		
	}
	
	@Override
	public void replaceWordsParallel(ConcurrentMap <String, WordModel> wordMap, List<WordModel> replacements) {
		replacements.parallelStream().forEach(w -> replaceWord(w, wordMap));
		
	}

	
   

	private WordModel buildWord(int index, String word){
		return new WordModel(index, word);
	}
	
	private void replaceWord(WordModel replacement, ConcurrentMap <String, WordModel> wordMap){
		if(wordMap.containsValue(replacement.getWord())){
			WordModel temp = wordMap.get(replacement.getWord());
			if(replacement.getWordIndex() > temp.getWordIndex()) {
				wordMap.put(replacement.getWord(), replacement);
			}
		} else {
			wordMap.put(replacement.getWord(), replacement);
		}
	}

	
	


	

	

}
