package com.cav.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cav.models.Word;

public class BuildWordsImpl implements BuildWords {

	@Override
	public List<Word> loadWordsLoop(List<String> words) {
		List<Word> wordModels = new ArrayList<Word>();
		int wordId = 100000;
		for (String word : words) {
			wordModels.add(loadWord(wordId, word));
			wordId++;
		}
		return wordModels;
	}
	
	@Override
	public List<Word> loadWordsIter(List<String> words) {
		List<Word> wordModels = new ArrayList<Word>();
		int wordId = 100000;
		Iterator<String> wordIter = words.iterator();
		while(wordIter.hasNext()){
			wordModels.add(loadWord(wordId, wordIter.next()));
		}
		return wordModels;
	}

	@Override
	public List<Word> loadWordsStream(List<String> words) {
		int wordId = 100000;
		// words.stream().forEach(w ->loadWord(wordId, w));
		return words.stream().map(w -> loadWord(wordId, w)).collect(Collectors.toList());
	}

	private Word loadWord(int wordId, String word) {
		Word wordModel = new Word(wordId, word, word.length());
		wordId++;
		return wordModel;
	}

	@Override
	public List<Word> loadWordsParrallStream(List<String> words) {
		int wordId = 100000;
		// words.stream().forEach(w ->loadWord(wordId, w));
		return words.parallelStream().map(w -> loadWord(wordId, w)).collect(Collectors.toList());
	}
	
	@Override
	public List<Word> filterWordsLoop(List<Word> words) {
		List<Word> wordModels = new ArrayList<Word>();
		for (Word word : words) {
			if (isAlpha(word.getWord())) {
				wordModels.add(word);
			}
		}
		return wordModels;
	}

	@Override
	public List<Word> filterWordsRegexLoop(List<Word> words) {
		List<Word> wordModels = new ArrayList<Word>();
		for (Word word : words) {
			if (isAlphaRegex(word.getWord())) {
				wordModels.add(word);
			}
		}
		return wordModels;
	}

	@Override
	public List<Word> filterWordsStreamLoop(List<Word> words) {
		List<Word> wordModels = new ArrayList<Word>();
		for (Word word : words) {
			if (isAlphaStream(word.getWord())) {
				wordModels.add(word);
			}
		}
		return wordModels;
	}
	
	@Override
	public List<Word> filterWordsStream(List<Word> words) {
		return words.stream().filter(w-> isAlpha(w.getWord())).collect(Collectors.toList());
	}

	@Override
	public List<Word> twoFilterWordsLoop(List<Word> words) {
		List<Word> wordModels = new ArrayList<Word>();
		for (Word word : words) {
			if (isAlpha(word.getWord())&& word.getCharCount() > 3 ) {
				wordModels.add(word);
			}
		}
		return wordModels;
	}

	@Override
	public List<Word> twoFilterWordsStream(List<Word> words) {
		return words.stream().filter(w-> isAlpha(w.getWord()) && w.getCharCount() > 3).collect(Collectors.toList());
	}
	
	@Override
	public Map<Long, Word> mapWordsLoop(List<Word> words) {
		Map<Long, Word> map= new ConcurrentHashMap<Long, Word> ();
		for(Word word : words){
			map.put(word.getWordId(), word);
		}
		return map;

	}

	@Override
	/**
	 * Builds up a map replacing a word pbject with a new word object.
	 */
	public Map<Long, Word> mapWordsStream(List<Word> words) {
		// fails with duplicates
		//return words.stream().collect(Collectors.toMap(Word::getWordId, word ->word));
		return words.stream().collect(Collectors.toMap(Word::getWordId,  Function.identity(),(existing, replacement) -> existing));
	}
	
	@Override
	public Map<Long, List<Word>> mapWordsListLoop(List<Word> words) {
		Map<Long, List<Word>> map= new ConcurrentHashMap<Long, List<Word>> ();
		for(Word word : words){
			List<Word> list = map.get(word.getCharCount());
			if(list != null){
				list = new ArrayList <Word>();
				map.put(word.getWordId(), list);
			}
			list.add(word);
		}
		return map;
	}

	@Override
	public Map<Integer, List<Word>> mapWordsListStream(List<Word> words) {
		return words.stream().collect(Collectors.groupingBy(Word::getCharCount));
	}
	
	

	

	@Override
	public List<Word> sortWordsStream(List<Word> words) {
		return words.stream().filter(w-> isAlpha(w.getWord())).sorted(Comparator.comparing(Word::getWord)).collect(Collectors.toList());
	}


	@Override
	public List<Word> sortWordsDuplicateStream(List<Word> words) {
		words = words.stream().filter(w-> isAlpha(w.getWord())).collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Word:: getWord))),ArrayList::new));
		return words;
	}
	
	
	
	@Override
	public Map<String, Word> streamIntoMap(List<Word> words) {
		return words.stream().collect(Collectors.toMap(Word::getWord, word -> word));
	}

	@Override
	public Map<String, Word> filterMap(Map<String, Word> wordmap, String partialKey) {
		//List<Entry<String, Word>> entry = wordmap.entrySet().stream().filter(m -> m.getKey().contains(partialKey)).c
		return wordmap;
	}
	
	private boolean isAlpha(String word) {
		for (int index = 0; index < word.length(); index++) {
			char c = word.charAt(index);
			if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
				return false;
			}
		}
		return true;
	}
	
	
	

	private boolean isAlphaRegex(String word) {
		return word.matches("^[a-zA-Z]*$");
	}
	
	private boolean isAlphaStream(String word) {
		return word.chars().allMatch(Character::isLetter);
	}



	
}


