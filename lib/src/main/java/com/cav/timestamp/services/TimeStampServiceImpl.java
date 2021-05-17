package com.cav.timestamp.services;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.cav.timestamp.cache.WordCache;

public class TimeStampServiceImpl implements  TimeStampService{

	LoadWords loadWords = null;
	RemoveWords removeWords = null;
	@Override
	public void runService(List<String> words) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		int index = 0;
		while(true){
			try {
				System.out.println("runService "+index);
				loadWords = new LoadWordsImpl(words);
				removeWords = new RemoveWordsImpl();
				executor.submit(loadWords);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				executor.submit(removeWords);
				if(index > 10){
					break;
				}
				index++;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		executor.shutdown();
		try {
			executor.awaitTermination(2, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("endService "+WordCache.wordCache.size());
	}

}
