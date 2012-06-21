package marsrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import marsrover.domain.Plateau;
import marsrover.domain.Rover;
import marsrover.driverStates.State;
import marsrover.driverStates.factory.StateFactory;
import marsrover.exception.MarsRoverException;

public class NASASignaller {
	private static NASASignaller nasaSignaller;
	
	private Plateau plateau;
	private List<Rover> rovers;
	private int currentStateIndex;
	private List<State> validStates;

	private NASASignaller() {
		rovers = new ArrayList<Rover>();
	}

	static{
    	nasaSignaller = new NASASignaller();
    	List<State> validStates = Arrays.asList(
    			StateFactory.getCreatePlateauState(nasaSignaller), 
    			StateFactory.getCreateRoverState(nasaSignaller), 
    			StateFactory.getMoveRoverState(nasaSignaller));
    	nasaSignaller.setValidStates(validStates);
	}
	
	public static NASASignaller getInstance() {
		return nasaSignaller;
	}
	
	/**
	 * Processes the input data. Based on the currentindex of the valid state,
	 * it invokes the doTask method on the state with the data provided.
	 * It handles the exception, and also changes the state, after each
	 * data handling.
	 */
	public void processData(String data) {
		State state = validStates.get(currentStateIndex);
		try {
			state.doTask(data);
		} catch (MarsRoverException e) {
			System.out.println(e.getMessage());
		}
		currentStateIndex++;
		if (currentStateIndex == validStates.size())
			currentStateIndex = 1;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public void setValidStates(List<State> validStates) {
		this.validStates = validStates;
	}
	
	public void addRover(Rover rover) {
		rovers.add(rover);
	}

	public Plateau getPlateau() {
		return plateau;
	}
	
	public void printRovers() {
		for (Rover rover : rovers)
			System.out.println(rover.getLocation());
	}
	
	public Rover getLastAddedRover() {
		return rovers.get(rovers.size() - 1);
	}
}
