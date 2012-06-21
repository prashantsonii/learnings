package marsrover.command.impl;

import marsrover.command.Command;
import marsrover.constants.Heading;
import marsrover.domain.Rover;

public class RightCommand implements Command {

	private Rover rover;
	
	public RightCommand(Rover rover) {
		this.rover = rover;
	}
	/**
	 * Responsible for changing the head direction of the rover.
	 */
	@Override
	public void execute() {
		switch(rover.getHeading()){
		case N:
			rover.setHeading(Heading.E);
			break;
		case S:
			rover.setHeading(Heading.W);
			break;
		case E:
			rover.setHeading(Heading.S);
			break;
		case W:
			rover.setHeading(Heading.N);
			break;
		}
	}

}
