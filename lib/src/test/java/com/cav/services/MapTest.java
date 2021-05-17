package com.cav.services;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.cav.models.Word;

public class MapTest {

	@Test
	public void testMapLoop(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		
		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		
        System.out.println(models.size());
        long start = System.nanoTime();
        Map<Long, Word> map = buildWords.mapWordsLoop(models);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Words "+map.size());
        System.out.println("Time taken Loop "+timeElapsed);
        System.out.println("******************************************************* ");
	}
	
	@Test
	public void testMapStream(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");
		
		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		
        System.out.println(models.size());
        long start = System.nanoTime();
        Map<Long, Word> map = buildWords.mapWordsStream(models);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Words "+map.size());
        System.out.println("Time taken Stream "+timeElapsed);
        System.out.println("******************************************************* ");
	}
}
