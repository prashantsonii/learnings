package marsrover.command.impl;

import marsrover.command.Command;
import marsrover.constants.Heading;
import marsrover.domain.Rover;

public class LeftCommand implements Command {

	private Rover rover;
	
	public LeftCommand(Rover rover) {
		this.rover = rover;
	}
	/**
	 * Responsible for changing the head direction of the rover
	 */
	@Override
	public void execute() {
		switch(rover.getHeading()){
		case N:
			rover.setHeading(Heading.W);
			break;
		case S:
			rover.setHeading(Heading.E);
			break;
		case E:
			rover.setHeading(Heading.N);
			break;
		case W:
			rover.setHeading(Heading.S);
			break;
		}
	}

}
