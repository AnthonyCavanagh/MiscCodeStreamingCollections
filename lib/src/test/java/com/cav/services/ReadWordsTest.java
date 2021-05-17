package com.cav.services;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.Test;

import com.cav.models.WordModel;

public class ReadWordsTest {

	@Test
	public void testReadWordsStream(){
		
		ConcurrentMap <String, WordModel> wordMap = new ConcurrentHashMap<String, WordModel>();
		ReadWords readWords = new ReadWordsImpl();
		List<String> list = readWords.readWords("/words");
		List<WordModel> replacement = readWords.loadWordsStream(list, 1);
		long start = System.nanoTime();
		readWords.replaceWordsStream(wordMap, replacement);
		long finish = System.nanoTime();
	    long timeElapsed = finish - start;
	    System.out.println("Time taken  stream "+timeElapsed);
		System.out.println(replacement.size());
		System.out.println(wordMap.size());
		
		replacement = readWords.loadWordsStream(list, 1);
		start = System.nanoTime();
		readWords.replaceWordsStream(wordMap, replacement);
		finish = System.nanoTime();
	    timeElapsed = finish - start;
	    System.out.println("Time taken  stream "+timeElapsed);
		System.out.println(replacement.size());
		System.out.println(wordMap.size());
	}
	
	@Test
	public void testReadWordsParallel(){
		
		ConcurrentMap <String, WordModel> wordMap = new ConcurrentHashMap<String, WordModel>();
		ReadWords readWords = new ReadWordsImpl();
		List<String> list = readWords.readWords("/words");
		List<WordModel> replacement = readWords.loadWordsStream(list, 1);
		long start = System.nanoTime();
		readWords.replaceWordsParallel(wordMap, replacement);
		long finish = System.nanoTime();
	    long timeElapsed = finish - start;
	    System.out.println("Time taken  parallel "+timeElapsed);
		System.out.println(replacement.size());
		System.out.println(wordMap.size());
		
		replacement = readWords.loadWordsStream(list, 1);
		start = System.nanoTime();
		readWords.replaceWordsParallel(wordMap, replacement);
		finish = System.nanoTime();
	    timeElapsed = finish - start;
	    System.out.println("Time taken  parallel "+timeElapsed);
		System.out.println(replacement.size());
		System.out.println(wordMap.size());
	}
	
	//@Test
	public void testReadWordsStreamEmptyList(){
		ConcurrentMap <String, WordModel> wordMap = new ConcurrentHashMap<String, WordModel>();
		ReadWords readWords = new ReadWordsImpl();
		List<String> list = readWords.readWords("/words");
		//List<WordModel> replacement = readWords.loadWordsStream(list, 1);
		List<WordModel> replacement = new ArrayList <WordModel>();
		long start = System.nanoTime();
		readWords.replaceWordsStream(wordMap, replacement);
		long finish = System.nanoTime();
	    long timeElapsed = finish - start;
	    System.out.println("Time taken  stream "+timeElapsed);
		System.out.println(replacement.size());
		System.out.println(wordMap.size());
	}
}
