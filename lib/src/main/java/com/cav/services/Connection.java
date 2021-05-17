package com.cav.services;


import java.util.List;


public interface Connection {
	
	List<String> getWords(String url);
	List<String> getWordsStream(String link);
	
	List<String> getWordsFromFile(String link);
}
