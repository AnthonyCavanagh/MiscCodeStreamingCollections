package com.cav.services;

import java.util.List;

import org.junit.Test;

import com.cav.models.Word;



public class LoadTest {

	@Test
	public void testdataLoop(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		System.out.println(words.size());
		
		BuildWords buildWords = new BuildWordsImpl();
		long start = System.nanoTime();
		List<Word> models = buildWords.loadWordsLoop(words);
		long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time taken word loop "+timeElapsed);
        System.out.println(models.size());
        System.out.println("*************************************************************");
		
	}
	
	@Test
	public void testdataIter(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		System.out.println(words.size());
		
		BuildWords buildWords = new BuildWordsImpl();
		long start = System.nanoTime();
		List<Word> models = buildWords.loadWordsIter(words);
		long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time taken word iter "+timeElapsed);
        System.out.println(models.size());
        System.out.println("*************************************************************");
		
	}
	
	@Test
	public void testdataStream(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWordsStream("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		System.out.println(words.size());
		BuildWords buildWords = new BuildWordsImpl();
		long start = System.nanoTime();
		List<Word> models = buildWords.loadWordsStream(words);
		long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time taken  word stream "+timeElapsed);
        System.out.println(models.size());
        System.out.println("*************************************************************");
	}
	
	@Test
	public void testdataParrallStream(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWordsStream("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		System.out.println(words.size());
		BuildWords buildWords = new BuildWordsImpl();
		long start = System.nanoTime();
		List<Word> models = buildWords.loadWordsParrallStream(words);
		long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time taken  word Parrall stream "+timeElapsed);
        System.out.println(models.size());
        System.out.println("*************************************************************");
	}
}
