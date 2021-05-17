package com.cav.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

import com.cav.models.Fund;

public class StreamStoryTest {
	
	//@Test
	public void StreamTestforWords(){
		
		Connection conn = new ConnectionImpl();
		//System.out.println("Run Test");
		List <String> words = conn.getWordsFromFile("story");
		List <String> searchWords = new ArrayList<String>();
		
		StreamStory streamStory = new StreamStoryImpl();
		searchWords.add("and");
		searchWords.add("the");
		searchWords.add("if");
		searchWords.add("be");
		searchWords.add("to");
		searchWords.add("of");
		Map<String, Integer> searchCount = streamStory.findWords(words, searchWords);
		printMap(searchCount);
		//printList(words);
	}
	

	
	@Test
	public void StreamTestFilterforWordAllmatch(){
		Connection conn = new ConnectionImpl();
		//System.out.println("Run Test");
		List <String> words = new ArrayList<String>();
		words.add("and");
		words.add("and");
		words.add("the");
		words.add("and");
		
		StreamStory streamStory = new StreamStoryImpl();
		List<String> list = streamStory.filterForWord(words, "and");
		printList(list);
	}
	
	@Test
	public void StreamTestFilterforWordsAllmatch(){
		Connection conn = new ConnectionImpl();
		//System.out.println("Run Test");
		List <String> words = conn.getWordsFromFile("story");
		
		List <String> matchWords = new ArrayList<String>();
		
		
		StreamStory streamStory = new StreamStoryImpl();
		matchWords.add("and");
		matchWords.add("the");
		long start = System.nanoTime();
		List<String> list = streamStory.filterForWordsAllMatch(words, matchWords);
		long finish = System.nanoTime();
	    long timeElapsed = finish - start;
	    System.out.println("Time taken  stream  "+timeElapsed);
		printList(list);
	}
	
	@Test
	public void StreamTestParalleFilterforWords(){
		Connection conn = new ConnectionImpl();
		//System.out.println("Run Test");
		List <String> words = conn.getWordsFromFile("story");
		
		List <String> matchWords = new ArrayList<String>();
		matchWords.add("and");
		matchWords.add("the");
		matchWords.add("if");
		matchWords.add("be");
		matchWords.add("to");
		matchWords.add("of");
		StreamStory streamStory = new StreamStoryImpl();
		long start = System.nanoTime();
		List<String> list = streamStory.paralleForWords(words, matchWords);
		long finish = System.nanoTime();
	    long timeElapsed = finish - start;
	    System.out.println("Time taken  parrall "+timeElapsed);
		//printList(list);
	}
	
	@Test
	public void replaceForWordExistingList(){
		List <String> words = new ArrayList<String>();
		words.add("and");
		words.add("Anthony");
		words.add("will");
		words.add("push");
		words.add("Anthony");
		words.add("rule");
		
		StreamStory streamStory = new StreamStoryImpl();
		List<String> list = streamStory.replaceForWordExistingList(words, "Anthony", "XXXXX");
		printList(list);
	}
	
	@Test
	public void replaceForWordNewList(){
		List <String> words = new ArrayList<String>();
		words.add("and");
		words.add("Anthony");
		words.add("will");
		words.add("push");
		words.add("Anthony");
		words.add("rule");
		
		StreamStory streamStory = new StreamStoryImpl();
		List<String> list = streamStory.replaceForWordNewList(words, "Anthony", "XXXXX");
		printList(list);
	}
	
	@Test
	public void mapWordsIntoMapRemoveDuplicate(){
		Connection conn = new ConnectionImpl();
		List <String> words = conn.getWordsFromFile("story");
		StreamStory streamStory = new StreamStoryImpl();
		streamStory.mapWordsIntoMapRemoveDuplicate(words);
	}
	
