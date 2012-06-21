package com.xebia.numberConverter.chain;

import com.xebia.numberConverter.model.Number;

public interface ConversionChain {
	
	public boolean convert(Number number);

	public boolean furtherConversionNeeded(Number number);
	
}
