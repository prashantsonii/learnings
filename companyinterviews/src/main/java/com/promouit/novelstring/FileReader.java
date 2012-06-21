package com.promouit.novelstring;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {

	private BufferedReader bufferedReader;
	
	private static final String fileEnd = "$$";
	
	public FileReader(String filePath) throws FileNotFoundException {
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
	}
	
	public String getNextString() throws IOException {
		String readLine = bufferedReader.readLine();
		if(fileEnd.equals(readLine))
			return null;
		return readLine;
	}
	
	public void close() throws IOException {
		bufferedReader.close();
	}
}
