package marsrover.command.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import marsrover.constants.Heading;
import marsrover.domain.Rover;


public class MoveCommandTest {

	private MoveCommand moveCommand;

	@Test
	public void shouldIncrementYcoordinateForNorthMovement() {
		Rover rover = createRover(10, 10, Heading.N);
		moveCommand = new MoveCommand(rover);
		moveCommand.execute();
		assertEquals(11, rover.getyCoordinate());
	}

	@Test
	public void shouldDecrementYcoordinateForSouthMovement() {
		Rover rover = createRover(10, 10, Heading.S);
		moveCommand = new MoveCommand(rover);
		moveCommand.execute();
		assertEquals(9, rover.getyCoordinate());
	}

	@Test
	public void shouldIncrementXcoordinateForEastMovement() {
		Rover rover = createRover(10, 10, Heading.E);
		moveCommand = new MoveCommand(rover);
		moveCommand.execute();
		assertEquals(11, rover.getxCoordinate());
	}

	@Test
	public void shouldDecrementXcoordinateForWestMovement() {
		Rover rover = createRover(10, 10, Heading.W);
		moveCommand = new MoveCommand(rover);
		moveCommand.execute();
		assertEquals(9, rover.getxCoordinate());
	}
	
	private Rover createRover(int x, int y, Heading heading) {
		Rover rover = new Rover();
		rover.setxCoordinate(x);
		rover.setyCoordinate(y);
		rover.setHeading(heading);
		return rover;
	}
	
}
