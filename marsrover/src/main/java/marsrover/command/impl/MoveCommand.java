package marsrover.command.impl;

import marsrover.command.Command;
import marsrover.domain.Rover;

public class MoveCommand implements Command {

	private Rover rover;
	
	private static int MOVE = 1;

	public MoveCommand(Rover rover) {
		this.rover = rover;
	}

	/**
	 * Responsible for advancing the rover in appropriate direction
	 */
	@Override
	public void execute() {
		switch (rover.getHeading()) {
		case N:
			rover.setyCoordinate(rover.getyCoordinate()+MOVE);
			break;
		case S:
			rover.setyCoordinate(rover.getyCoordinate()-MOVE);
			break;
		case E:
			rover.setxCoordinate(rover.getxCoordinate()+MOVE);
			break;
		case W:
			rover.setxCoordinate(rover.getxCoordinate()-MOVE);
			break;
		}
	}
}
