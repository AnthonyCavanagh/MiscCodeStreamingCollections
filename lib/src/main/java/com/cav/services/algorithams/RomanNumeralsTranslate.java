package com.cav.services.algorithams;

public class RomanNumeralsTranslate {
	
	// 1 2 3 4 5 6 7 8 9 10
	// i 11, 111
	
	int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	StringBuilder sb = new StringBuilder();
	
	public String translateRomanNumerals(int num){
		for(int index = 0 ; index < values.length; index++){
			int checkNum = values[index];
			while(checkNum <= num){
				num  = (num-checkNum);	
				sb.append(romanLiterals[index]);
			}
		}
		return sb.toString();
	}
	

	
	
	
	
	
	
	
	
	
	
	public String integerToRoman(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
        	int checkvalue = values[i];
            while(num >= values[i]) {
            	System.out.println("index "+i);
                num -= values[i];
                System.out.println("index "+i);
                roman.append(romanLiterals[i]);
            }
        }
       return roman.toString();
    }

}
