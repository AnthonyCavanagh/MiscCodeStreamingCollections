package com.cav.services;

import java.util.List;

import org.junit.Test;

import com.cav.models.Word;

public class FilterTest {

	//@Test
	public void testFilterLoop(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");

		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		
        System.out.println(models.size());
        long start = System.nanoTime();
        models = buildWords.filterWordsLoop(models);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Words "+models.size());
        System.out.println("Time taken  loop "+timeElapsed);
        System.out.println("******************************************************* ");
	}
	
	//@Test
	public void testFilterStreamLoop(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		
		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		
        System.out.println(models.size());
        long start = System.nanoTime();
        models = buildWords.filterWordsStreamLoop(models);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Words "+models.size());
        System.out.println("Time taken Stream loop "+timeElapsed);
        System.out.println("******************************************************* ");
	}
	
	//@Test
	public void testFilterRegexLoop(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		
		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		
        System.out.println(models.size());
        long start = System.nanoTime();
        models = buildWords.filterWordsRegexLoop(models);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Words "+models.size());
        System.out.println("Time taken Regex loop "+timeElapsed);
        System.out.println("******************************************************* ");
	}
	
	
	//@Test
	public void testFilterStream(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		
		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		
        System.out.println(models.size());
        long start = System.nanoTime();
        models = buildWords.filterWordsStream(models);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Words "+models.size());
        System.out.println("Time taken Stream "+timeElapsed);
        System.out.println("******************************************************* ");
	}
	
	@Test
	public void testTwoFilterLoop(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");

		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		
        System.out.println(models.size());
        long start = System.nanoTime();
        models = buildWords.twoFilterWordsLoop(models);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Words "+models.size());
        System.out.println("Time taken  loop "+timeElapsed);
        System.out.println("******************************************************* ");
	}
	
	@Test
	public void testTwoFilterStream(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		
		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		
        System.out.println(models.size());
        long start = System.nanoTime();
        models = buildWords.twoFilterWordsStream(models);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Words "+models.size());
        System.out.println("Time taken Stream "+timeElapsed);
        System.out.println("******************************************************* ");
	}
	
}
