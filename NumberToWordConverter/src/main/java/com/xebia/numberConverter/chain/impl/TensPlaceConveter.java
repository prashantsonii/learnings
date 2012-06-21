package com.xebia.numberConverter.chain.impl;

import com.xebia.numberConverter.chain.ConversionChain;
import com.xebia.numberConverter.constants.BritishWords;
import com.xebia.numberConverter.constants.WordConstants;
import com.xebia.numberConverter.model.Number;
import com.xebia.numberConverter.utils.ConversionUtils;

public class TensPlaceConveter extends AbstractConverter {
	
	@Override
	public boolean convert(Number number) {
		super.convert(number);
		if(ConversionUtils.digitsAt(number, conversionBaseIndex).equals("1")){
			appendAndandWord(number, BritishWords.getWordForNumber(
					ConversionUtils.digitsBetween(number, conversionBaseIndex,2)));
			return false;
		}else{
			appendAndandWord(number, BritishWords.getWordForNumber(
					ConversionUtils.digitsAt(number, conversionBaseIndex)+"0"));			
			return true;
		}
	}

	private void appendAndandWord(Number number, String word){
		if(furtherConversionNeeded(number) && !Long.valueOf(ConversionUtils.digitsBetween(number, conversionBaseIndex,2)).equals(0L))
			number.appendString(WordConstants.AND);
		number.appendString(word);
	}
	
	public TensPlaceConveter(int conversionIndex) {
		super(conversionIndex, new HundredsPlaceConverter(++conversionIndex));
	}
	
	public TensPlaceConveter(ConversionChain chain){
		super(TENS_PLACE_CONVERSION_IDX, chain);
	}
	
}
