package com.xebia.numberConverter.validator;

import com.xebia.numberConverter.constants.WordConstants;
import com.xebia.numberConverter.model.Number;

public class NumberValidator {

	private static String validationResult;

	public static final String NO_VALUE = "No Value";
	public static final String NOT_A_NUMBER = "Not a number, contains invalid characters";
	public static final String NOT_INITIALIZED = "Number not Initialized";
	public static final String EXCEEDS_LIMIT = "Value Exceeds Limit";
	
	public static boolean isValidNumber(Number number) {
		if (number == null || number.value() == null) {
			validationResult = NOT_INITIALIZED;
			return false;
		} else if (WordConstants.EMPTY_STRING.equals(number.value())) {
			validationResult = NO_VALUE;
			return false;
		} else {
			if (number.value().matches("[^0-9]*")) {
				validationResult = NOT_A_NUMBER;
				return false;
			}
			if(number.value().length()>9){
				validationResult = EXCEEDS_LIMIT;
				return false;
			}
			number.removePreceedingZeros();
			return true;
		}
	}

	public static String getValidationResult() {
		return validationResult;
	}

}
