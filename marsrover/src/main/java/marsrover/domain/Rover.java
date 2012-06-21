package marsrover.domain;

import marsrover.constants.Heading;

public class Rover {
	private int xCoordinate;
	private int yCoordinate;
	private Heading heading;

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Heading getHeading() {
		return heading;
	}

	public void setHeading(Heading heading) {
		this.heading = heading;
	}
	
	public String getLocation() {
		StringBuffer location = new StringBuffer();
		location.append(xCoordinate).append(yCoordinate).append(heading);
		return location.toString();
	}
	
}
