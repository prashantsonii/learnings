package com.xebia.numberConverter.chain.impl;

import com.xebia.numberConverter.chain.ConversionChain;
import com.xebia.numberConverter.constants.WordConstants;
import com.xebia.numberConverter.model.Number;

public class UnitsPlaceConverter extends AbstractConverter{
	
	public boolean convert(Number number) {
		if(super.convert(number)){
			number.appendString(getWordsForDigits(number));
			return true;
		}
		if(!getWordsForDigits(number, conversionBaseIndex+1).
				equals(WordConstants.ZERO)){
			return true;
		}
		return false;
	}
	
	public UnitsPlaceConverter(int conversionIndex) {
		super(conversionIndex, new TensPlaceConveter(++conversionIndex));
	}

	public UnitsPlaceConverter(ConversionChain chain){
		super(UNITS_PLACE_CONVERSION_IDX, chain);
	}
}
