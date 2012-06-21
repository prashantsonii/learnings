package com.promouit.gameoflife.io.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.promouit.gameoflife.exception.GameOfLifeException;

public class FileDataWriter implements DataWriter{

	private File file;
	
	public FileDataWriter(String filePath){
		this.file = new File(filePath);
	}
	
	public FileDataWriter(File file){
		this.file = file;
	}
	
	public void writeObject(Object object) throws GameOfLifeException {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			bufferedWriter.write(object.toString());
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e1) {
			throw new GameOfLifeException(e1);
		}
	}
	
}
