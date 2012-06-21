package com.promouit.novelstring;


public class NovelStringFinder {
	public static void main(String[] args) {
		if(args.length < 1){
			printUsage();
			System.exit(0);
		}
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.processFile(args[0]);
	}

	private static void printUsage() {
		System.out.println("Usage : java -jar novelString.jar <inputFilePath>");
	}
}
