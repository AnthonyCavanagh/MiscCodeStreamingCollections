package com.cav.services;

import java.util.List;

import org.junit.Test;

import com.cav.models.Word;

public class SortedListTest {
	
	@Test
	public void testSortStream(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");

		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		printList(buildWords.sortWordsStream(models));
	}
	
	
	@Test
	public void testSortRemoveDuplicatesStream(){
		Connection connection = new ConnectionImpl();
		List<String> words = connection.getWords("https://blog.reedsy.com/creative-writing-prompts/contests/62/submissions/37761/");

		
		BuildWords buildWords = new BuildWordsImpl();
		List<Word> models = buildWords.loadWordsLoop(words);
		printList(buildWords.sortWordsDuplicateStream(models));
	}
	void printList(List <Word> list){
		list.forEach( w ->System.out.println(w));
	}

}
