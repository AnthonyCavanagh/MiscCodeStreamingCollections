package com.cav.timestamp.cache;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cav.timestamp.model.WordTimeStamp;

public class WordCache {

	public static List <WordTimeStamp> wordCache = new CopyOnWriteArrayList<WordTimeStamp>();
}