	@Test
	public void mapWordsIntoMapAddList(){
		Connection conn = new ConnectionImpl();
		List <String> words = conn.getWordsFromFile("story");
		StreamStory streamStory = new StreamStoryImpl();
		Map<String, List<String>> map = streamStory.mapWordsIntoMapAddList(words);
		List<String> list = map.get("and");
		printList(list);
	}
	
	@Test 
	public void mergeMapsIntoMap(){
		Map <String, String>map1 = new HashMap<String, String>();
		map1.put("One", "One");
		map1.put("Two", "Two");
		map1.put("Three", "Three");
		
		Map <String, String>map2 = new HashMap<String, String>();
		map2.put("One", "1");
		map2.put("Two", "2");
		map2.put("Three", "3");
		
		StreamStory streamStory = new StreamStoryImpl();
		Map<String, String> mergedMap = streamStory.mergeMapsIntoMap(map1, map2);
		printMapStr(mergedMap);
	}
	
	@Test
	public void replaceFundForActionExistingList(){
		List <Fund> funds = new ArrayList<Fund>();
		funds.add(new Fund("Fund1", "UNMATCHED"));
		funds.add(new Fund("Fund2", "UNMATCHED"));
		funds.add(new Fund("Fund3", "UNMATCHED"));
		funds.add(new Fund("Fund4", "UNMATCHED"));
		
		StreamStory streamStory = new StreamStoryImpl();
		funds = streamStory.replaceForFundActionExistingList(funds, "Fund2", "MATCHED");
		printFunds(funds);
	}
	
	
	@Test
	public void replaceFundsForActionExistingList(){
		List <Fund> funds = new ArrayList<Fund>();
		funds.add(new Fund("Fund1", "UNMATCHED"));
		funds.add(new Fund("Fund2", "UNMATCHED"));
		funds.add(new Fund("Fund3", "UNMATCHED"));
		funds.add(new Fund("Fund4", "UNMATCHED"));
		
		List <String> fundNames = new ArrayList<String>();
		fundNames.add("Fund2");
		fundNames.add("Fund4");
		
		StreamStory streamStory = new StreamStoryImpl();
		funds = streamStory.replaceForFundsActionExistingList(funds, fundNames, "MATCHED");
		printFunds(funds);
	}
	
	@Test
	/** Should fall over with a ConcurrentModificationException
	 * Cant remove element from a list while browsing over it
	 */
	public void removeForFundActionExistingList(){
		List <Fund> funds = new ArrayList<Fund>();
		funds.add(new Fund("Fund1", "UNMATCHED"));
		funds.add(new Fund("Fund2", "MATCHED"));
		funds.add(new Fund("Fund3", "UNMATCHED"));
		funds.add(new Fund("Fund4", "UNMATCHED"));
		
		StreamStory streamStory = new StreamStoryImpl();
		funds = streamStory.removeForFundActionExistingList(funds, "MATCHED");
		printFunds(funds);
	}
	
	@Test
	/**
	 * can browse and remove elements from a CopyOnWriteArrayList
	 */
	public void removeForFundActionExistingCopyOnWriteArrayList(){
		List <Fund> funds = new CopyOnWriteArrayList<Fund>();
		funds.add(new Fund("Fund1", "UNMATCHED"));
		funds.add(new Fund("Fund2", "MATCHED"));
		funds.add(new Fund("Fund3", "UNMATCHED"));
		funds.add(new Fund("Fund4", "UNMATCHED"));
		
		StreamStory streamStory = new StreamStoryImpl();
		funds = streamStory.removeForFundActionExistingList(funds, "MATCHED");
		printFunds(funds);
	}
	
	
	
	void printList(List <String> words){
		words.stream().forEach(w-> System.out.println(w));
	}
	
	void printMap(Map<String, Integer> map){
		map.forEach((s,i)->System.out.println((s + ":" + i)));
	}
	
	void printMapStr(Map<String, String> map){
		map.forEach((s,i)->System.out.println((s + ":" + i)));
	}
	
	void printFunds(List <Fund> funds){
		funds.stream().forEach(f-> System.out.println(f.toString()));
	}

}
