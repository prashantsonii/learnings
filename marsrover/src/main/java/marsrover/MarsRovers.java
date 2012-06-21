package marsrover;

import marsrover.reader.FileInputReader;

public class MarsRovers {
	public static void main(String[] args) {
		if(args.length < 1){
			printUsage();
			System.exit(0);
		}
		
		FileInputReader fileInputReader = new FileInputReader(args[0]);
		String data = null;
		NASASignaller nasaSignaller = NASASignaller.getInstance();
		while((data = fileInputReader.readNextLine())!=null){
			nasaSignaller.processData(data);
		}
		nasaSignaller.printRovers();
		
	}

	private static void printUsage() {
		System.out.println("MarsRovers <fileName>");
	}
}
