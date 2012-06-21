package marsrover.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInputReader {
	
	private BufferedReader bufferedReader;

	public FileInputReader(String fileName) {
		File file = new File(fileName);
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.println("File Not found : "+fileName);
			System.exit(0);
		}
	}
	
	public String readNextLine() {
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println("Error in reading line");
			System.exit(0);
			return null;
		}
	}
	
}
