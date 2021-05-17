package com.cav.timestamp.services;

import java.time.LocalDateTime;

import com.cav.timestamp.cache.WordCache;
import com.cav.timestamp.model.WordTimeStamp;

public class RemoveWordsImpl implements RemoveWords{
	
	LocalDateTime now = null;

	@Override
	public Object call() throws Exception {
		now  = LocalDateTime.now();
		removeWord(now);
		return null;
	}
	
	private void removeWord(LocalDateTime now){
		WordCache.wordCache.stream().filter(wts ->removeIf(wts, now)).forEach(WordCache.wordCache::remove);
	}
	
	private boolean removeIf(WordTimeStamp wts, LocalDateTime now){
		if(wts.getDateTime().compareTo(now) < 0){
			return true;
		}
		return false;
		
	}

}
