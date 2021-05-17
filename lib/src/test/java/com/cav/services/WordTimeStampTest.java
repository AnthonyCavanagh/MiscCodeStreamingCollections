package com.cav.services;


import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import com.cav.timestamp.services.TimeStampService;
import com.cav.timestamp.services.TimeStampServiceImpl;

public class WordTimeStampTest {

	@Test
	public void testWordTimeStamp(){
		LocalDateTime dt1 = LocalDateTime.parse("2021-11-03T12:45:30");
		LocalDateTime dt2 = LocalDateTime.parse("2021-11-03T12:45:35");
		
		// Is 
		System.out.println(dt1.compareTo(dt2));
		System.out.println(dt1.compareTo(dt1));
		System.out.println(dt2.compareTo(dt1));
		
		Connection conn = new ConnectionImpl();
		List <String >words = conn.getWordsFromFile("words");
		
		TimeStampService service = new TimeStampServiceImpl();
		service.runService(words);
	}
}
