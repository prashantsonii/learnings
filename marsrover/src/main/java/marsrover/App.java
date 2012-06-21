package marsrover;


public class App {
    public static void main( String[] args ){
    	NASASignaller nasaSignaller = NASASignaller.getInstance();

    	nasaSignaller.processData("55");
    	nasaSignaller.processData("12N");
    	nasaSignaller.processData("LMLMLMLMM");
    	nasaSignaller.processData("33E");
    	nasaSignaller.processData("MMRMMRMRRM");
    	
    	nasaSignaller.printRovers();
    	
    }
}
