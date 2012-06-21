package marsrover.validator.impl;

import marsrover.validator.Validator;

public class MoveRoverDataValidator implements Validator {
	
	private String validationError;

	/**
	 * Validates the input data for the rover movement
	 */
	@Override
	public boolean valid(String data) {
		if(!data.matches("[MmRrLl]+")){
			validationError = "No letters other than M, R and L allowed";
			return false;
		}
		validationError = null;
		return true;
	}

	@Override
	public String getValidationError() {
		return validationError;
	}

}
