package marsrover.driverStates.impl;

import static org.junit.Assert.assertEquals;
import marsrover.NASASignaller;
import marsrover.constants.Heading;
import marsrover.domain.Rover;
import marsrover.exception.MarsRoverException;
import marsrover.validator.impl.RoverDataValidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateRoverStateTest {
	private CreateRoverState state;
	
	@Mock
	private NASASignaller nasaSignaller;
	
	@Mock
	private RoverDataValidator dataValidator;
	
	@Before
	public void setUp() {
		state = new CreateRoverState(nasaSignaller, dataValidator);
	}
	
	@Test(expected=MarsRoverException.class)
	public void shouldThrowExceptionForInvalidData() throws MarsRoverException {
		Mockito.when(dataValidator.valid("333")).thenReturn(false);
		state.doTask("333");
	}
	
	@Test
	public void shouldAddRover() throws MarsRoverException {
		Mockito.when(dataValidator.valid("12N")).thenReturn(true);
		state.doTask("12N");
		Mockito.verify(nasaSignaller).addRover(Mockito.any(Rover.class));
	}
	
	@Test
	public void shouldGetXCoordinate() {
		assertEquals('1'-48, state.getxCoordinate("12N"));
	}

	@Test
	public void shouldGetYCoordinate() {
		assertEquals('2'-48, state.getyCoordinate("12N"));
	}
	
	@Test
	public void shouldGetHeading() {
		assertEquals(Heading.N, state.getHeading("12N"));
	}
}
