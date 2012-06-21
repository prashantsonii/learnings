package marsrover.command.factory;

import marsrover.command.Command;
import marsrover.command.impl.LeftCommand;
import marsrover.command.impl.MoveCommand;
import marsrover.command.impl.RightCommand;
import marsrover.domain.Rover;

public class CommandFactory {

	/**
	 * Responsible for creating the appropriate command object.
	 */
	public static Command getCommand(Rover rover, char commandChar){
		switch(commandChar){
			case 'l':
			case 'L':
				return new LeftCommand(rover);
			case 'r':
			case 'R':
				return new RightCommand(rover);
			case 'm':
			case 'M':
				return new MoveCommand(rover);
		}
		return null;
	}
	
}