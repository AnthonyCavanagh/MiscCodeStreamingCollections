package com.cav.services;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.cav.models.Fund;

public class StreamStoryImpl implements StreamStory{

	@Override
	/**
	 * This will take in a list of words and a list of search words and will count each word 
	 * That the stream contains of search words
	 * @param words
	 * @param searchWords
	 * @return
	 */
	public Map<String, Integer> findWords(List<String> words, List<String> searchWords) {
		Map<String, Integer> searchMap = searchWords.stream().collect(Collectors.toMap(s->s, s->0));
		words.stream().forEach(w ->searchMap(w, searchMap));
		return searchMap;

	}
	
	
	@Override
	public List<String> filterForWord(List<String> words, String match) {
		return words.stream().filter(word ->word.equals(match)).collect(Collectors.toList());	
	}
	

	
	@Override
	/**
	 * returns all elements in the first list word that matches elements in the second list matchwords
	 * @param words
	 * @param matchWords
	 * @return
	 */
	public List<String> filterForWordsAllMatch(List<String> words, List<String> matchWords) {
		return words.stream().filter(word ->matchWords.stream().anyMatch(match ->match.equals(word))).collect(Collectors.toList());
	}
	
	

	private void searchMap(String word, Map<String, Integer> searchMap){
		if(searchMap.containsKey(word)){
			searchMap.merge(word, 1, Integer::sum);
		}
	}


	@Override
	public List<String> paralleForWords(List<String> words, List<String> matchWords) {
		return matchWords.parallelStream().filter(match ->words.stream().anyMatch(word ->word.equals(match))).collect(Collectors.toList());
	}


	@Override
	public List<String> replaceForWordExistingList(List<String> words, String match, String censor) {
		words.stream().forEach(word ->replaceWord(word, match, censor));
		return words;
	}


	@Override
	public List<String> replaceForWordNewList(List<String> words, String match, String censor) {
		return words.stream().map(word ->replaceWord(word, match, censor)).collect(Collectors.toList());
	}


	@Override
	public List<String> replaceForWordsAllMatch(List<String> words, List<String> matchWords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Takes in a list and a string and updates the fund whose name matches the fundName
	 */
	public List<Fund> replaceForFundActionExistingList(List<Fund> funds, String fundName, String action) {
		funds.stream().forEach(f ->replaceFundAction(f,fundName , action));
		return funds;
	}
	

	@Override
	/**
	 * Takes in a list and a list of fundNames and updates the fund whose name matches the fundName
	 */
	public List<Fund> replaceForFundsActionExistingList(List<Fund> funds, List<String> fundNames, String action) {
		funds.stream().forEach(f->fundNames.stream().forEach(fn ->replaceFundAction(f, fn, action)));
		return funds;
	}

	


	@Override
	/**
	 * Should fall over with a ConcurrentModificationException
	 * Cant remove element from a list while browsing over it.
	 */
	public List<Fund> removeForFundActionExistingList(List<Fund> funds, String action) {
		funds.stream().filter(f -> f != null).filter(f-> removeFund(f, action)).forEach(funds::remove);
		return funds;
	}

	

	@Override
	public List<Fund> removeForFundActionExistingCopyOnWriteArrayList(List<Fund> funds, String action) {
		funds.stream().filter(f -> f != null).filter(f-> removeFund(f, action)).forEach(funds::remove);
		return funds;
	}

	@Override
	/**
	 * Also handles duplicate
	 * @param words
	 * @return
	 */
	public Map<String, String> mapWordsIntoMapRemoveDuplicate(List<String> words){
		/*
		 *  Map<Integer, Zone> map = z.getZones().stream()
                            .collect(Collectors.toMap(Zone::getId, Function.identity(), 
                             (zone1, zone2) -> {
                               zone1.getParts().addAll(zone2.getParts());
                               return zone1;
                             }));
		 */
		
		return words.stream().collect(Collectors.toMap(String::new, String::new, (oldValue, newValue) -> oldValue));
	}
	

	@Override
	public Map<String, List<String>> mapWordsIntoMapAddList(List<String> words) {
		return words.stream().collect(Collectors.groupingBy(w -> w));
	}
	
	@Override
	public Map<String, String> mergeMapsIntoMap(Map<String, String> map1, Map<String, String> map2) {
		map1.forEach((key, value) ->map2.merge(key, value, (v1, v2)->v1.equals(v2)? v1 : v1 + "," + v2));
		return map2;
	}

	private String replaceWord(String word, String match , String censor){
		if(word.equals(match)){
			return censor;
		}
		return word;
	}
	
	private Fund replaceFundAction(Fund fund, String match , String action){
		if(fund.getName().equals(match)){
			fund.setAction(action);
			return fund;
		}
		return fund;
	}
	
	private boolean removeFund(Fund fund, String action){
		if(fund.getAction().equals(action)){
			return true;
		}
		return false;
	}




	



	


}
