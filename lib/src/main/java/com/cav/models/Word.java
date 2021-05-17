package com.cav.models;

public class Word {
	long wordId;
	String word;
	int charCount;
	
	public Word(long wordId, String word, int charCount) {
		super();
		this.wordId = wordId;
		this.word = word;
		this.charCount = charCount;
	}

	public long getWordId() {
		return wordId;
	}

	public String getWord() {
		return word;
	}

	public int getCharCount() {
		return charCount;
	}

	@Override
	public String toString() {
		return "Word [wordId=" + wordId + ", word=" + word + ", charCount=" + charCount + "]";
	}
}
