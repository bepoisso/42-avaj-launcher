package fr.bepoisso.avaj.simulator;

import fr.bepoisso.avaj.exception.InvalidCoordinateException;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height)
	throws InvalidCoordinateException {
		if (p_latitude < 0 || p_longitude < 0)
			throw new InvalidCoordinateException("Bad arguments");
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	public void checkValue() {
		if (height > 100)
			height = 100;
		else if (height < 0)
			height = 0;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}

	public void increaseLongitude(int n) {
		longitude += n;
	}

	public void increaseLatitude(int n) {
		latitude += n;
	}

	public void increaseHeight(int n) {
		height += n;
	}

	public void decreaseLongitude(int n) {
		longitude -= n;
	}

	public void decreaseLatitude(int n) {
		latitude -= n;
	}

	public void decreaseHeight(int n) {
		height -= n;
	}


}
