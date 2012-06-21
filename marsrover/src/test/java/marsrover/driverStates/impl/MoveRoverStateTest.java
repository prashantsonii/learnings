package marsrover.driverStates.impl;

import marsrover.NASASignaller;
import marsrover.constants.Heading;
import marsrover.domain.Plateau;
import marsrover.domain.Rover;
import marsrover.exception.MarsRoverException;
import marsrover.validator.impl.MoveRoverDataValidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MoveRoverStateTest {
	private MoveRoverState moveRoverState;
	
	@Mock
	private NASASignaller nasaSignaller;
	
	@Mock
	private MoveRoverDataValidator validator;
	
	@Before
	public void setUp() {
		moveRoverState = new MoveRoverState(nasaSignaller, validator);
	}
	
	@Test(expected=MarsRoverException.class)
	public void shouldThrowExceptionForInvalidData() throws MarsRoverException {
		Mockito.when(validator.valid("MRL12DF")).thenReturn(false);
		moveRoverState.doTask("MRL12DF");
	}
	
	@Test
	public void shouldMoveRover() throws MarsRoverException {
		Mockito.when(validator.valid("LMLMLMLMM")).thenReturn(true);
		Rover rover = createDummyRover();
		Mockito.when(nasaSignaller.getLastAddedRover()).thenReturn(rover);
		Mockito.when(nasaSignaller.getPlateau()).thenReturn(createPlateau());
		moveRoverState.doTask("LMLMLMLMM");
		Mockito.verify(nasaSignaller).getLastAddedRover();
		Mockito.verify(nasaSignaller, Mockito.times(9)).getPlateau();
	}

	private Plateau createPlateau() {
		Plateau plateau = new Plateau();
		plateau.setWidth(5);
		plateau.setHeight(5);
		return plateau;
	}

	private Rover createDummyRover() {
		Rover rover = new Rover();
		rover.setHeading(Heading.N);
		rover.setxCoordinate(1);
		rover.setyCoordinate(2);
		return rover;
	}
	
}
