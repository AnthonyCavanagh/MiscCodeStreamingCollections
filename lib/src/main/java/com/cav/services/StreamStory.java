package com.cav.services;

import java.util.List;
import java.util.Map;

import com.cav.models.Fund;

public interface StreamStory {

	
	Map <String, Integer> findWords( List<String>words, List<String>searchWords);
	List<String> paralleForWords( List<String>words, List<String>matchWords);

	List<String> filterForWord(List<String> words, String match);
	List<String> filterForWordsAllMatch(List<String> words, List<String> matchWords);
	
	List<String> replaceForWordsAllMatch(List<String> words, List<String> matchWords);
	List<String> replaceForWordExistingList(List<String> words, String match, String censor);
	List<String> replaceForWordNewList(List<String> words, String match, String censor);
	
	List<Fund> replaceForFundActionExistingList(List<Fund> funds, String fund, String action);
	List<Fund> replaceForFundsActionExistingList(List<Fund> funds, List<String> fundNames, String action);
	
	List<Fund> removeForFundActionExistingList(List<Fund> funds, String action);
	List<Fund> removeForFundActionExistingCopyOnWriteArrayList(List<Fund> funds, String action);
	Map<String, String> mergeMapsIntoMap(Map<String, String> map1, Map<String, String> map2);
	Map<String, String> mapWordsIntoMapRemoveDuplicate(List<String> words);
	Map<String, List<String>> mapWordsIntoMapAddList(List<String> words);
	
}
