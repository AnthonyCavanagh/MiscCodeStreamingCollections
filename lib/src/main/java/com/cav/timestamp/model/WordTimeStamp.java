package com.cav.timestamp.model;

import java.time.LocalDateTime;

public class WordTimeStamp {

	String word;
	LocalDateTime dateTime;
	public WordTimeStamp(String word, LocalDateTime dateTime) {
		super();
		this.word = word;
		this.dateTime = dateTime;
	}
	public String getWord() {
		return word;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}

}
