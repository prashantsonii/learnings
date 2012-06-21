package com.promouit.novelstring;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProcessor {
	private StringAnalyser stringAnalyser = new StringAnalyser();

	public void processFile(String fileName) {

		try {
			FileReader fileReader = new FileReader(fileName);
			ResultWriter resultWriter = new ResultWriter("novel.out");
			String readLine = null;
			while ((readLine = fileReader.getNextString()) != null) {
				ValidationStatus validationStatus = stringAnalyser
						.validateString(readLine);
				if (validationStatus.equals(ValidationStatus.VALID)) {
					stringAnalyser.isNovelString(readLine);
					resultWriter.writeResult(readLine
							+ stringAnalyser.isNovelString(readLine));
				} else {
					resultWriter.writeResult(readLine + validationStatus);
				}
			}
			fileReader.close();
			resultWriter.closeWriter();
		} catch (FileNotFoundException e) {
			System.out.println("Error reading the file. File Not found : "
					+ fileName);
		} catch (IOException e) {
			System.out.println("Error reading data from file.");
		}
	}

}
