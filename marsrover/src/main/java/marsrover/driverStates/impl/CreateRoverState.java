package marsrover.driverStates.impl;

import marsrover.NASASignaller;
import marsrover.constants.Heading;
import marsrover.domain.Rover;
import marsrover.driverStates.State;
import marsrover.exception.MarsRoverException;
import marsrover.validator.Validator;

public class CreateRoverState implements State {
	private NASASignaller nasaSignaller;
	private Validator roverDataValidator;
	
	
	public CreateRoverState(NASASignaller nasaSignaller, Validator roverDataValidator) {
		this.nasaSignaller = nasaSignaller;
		this.roverDataValidator = roverDataValidator;
	}
	
	@Override
	public void doTask(String data) throws MarsRoverException {
		if(!roverDataValidator.valid(data))
			throw new MarsRoverException("Invalid Data for creating Rover : "
					+roverDataValidator.getValidationError());
		Rover rover = new Rover();
		rover.setxCoordinate(getxCoordinate(data));
		rover.setyCoordinate(getyCoordinate(data));
		rover.setHeading(getHeading(data));
		nasaSignaller.addRover(rover);
	}

	int getxCoordinate(String data) {
		char xCoordinateChar = data.toCharArray()[0];
		return Character.getNumericValue(xCoordinateChar);
	}

	int getyCoordinate(String data) {
		char yCoordinateChar = data.toCharArray()[1];
		return Character.getNumericValue(yCoordinateChar);
	}

	Heading getHeading(String data) {
		String headingStr = data.substring(2);
		return Heading.valueOf(headingStr);
	}
	
}
