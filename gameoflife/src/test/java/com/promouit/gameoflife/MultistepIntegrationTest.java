package com.promouit.gameoflife;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.promouit.gameoflife.exception.GameOfLifeException;
import com.promouit.gameoflife.io.read.FileDataIterator;
import com.promouit.gameoflife.io.write.DataWriter;
import com.promouit.gameoflife.io.write.FileDataWriter;
import com.promouit.gameoflife.model.Universe;
import com.promouit.gameoflife.model.Universe.UniverseBuilder;

public class MultistepIntegrationTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void blinkPatternIntegrationTest() throws GameOfLifeException, IOException {
		Iterator<String> iterator = new FileDataIterator("src/test/resources/integrationtest.in");
		UniverseBuilder universeBuilder = new UniverseBuilder(iterator);
		Universe universe = universeBuilder.buildUniverse();
		assertEquals("X X X \nX X X \nX X X \n", universe.toString());
		universe.tick();
		assertEquals("- - X - - \n- X - X - \nX - - - X \n- X - X - \n- - X - - \n", universe.toString());
		universe.tick();
		assertEquals("- - X - - \n- X X X - \nX X - X X \n- X X X - \n- - X - - \n", universe.toString());
		universe.tick();
		assertEquals("- X X X - \nX - - - X \nX - - - X \nX - - - X \n- X X X - \n", universe.toString());
		universe.tick();
		assertEquals("- - - X - - - \n- - X X X - - \n- X - X - X - \nX X X - X X X \n- X - X - X - \n- - X X X - - \n- - - X - - - \n", universe.toString());
		File newFile = folder.newFile();
		assertTrue(newFile.length()==0);
		DataWriter writer = new FileDataWriter(newFile);
		writer.writeObject(universe);
		assertTrue(newFile.exists());
		assertTrue(newFile.length()>0);
	}	
}
