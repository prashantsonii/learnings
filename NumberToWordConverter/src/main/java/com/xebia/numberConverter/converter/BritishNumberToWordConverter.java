package com.xebia.numberConverter.converter;

import com.xebia.numberConverter.chain.ConversionChain;
import com.xebia.numberConverter.chain.impl.UnitsPlaceConverter;
import com.xebia.numberConverter.validator.NumberValidator;

public class BritishNumberToWordConverter {
	private ConversionChain conversionChainInit;
	private int conversionIndexInit = 0;

	public BritishNumberToWordConverter() {
		conversionChainInit = new UnitsPlaceConverter(conversionIndexInit);
	}

	public String convertToBritishWords(com.xebia.numberConverter.model.Number number) {
		if (!NumberValidator.isValidNumber(number)) {
			return NumberValidator.getValidationResult();
		} else {
			conversionChainInit.convert(number);
			return number.toString();
		}
	}
}
