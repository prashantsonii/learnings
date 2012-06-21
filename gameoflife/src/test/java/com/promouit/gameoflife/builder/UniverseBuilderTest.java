package com.promouit.gameoflife.builder;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.promouit.gameoflife.exception.GameOfLifeException;
import com.promouit.gameoflife.model.Universe.UniverseBuilder;

public class UniverseBuilderTest {

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNullIterator()
			throws GameOfLifeException {
		UniverseBuilder builder = new UniverseBuilder(null);
		builder.buildUniverse();
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionForInvalidInput() throws GameOfLifeException {
		MockedDataIterator dataIterator = new MockedDataIterator(Arrays.asList("1 2", "3 4 5"));
		UniverseBuilder builder = new UniverseBuilder(dataIterator);
		builder.buildUniverse();
	}

	@Test
	public void shouldCreateTheUniverse() throws GameOfLifeException {
		MockedDataIterator dataIterator = new MockedDataIterator(Arrays.asList("X - -", "X X X"));
		UniverseBuilder builder = new UniverseBuilder(dataIterator);
		assertNotNull(builder.buildUniverse());
	}
	
	private class MockedDataIterator implements Iterator<String> {

		private List<String> dummyData = null;
		private Iterator<String> iterator = null;

		public MockedDataIterator(List<String> list) {
			dummyData = list;
			iterator = dummyData.iterator();
		}

		public boolean hasNext() {
			return iterator.hasNext();
		}

		public String next() {
			return iterator.next();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
