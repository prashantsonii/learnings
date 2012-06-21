package com.promouit.gameoflife;

import java.util.Iterator;

import com.promouit.gameoflife.exception.GameOfLifeException;
import com.promouit.gameoflife.io.read.FileDataIterator;
import com.promouit.gameoflife.io.write.DataWriter;
import com.promouit.gameoflife.io.write.FileDataWriter;
import com.promouit.gameoflife.model.Universe;
import com.promouit.gameoflife.model.Universe.UniverseBuilder;

public class TestRunner {
	public static void main(String[] args) throws GameOfLifeException {
		Iterator<String> iterator = new FileDataIterator(args[0]);
		DataWriter writer = new FileDataWriter(args[1]);
		Universe universe = new UniverseBuilder(iterator).buildUniverse();
		universe.tick();
		writer.writeObject(universe);
	}
}
