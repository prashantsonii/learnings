package marsrover.validator.impl;

import marsrover.validator.Validator;

public class RoverDataValidator implements Validator {

	private String validationError;
	
	/**
	 * Validates the input data for Rover
	 */
	@Override
	public boolean valid(String data) {
		if(data.length() > 3){
			validationError = "Invalid position / heading specified for the rover";
			return false;
		}else if(!data.matches("\\d\\d[NEWSnews]")){
			validationError = "Invalid characters for position / heading";
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
