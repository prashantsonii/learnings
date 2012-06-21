package com.promouit.gameoflife.io.write;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.promouit.gameoflife.exception.GameOfLifeException;
import com.promouit.gameoflife.model.Universe;
import com.promouit.gameoflife.model.Universe.UniverseBuilder;


public class FileDataWriterTest {

	@Test(expected=GameOfLifeException.class)
	public void shouldThrowExceptionForInvalidPath() throws GameOfLifeException {
		String filePath = "\\//)(*&^";
		FileDataWriter writer = new FileDataWriter(filePath);
		writer.writeObject(getUniverse());
	}
	
	@Test
	public void shouldWriteData() throws GameOfLifeException {
		String filePath = "sample";
		FileDataWriter writer = new FileDataWriter(filePath);
		writer.writeObject(getUniverse());
		File file = new File("sample");
		assertTrue(file.length() > 0);
		file.delete();
		assertFalse(file.exists());
	}

	@Test
	public void shouldAppendData() throws GameOfLifeException {
		String filePath = "sample";
		FileDataWriter writer = new FileDataWriter(filePath);
		writer.writeObject(getUniverse());
		File file = new File("sample");
		long lengthBeforeWrite = file.length();
		writer.writeObject(getUniverse());
		long lengthAfterSecondWrite = file.length();
		assertTrue(lengthAfterSecondWrite > lengthBeforeWrite);
		file.delete();
		assertFalse(file.exists());
	}
	
	public Universe getUniverse() {
		List<String> allCellStates = Arrays.asList("X X", "X X");
		return new UniverseBuilder(allCellStates.iterator()).buildUniverse();
	}

}
