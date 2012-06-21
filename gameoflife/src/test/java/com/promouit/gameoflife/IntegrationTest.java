package com.promouit.gameoflife;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Iterator;

import org.junit.Test;

import com.promouit.gameoflife.exception.GameOfLifeException;
import com.promouit.gameoflife.io.read.FileDataIterator;
import com.promouit.gameoflife.model.Universe;
import com.promouit.gameoflife.model.Universe.UniverseBuilder;

public class IntegrationTest {

	@Test
	public void blinkPatternIntegrationTest() throws FileNotFoundException, GameOfLifeException {
		Iterator<String> iterator = new FileDataIterator("src/test/resources/blinkerpattern.in");
		UniverseBuilder universeBuilder = new UniverseBuilder(iterator);
		Universe universe = universeBuilder.buildUniverse();
		assertEquals("- X - \n- X - \n- X - \n", universe.toString());
		universe.tick();
		assertEquals("- - - \nX X X \n- - - \n", universe.toString());
	}
	
	@Test
	public void bloatPatternIntegrationTest() throws FileNotFoundException, GameOfLifeException {
		Iterator<String> iterator = new FileDataIterator("src/test/resources/bloatpattern.in");
		UniverseBuilder universeBuilder = new UniverseBuilder(iterator);
		Universe universe = universeBuilder.buildUniverse();
		assertEquals("X X - \nX - X \n- X - \n", universe.toString());
		universe.tick();
		assertEquals("X X - \nX - X \n- X - \n", universe.toString());
	}
	
	@Test
	public void blockPatternIntegrationTest() throws FileNotFoundException, GameOfLifeException {
		Iterator<String> iterator = new FileDataIterator("src/test/resources/blockpattern.in");
		UniverseBuilder universeBuilder = new UniverseBuilder(iterator);
		Universe universe = universeBuilder.buildUniverse();
		assertEquals("X X \nX X \n", universe.toString());
		universe.tick();
		assertEquals("X X \nX X \n", universe.toString());
	}
	
	@Test
	public void toadPatternIntegrationTest() throws FileNotFoundException, GameOfLifeException {
		Iterator<String> iterator = new FileDataIterator("src/test/resources/toadpattern.in");
		UniverseBuilder universeBuilder = new UniverseBuilder(iterator);
		Universe universe = universeBuilder.buildUniverse();
		assertEquals("- X X X \nX X X - \n", universe.toString());
		universe.tick();
		assertEquals("- - X - \nX - - X \nX - - X \n- X - - \n", universe.toString());
	}
	
}
