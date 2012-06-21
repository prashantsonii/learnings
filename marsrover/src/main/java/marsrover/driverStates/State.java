package marsrover.driverStates;

import marsrover.exception.MarsRoverException;


public interface State {
	void doTask(String data) throws MarsRoverException;
}
