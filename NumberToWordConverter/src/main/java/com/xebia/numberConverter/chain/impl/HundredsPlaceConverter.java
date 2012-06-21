package com.xebia.numberConverter.chain.impl;

import com.xebia.numberConverter.chain.ConversionChain;
import com.xebia.numberConverter.constants.WordConstants;
import com.xebia.numberConverter.model.Number;
import com.xebia.numberConverter.utils.ConversionUtils;

public class HundredsPlaceConverter extends AbstractConverter {

	public HundredsPlaceConverter(int conversionIndex) {
		
		this.conversionBaseIndex = conversionIndex;
		switch(conversionIndex){
			case MILLION_PLACE_CONVERSION_IDX :{
				this.nextConverter = new MillionsPlaceConveter(conversionIndex);
				break;
			}
			case TERMINATION_INDEX:{
				this.nextConverter = new ConversionTerminator();
				break;
			}
			default : {
				this.nextConverter = new ThousandsPlaceConverter(conversionIndex);
			}
		}
	}
	
	public boolean convert(Number number) {
		super.convert(number);
		String word = getWordForNumber(ConversionUtils.digitsAt(number, conversionBaseIndex));
		if(!word.equals(WordConstants.EMPTY_STRING)){
			number.appendString(word);
			number.appendString(WordConstants.HUNDRED);
		}
		return true;
	}
	
	public HundredsPlaceConverter(ConversionChain chain) {
		super(HUNDREDS_PLACE_CONVERSION_IDX, chain);
	}
}
