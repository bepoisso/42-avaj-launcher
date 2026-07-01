package fr.bepoisso.avaj.aircraft;

import fr.bepoisso.avaj.simulator.Coordinates;
import fr.bepoisso.avaj.exception.InvalidAircraftException;

public class AircraftFactory {
	private static AircraftFactory instance;
	private static int currentId = 0;

	private AircraftFactory() {}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	throws InvalidAircraftException {
		++currentId;

		switch (p_type) {
			case "Balloon" -> {
				return new Balloon(currentId, p_name, p_coordinates);
			}
			case "JetPlane" -> {
				return new JetPlane(currentId, p_name, p_coordinates);
			}
			case "Helicopter" -> {
				return new Helicopter(currentId, p_name, p_coordinates);
			}
			default ->
				throw new InvalidAircraftException("Bad aircraft type");
		}
	}

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}
}
