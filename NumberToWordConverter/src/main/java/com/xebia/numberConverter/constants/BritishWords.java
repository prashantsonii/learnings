package com.xebia.numberConverter.constants;

import java.util.HashMap;

public class BritishWords {
	
	private static HashMap<String, String> words = new HashMap<String, String>();
	
	static{
		words.put("1","One");
		words.put("2", "Two");
		words.put("3","Three");
		words.put("4","Four");
		words.put("5","Five");
		words.put("6","Six");
		words.put("7","Seven");
		words.put("8","Eight");
		words.put("9","Nine");
		words.put("10","Ten");
		words.put("11","Eleven");
		words.put("12","Twelve");
		words.put("13","Thirteen");
		words.put("14","Fourteen");
		words.put("15","Fifteen");
		words.put("16","Sixteen");
		words.put("17","Seventeen");
		words.put("18","Eighteen");
		words.put("19","Nineteen");
		words.put("20","Twenty");
		words.put("30","Thirty");
		words.put("40","Forty");
		words.put("50","Fifty");
		words.put("60","Sixty");
		words.put("70","Seventy");
		words.put("80","Eighty");
		words.put("90","Ninety");
	}
	
	public static String getWordForNumber(String numberString){
		String word = words.get(numberString);
		if(word == null)
			return WordConstants.EMPTY_STRING;
		else
			return words.get(numberString);
	}
	
}
