package com.xebia.numberConverter.model;

import com.xebia.numberConverter.constants.WordConstants;

public class Number {

	private String numberString;

	private StringBuffer wordString = new StringBuffer("");
	
	public Number(String numberString) {
		this.numberString = numberString;
	}
	
	public String toString() {
		return wordString.toString().trim();
	}
	
	public String value(){
		return numberString;
	}
	
	public boolean hasIndex(int index){
		if((numberString.length() - 1) >= index)
			return true;
		return false;
	}
	
	public void appendString(String word){
		this.wordString.append(word);
		if(word.length() > 0)
			this.wordString.append(WordConstants.SPACER);
	}
	
	public void removePreceedingZeros(){
		int index = 0;
		StringBuffer temp = new StringBuffer();
		while(numberString.charAt(index)=='0')
			index++;
		for(;index<numberString.length();index++){
			temp.append(numberString.charAt(index));
		}
		numberString = temp.toString();
	}
	
}
