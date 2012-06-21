package marsrover.driverStates.impl;

import marsrover.NASASignaller;
import marsrover.command.Command;
import marsrover.command.factory.CommandFactory;
import marsrover.domain.Plateau;
import marsrover.domain.Rover;
import marsrover.driverStates.State;
import marsrover.exception.MarsRoverException;
import marsrover.validator.Validator;

public class MoveRoverState implements State {

	private NASASignaller nasaSignaller;
	private Validator moveRollerDataValidator;
	
	public MoveRoverState(NASASignaller nasaSignaller, Validator validator) {
		this.nasaSignaller = nasaSignaller;
		this.moveRollerDataValidator = validator;
	}
	
	@Override
	public void doTask(String data) throws MarsRoverException {
		if(!moveRollerDataValidator.valid(data))
			throw new MarsRoverException("Invalid data for rover movement : "
					+moveRollerDataValidator.getValidationError());
		Rover rover = nasaSignaller.getLastAddedRover();
		char[] commandChars = getCommandChar(data);
		for(char commandChar : commandChars){
			Command command = CommandFactory.getCommand(rover, commandChar);
			command.execute();
			if(roverMetAccident(rover)){
				throw new MarsRoverException("Rover met an accident");
			}
		}
	}

	private boolean roverMetAccident(Rover rover) {
		Plateau plateau = nasaSignaller.getPlateau();
		if(rover.getxCoordinate() < 0 || rover.getxCoordinate() > plateau.getWidth())
			return true;
		if(rover.getyCoordinate() < 0 || rover.getyCoordinate() > plateau.getHeight())
			return true;
		return false;
	}

	private char[] getCommandChar(String data) {
		return data.toCharArray();
	}
}
