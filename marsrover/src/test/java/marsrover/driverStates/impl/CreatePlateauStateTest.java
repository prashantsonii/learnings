package marsrover.driverStates.impl;

import static org.junit.Assert.assertEquals;
import marsrover.NASASignaller;
import marsrover.domain.Plateau;
import marsrover.exception.MarsRoverException;
import marsrover.validator.impl.PlateauDataValidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreatePlateauStateTest {

	@Mock
	private NASASignaller nasaSignaller;
	
	@Mock
	private PlateauDataValidator validator;

	private CreatePlateauState state;
	
	@Before
	public void setUp() {
		state = new CreatePlateauState(nasaSignaller, validator);
	}
	
	@Test(expected=MarsRoverException.class)
	public void shouldThrowExceptionForInvalidData() throws MarsRoverException {
		Mockito.when(validator.valid(Mockito.anyString())).thenReturn(false);
		state.doTask("AB");
	}
	
	@Test
	public void shouldAddPlateau() throws MarsRoverException {
		Mockito.when(validator.valid("55")).thenReturn(true);
		state.doTask("55");
		Mockito.verify(nasaSignaller).setPlateau(Mockito.any(Plateau.class));
	}
	
	@Test
	public void shouldReturnHeight() {
		assertEquals('5'-48, state.getHeight("45"));
	}
	
	@Test
	public void shouldReturnWidth(){
		assertEquals('4'-48, state.getWidth("45"));		
	}
}
