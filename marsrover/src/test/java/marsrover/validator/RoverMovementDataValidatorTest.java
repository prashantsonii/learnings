package marsrover.validator;

import static org.junit.Assert.*;

import marsrover.validator.impl.MoveRoverDataValidator;

import org.junit.Before;
import org.junit.Test;


public class RoverMovementDataValidatorTest {

	private MoveRoverDataValidator validator;
	
	@Before
	public void setUp() {
		validator = new MoveRoverDataValidator();
	}
	
	@Test
	public void shouldAllowOnlySpecificChars() {
		assertTrue(validator.valid("MMMMRRRRLL"));
		assertNull(validator.getValidationError());
		
		assertTrue(validator.valid("mMmrRrLlL"));
		assertNull(validator.getValidationError());

		assertFalse(validator.valid("aAbCD"));
		assertEquals("No letters other than M, R and L allowed", 
				validator.getValidationError());
	
	}
	
	@Test
	public void shouldNotAllowNonAlphaChars() {
		assertFalse(validator.valid("12M"));
		assertEquals("No letters other than M, R and L allowed", 
				validator.getValidationError());
	}
	
}
