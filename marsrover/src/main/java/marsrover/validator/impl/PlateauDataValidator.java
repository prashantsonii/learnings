package marsrover.validator.impl;

import marsrover.validator.Validator;

public class PlateauDataValidator implements Validator {
	
	private String validationError;

	/**
	 * Validates the input data for plateau
	 */
	@Override
	public boolean valid(String data) {
		if(data == null || data.length() ==0){
			validationError = "Dimensions not specified for plateau";
			return false;			
		}else if(data.length() > 2){
			validationError = "Invalid dimension specified for plateau";
			return false;
		}else if(!data.matches("[0-9]+")){
			validationError = "Plateau dimension cannot contain non-numerics";
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
