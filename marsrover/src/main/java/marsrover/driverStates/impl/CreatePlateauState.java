package marsrover.driverStates.impl;

import marsrover.NASASignaller;
import marsrover.domain.Plateau;
import marsrover.driverStates.State;
import marsrover.exception.MarsRoverException;
import marsrover.validator.Validator;

public class CreatePlateauState implements State {
	
	private NASASignaller nasaSignaller;
	private Validator plateauDataValidator;
	
	public CreatePlateauState(NASASignaller nasaSignaller, 
			Validator plateauDataValidator) {
		this.nasaSignaller = nasaSignaller;
		this.plateauDataValidator = plateauDataValidator;
	}
	
	@Override
	public void doTask(String data) throws MarsRoverException {
		if(!plateauDataValidator.valid(data))
			throw new MarsRoverException("Data Invalid for Plateau : "
					+plateauDataValidator.getValidationError());
		Plateau plateau = new Plateau();
		plateau.setWidth(getWidth(data));
		plateau.setHeight(getHeight(data));
		nasaSignaller.setPlateau(plateau);
	}

	int getHeight(String data) {
		char height = data.toCharArray()[1];
		return Character.getNumericValue(height);
	}

	int getWidth(String data) {
		char width = data.toCharArray()[0];
		return Character.getNumericValue(width);
	}
}
