package fr.bepoisso.avaj.coordinates;

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

	private void checkValue() {
		if (height > 100)
			height = 100;
		if (height <= 0);
			// Land the aircraft. unregisters from the weather tower, and logs a message.
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

	public void additionLongitude(int n) {
		longitude += n;
	}

	public void additionLatitude(int n) {
		latitude += n;
	}

	public void additionHeight(int n) {
		height += n;
	}

	public void substractLongitude(int n) {
		longitude -= n;
	}

	public void substractLatitude(int n) {
		latitude -= n;
	}

	public void substractHeight(int n) {
		height -= n;
	}


}
