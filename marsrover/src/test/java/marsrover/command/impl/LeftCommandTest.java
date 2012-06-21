package marsrover.command.impl;

import static org.junit.Assert.assertEquals;
import marsrover.constants.Heading;
import marsrover.domain.Rover;

import org.junit.Test;

public class LeftCommandTest {

	private LeftCommand leftCommand;
	
	@Test
	public void shouldTurnNorthFacingRoverWest() {
		Rover rover = createRover(Heading.N);
		leftCommand = new LeftCommand(rover);
		leftCommand.execute();
		assertEquals(Heading.W, rover.getHeading());
	}

	@Test
	public void shouldTurnWestFacingRoverSouth() {
		Rover rover = createRover(Heading.W);
		leftCommand = new LeftCommand(rover);
		leftCommand.execute();
		assertEquals(Heading.S, rover.getHeading());
	}

	@Test
	public void shouldTurnSouthFacingRoverEast() {
		Rover rover = createRover(Heading.S);
		leftCommand = new LeftCommand(rover);
		leftCommand.execute();
		assertEquals(Heading.E, rover.getHeading());
	}

	@Test
	public void shouldTurnEastFacingRoverNorth() {
		Rover rover = createRover(Heading.E);
		leftCommand = new LeftCommand(rover);
		leftCommand.execute();
		assertEquals(Heading.N, rover.getHeading());
	}
	
	private Rover createRover(Heading heading) {
		Rover rover = new Rover();
		rover.setHeading(heading);
		return rover;
	}

}
