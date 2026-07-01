package fr.bepoisso.avaj.aircraft;

import fr.bepoisso.avaj.coordinates.Coordinates;
import fr.bepoisso.avaj.exception.InvalidAircraftException;
import fr.bepoisso.avaj.exception.InvalidLoggerException;
import fr.bepoisso.avaj.logger.Logger;

public abstract class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	private void land(String s)
	throws InvalidAircraftException, InvalidLoggerException {
		if (coordinates.getHeight() > 0)
			throw new InvalidAircraftException("Can't land aircraft with height > 0");
		Logger.getInstance().log(getHeader() + " landing.");
		weatherTower.unregister(this);
	}

}
