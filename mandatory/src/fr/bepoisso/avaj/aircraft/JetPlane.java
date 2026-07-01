package fr.bepoisso.avaj.aircraft;

import fr.bepoisso.avaj.coordinates.Coordinates;
import fr.bepoisso.avaj.exception.InvalidAircraftException;
import fr.bepoisso.avaj.exception.InvalidLoggerException;
import fr.bepoisso.avaj.logger.Logger;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions()
	throws InvalidAircraftException, InvalidLoggerException {
		String weather = weatherTower.getWeather(coordinates);

		switch (weather) {
			case "RAIN": {
				coordinates.increaseLatitude(5);
				Logger.getInstance().log(getHeader() + ": Clear sky, perfect cruising altitude.");
				break;
			}
			case "FOG": {
				coordinates.increaseLatitude(1);
				Logger.getInstance().log(getHeader() + ": Rain detected, adjusting course slightly.");
				break;
			}
			case "SUN": {
				coordinates.increaseLatitude(10);
				coordinates.increaseHeight(2);
				Logger.getInstance().log(getHeader() + ": Fog ahead, switching to instruments only.");
				break;
			}
			case "SNOW": {
				coordinates.decreaseHeight(7);
				Logger.getInstance().log(getHeader() + ": Snow conditions, still faster than everything else.");
				break;
			}
			default:
				break;
		}
		coordinates.checkValue();

		if (coordinates.getHeight() <= 0)
			land();
	}

	@Override
	public String getHeader() {
		return String.format("JetPlane#%s(%d)", name, id);
	}
}
