package com.xebia.numberConverter.chain.impl;

import com.xebia.numberConverter.chain.ConversionChain;
import com.xebia.numberConverter.model.Number;

public class ConversionTerminator implements ConversionChain {

	@Override
	public boolean convert(Number number) {
		return false;
	}

	@Override
	public boolean furtherConversionNeeded(Number number) {
		return false;
	}

}
