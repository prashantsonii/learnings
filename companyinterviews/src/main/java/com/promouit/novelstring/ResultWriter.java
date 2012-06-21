package com.promouit.novelstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {

	private BufferedWriter bufferedWriter;
	
	public ResultWriter(String path) throws IOException {
		bufferedWriter = new BufferedWriter(new FileWriter(path));
	}

	public void writeResult(String result) throws IOException {
		bufferedWriter.write(result+"\n");
	}
	
	public void closeWriter() throws IOException {
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
}
