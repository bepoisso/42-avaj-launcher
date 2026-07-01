package fr.bepoisso.avaj.aircraft;

import fr.bepoisso.avaj.coordinates.Coordinates;
import fr.bepoisso.avaj.exception.InvalidAircraftException;

public class AircraftFactory {
	private static AircraftFactory instance;
	private static int currentId = 0;

	private AircraftFactory() {}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	throws InvalidAircraftException {
		++currentId;
		Flyable result = null;

		switch (p_type) {
			case "Balloon" ->
				result = new Balloon(currentId, p_name, p_coordinates);
			case "JetPlane" ->
				result = new JetPlane(currentId, p_name, p_coordinates);
			case "Helicopter" ->
				result = new Helicopter(currentId, p_name, p_coordinates);
			default ->
				throw new InvalidAircraftException("Bad aircraft type");
		}
		return result;
	}

	public static AircraftFactory getInstance()
	throws InvalidAircraftException {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}
}
