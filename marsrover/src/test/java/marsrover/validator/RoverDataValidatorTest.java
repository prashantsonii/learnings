package marsrover.validator;

import static org.junit.Assert.*;

import marsrover.validator.impl.RoverDataValidator;

import org.junit.Before;
import org.junit.Test;


public class RoverDataValidatorTest {

	private RoverDataValidator validator;
	
	@Before
	public void setUp() {
		validator = new RoverDataValidator();
	}
	
	@Test
	public void shouldNotAllowDataMoreThan3Chars() {
		assertFalse(validator.valid("122F"));
		assertEquals("Invalid position / heading specified for the rover", validator.getValidationError());
		assertTrue(validator.valid("22N"));
		assertNull(validator.getValidationError());
	}
	
	@Test
	public void shouldAllowOnlySpecifiedChars() {
		assertTrue(validator.valid("22E"));
		assertTrue(validator.valid("22e"));
		assertTrue(validator.valid("22W"));
		assertTrue(validator.valid("22w"));
		assertTrue(validator.valid("22N"));
		assertTrue(validator.valid("22n"));
		assertTrue(validator.valid("22S"));
		assertTrue(validator.valid("22s"));
		assertNull(validator.getValidationError());
		
		assertFalse(validator.valid("22X"));
		assertEquals("Invalid characters for position / heading", validator.getValidationError());
	}
	
}
