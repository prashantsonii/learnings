package com.xebia.numberConverter.chain.impl;

import com.xebia.numberConverter.chain.ConversionChain;
import com.xebia.numberConverter.constants.BritishWords;
import com.xebia.numberConverter.model.Number;
import com.xebia.numberConverter.utils.ConversionUtils;

public abstract class AbstractConverter implements ConversionChain {

	protected static final int UNITS_PLACE_CONVERSION_IDX = 0;
	protected static final int TENS_PLACE_CONVERSION_IDX = 1;
	protected static final int HUNDREDS_PLACE_CONVERSION_IDX = 2;
	protected static final int THOUSANDS_PLACE_CONVERSION_IDX = 2;
	protected static final int TEN_THOUSANDS_PLACE_CONVERSION_IDX = 3;
	protected static final int HUNDRED_THOUSANDS_PLACE_CONVERSION_IDX = 4;
	protected static final int MILLION_PLACE_CONVERSION_IDX = 5;
	protected static final int TEN_MILLION_PLACE_CONVERSION_IDX = 6;
	protected static final int HUNDRED_MILLION_PLACE_CONVERSION_IDX = 7;
	protected static final int TERMINATION_INDEX = 8;
	
	
	protected ConversionChain nextConverter;

	protected int conversionBaseIndex;

	public AbstractConverter(int conversionIndex, ConversionChain conversionChain) {
		this.conversionBaseIndex = conversionIndex;
		this.nextConverter = conversionChain;
	}

	public AbstractConverter() {
	}

	public boolean furtherConversionNeeded(Number number) {
		if (number.hasIndex(conversionBaseIndex + 1))
			return true;
		else
			return false;
	}

	public boolean convert(Number number) {
		if (nextConverter != null) {
			if (furtherConversionNeeded(number)) {
				return nextConverter.convert(number);
			}
		}
		return true;
	}

	protected String getWordsForDigits(Number number){
		return getWordsForDigits(number, conversionBaseIndex);
	}
	
	protected String getWordsForDigits(Number number, int index){
		String digits = ConversionUtils.digitsAt(number, index);
		return getWordForNumber(digits);		
	}
	
	public String getWordForNumber(String number){
		return BritishWords.getWordForNumber(number);
		
	}
}
