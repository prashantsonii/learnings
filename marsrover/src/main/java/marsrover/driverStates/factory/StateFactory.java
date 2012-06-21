package marsrover.driverStates.factory;

import marsrover.NASASignaller;
import marsrover.driverStates.State;
import marsrover.driverStates.impl.CreatePlateauState;
import marsrover.driverStates.impl.CreateRoverState;
import marsrover.driverStates.impl.MoveRoverState;
import marsrover.validator.Validator;
import marsrover.validator.impl.MoveRoverDataValidator;
import marsrover.validator.impl.PlateauDataValidator;
import marsrover.validator.impl.RoverDataValidator;

public class StateFactory {

	public static State getCreatePlateauState(NASASignaller nasaSignaller){
	  	Validator plateauDataValidator = new PlateauDataValidator();
		State createPlateauState = new CreatePlateauState(nasaSignaller, plateauDataValidator);
		return createPlateauState;
	}
	
	public static State getCreateRoverState(NASASignaller nasaSignaller){
		Validator roverDataValidator = new RoverDataValidator();
		State createRoverState = new CreateRoverState(nasaSignaller, roverDataValidator);
		return createRoverState;
	}
	
	public static State getMoveRoverState(NASASignaller nasaSignaller){
		Validator moveRoverDataValidator = new MoveRoverDataValidator();
		State moveRoverState = new MoveRoverState(nasaSignaller, moveRoverDataValidator);
		return moveRoverState;
	}
	
}
