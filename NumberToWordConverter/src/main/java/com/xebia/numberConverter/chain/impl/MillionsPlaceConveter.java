package com.xebia.numberConverter.chain.impl;

import com.xebia.numberConverter.constants.WordConstants;
import com.xebia.numberConverter.model.Number;

public class MillionsPlaceConveter extends AbstractConverter {

	public MillionsPlaceConveter(int conversionIndex) {
		super(conversionIndex, new UnitsPlaceConverter(++conversionIndex));
	}

	public MillionsPlaceConveter(){
		this(MILLION_PLACE_CONVERSION_IDX);
	}
	
	@Override
	public boolean convert(Number number) {
		if(super.convert(number)){
			number.appendString(WordConstants.MILLION);
		}
		return true;
	}

}
