package com.xebia.numberConverter.chain.impl;

import com.xebia.numberConverter.constants.WordConstants;
import com.xebia.numberConverter.model.Number;
import com.xebia.numberConverter.utils.ConversionUtils;

public class ThousandsPlaceConverter extends AbstractConverter {
	
	public ThousandsPlaceConverter(int conversionIndex) {
		super(conversionIndex, new UnitsPlaceConverter(++conversionIndex));
	}

	public boolean digitNotZero(Number number, int index){
		return Long.valueOf(ConversionUtils.digitsAt(number, conversionBaseIndex + index))!=0;
	}
	
	private boolean appendThousand(Number number){
		if(digitNotZero(number, 3)||digitNotZero(number, 2)||digitNotZero(number, 1))
			return true;
		return false;
	}
	
	@Override
	public boolean convert(Number number) {
		if(super.convert(number)){
			if(appendThousand(number))
				number.appendString(WordConstants.THOUSAND);
		}
		return true;
	}
	
	public ThousandsPlaceConverter(){
		super(THOUSANDS_PLACE_CONVERSION_IDX, new UnitsPlaceConverter(THOUSANDS_PLACE_CONVERSION_IDX+1));
	}

}
