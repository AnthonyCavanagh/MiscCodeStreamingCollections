package com.cav.services.algorithams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TranlateNumbersToWords {
	
	public static final String million = "1000000";
	
	Map <String,String> mapDigits = new HashMap<String,String> ();
	List <String>prefixes = new ArrayList<String>();
	

	public String buildString(String number ){
		initlaiseMaps();
		String translated = new String();
		Iterator<String> prefixIter = prefixes.iterator();
		if (number.length() > 3) {
			while (number.length() > 0) {
				if(number.length() > 3){
					int index = number.length() - 3;
					String last3 = number.substring(index, number.length());
					translated = buildPartialString(last3, prefixIter.next())+translated;
					number = number.substring(0, index);
				} else {
					translated = buildPartialString(number, prefixIter.next())+translated;
					break;
				}
			}
		} else {
			return buildPartialString(number, "hundred");
		}

		return translated;
	}
	
	private String buildPartialString(String num, String postFix){
		boolean isNotOneHunded = false;
		if(!postFix.equals("hundred")){
			isNotOneHunded = true;
		}
		StringBuilder sb = new StringBuilder();
		if(num.length() == 3){
			sb.append(buildThreeDigits(num, postFix));
		} else if(num.length() == 2){
			sb.append(buildTwoDigits(num));
			if(isNotOneHunded){
				sb.append(postFix);
			}
		} else if(num.length() == 1){
			sb.append(buildOneDigit(num));
			if(isNotOneHunded){
				sb.append(postFix);
			}
		}
		return sb.toString();
	}
	
	private String buildThreeDigits(String num, String postFix){
		StringBuilder sb = new StringBuilder();
		String str3 = buildOneDigit(num.substring(0,1));
		if(!str3.isEmpty())  {
			sb.append(str3).append(postFix).append(buildTwoDigits(num.substring(1,3)));
		} else {
			sb.append(buildTwoDigits(num.substring(1,3)));
		}
		return sb.toString();
	}
	
	
	private String buildTwoDigits(String num){
		StringBuilder sb = new StringBuilder();
		String str = mapDigits.get(num);
		if(str != null){
			sb.append(mapDigits.get(num));
		} else {
			str = buildString(num.toCharArray());
			if(str != null) {
				sb.append(buildString(num.toCharArray()));
			}
		}
		return sb.toString();
	}
	
	private String buildOneDigit(String num){
		String str = mapDigits.get(num);
		if(str != null){
			return str;
		} else {
			return "";
		}
			
	}
	
	private String buildString(char [] chars){
		String num1 = String.valueOf(chars[0])+"0";
		String num2 = String.valueOf(chars[1]);
		String str1 = mapDigits.get(num1);
		String number = null;
		if(str1 == null){
			str1 = "";
		}
		String str2 = mapDigits.get(num2);
		if(str2 == null){
			str2 = "";
		}
		return str1+str2;
	}
	
	
	private void initlaiseMaps(){
		mapDigits.put("1","one");
		mapDigits.put("2","two");
		mapDigits.put("3","three");
		mapDigits.put("4","four");
		mapDigits.put("5","five");
		mapDigits.put("6","six");
		mapDigits.put("7","seven");
		mapDigits.put("8","eight");
		mapDigits.put("9","nine");
		mapDigits.put("10","ten");
		mapDigits.put("11","eleven");
		mapDigits.put("12","twelve");
		mapDigits.put("13","thirteen");
		mapDigits.put("14","fourteen");
		mapDigits.put("15","fifteen");
		mapDigits.put("16","sixteen");
		mapDigits.put("17","seventeen");
		mapDigits.put("18","eighteen");
		mapDigits.put("19","nineteen");
		mapDigits.put("20","twenty");
		mapDigits.put("30","thirty");
		mapDigits.put("40","fourty");
		mapDigits.put("50","fifty");
		mapDigits.put("60","sixty");
		mapDigits.put("70","seventy");
		mapDigits.put("80","eighty");
		mapDigits.put("90","ninety");
		
		prefixes.add("hundred");
		prefixes.add("thousand");
		prefixes.add("hundred");
		prefixes.add("million");
		
		
	}

}
