package marsrover.validator;

import static org.junit.Assert.*;

import marsrover.validator.impl.PlateauDataValidator;

import org.junit.Before;
import org.junit.Test;


public class PlateauDataValidatorTest {

	private PlateauDataValidator validator;
	
	@Before
	public void setUp() {
		validator = new PlateauDataValidator();
	}
	
	@Test
	public void shouldDiscardEmptyData() {
		String data = "";
		assertFalse(validator.valid(data));
		assertEquals("Dimensions not specified for plateau", 
				validator.getValidationError());
	}
	
	@Test
	public void shouldAllowDataOfTwoChars() {
		String data = "12";
		assertTrue(validator.valid(data));
		assertNull(validator.getValidationError());
		
		data = "122";
		assertFalse(validator.valid(data));
		assertEquals("Invalid dimension specified for plateau", 
				validator.getValidationError());
	}
	
	@Test
	public void shouldNotAllowAlphabets() {
		String data = "12";
		assertTrue(validator.valid(data));
		assertNull(validator.getValidationError());
		
		data = "AB";
		assertFalse(validator.valid(data));
		assertEquals("Plateau dimension cannot contain non-numerics", 
				validator.getValidationError());
	}	
	
}
