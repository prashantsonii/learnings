package com.promouit.gameoflife.io.read;

import static org.junit.Assert.*;

import org.junit.Test;

import com.promouit.gameoflife.exception.GameOfLifeException;
import com.promouit.gameoflife.io.read.FileDataIterator;

public class FileDataIteratorTest {

	@Test
	public void shoulNotThrowExceptionForProperPath() throws GameOfLifeException {
		new FileDataIterator("src/test/resources/blinkerpattern.in");
	}
	
	@Test(expected=GameOfLifeException.class)
	public void shouldThrowExceptionForInvalidPath() throws GameOfLifeException {
		new FileDataIterator("/someDummyPath");
	}

	@Test(expected=UnsupportedOperationException.class)
	public void shouldThrowUnSupportedOperationException() throws GameOfLifeException {
		FileDataIterator iterator = new FileDataIterator("src/test/resources/blinkerpattern.in");
		iterator.remove();
	}
	
	@Test
	public void shouldReadLine() throws GameOfLifeException {
		FileDataIterator iterator = new FileDataIterator("src/test/resources/blinkerpattern.in");
		assertNotNull(iterator.next());
	}
	
	@Test
	public void shouldReturnFalseWhenReachedTheEndOfFile() throws GameOfLifeException {
		FileDataIterator iterator = new FileDataIterator("src/test/resources/blinkerpattern.in");
		assertTrue(iterator.hasNext());
		assertNotNull(iterator.next());
		assertNotNull(iterator.next());
		assertNotNull(iterator.next());
		assertFalse(iterator.hasNext());
	}
	
}
