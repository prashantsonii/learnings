package marsrover.command.impl;

import static org.junit.Assert.assertEquals;
import marsrover.constants.Heading;
import marsrover.domain.Rover;

import org.junit.Test;


public class RightCommandTest {

	private RightCommand rightCommand;
	
	@Test
	public void shouldTurnNorthFacingRoverEast() {
		Rover rover = createRover(Heading.N);
		rightCommand = new RightCommand(rover);
		rightCommand.execute();
		assertEquals(Heading.E, rover.getHeading());
	}

	@Test
	public void shouldTurnWestFacingRoverNorth() {
		Rover rover = createRover(Heading.W);
		rightCommand = new RightCommand(rover);
		rightCommand.execute();		
		assertEquals(Heading.N, rover.getHeading());
	}

	@Test
	public void shouldTurnSouthFacingRoverWest() {
		Rover rover = createRover(Heading.S);
		rightCommand = new RightCommand(rover);
		rightCommand.execute();
		assertEquals(Heading.W, rover.getHeading());
	}

	@Test
	public void shouldTurnEastFacingRoverSouth() {
		Rover rover = createRover(Heading.E);
		rightCommand = new RightCommand(rover);
		rightCommand.execute();
		assertEquals(Heading.S, rover.getHeading());
	}
	
	private Rover createRover(Heading heading) {
		Rover rover = new Rover();
		rover.setHeading(heading);
		return rover;
	}
	
}
