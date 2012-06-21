package com.promouit.gameoflife.io.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import com.promouit.gameoflife.exception.GameOfLifeException;

public class FileDataIterator implements Iterator<String> {

	private BufferedReader bufferedReader;

	public FileDataIterator(String filePath) throws GameOfLifeException {
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath)));
		} catch (FileNotFoundException e) {
			throw new GameOfLifeException(e);
		}
	}

	public boolean hasNext() {
		try {
			bufferedReader.mark(1);
			if (bufferedReader.read() < 0) {
				return false;
			}
			bufferedReader.reset();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public String next() {
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			throw new IllegalStateException("");
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
