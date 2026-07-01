package fr.bepoisso.avaj.aircraft;

import fr.bepoisso.avaj.coordinates.Coordinates;
import fr.bepoisso.avaj.exception.InvalidAircraftException;
import fr.bepoisso.avaj.exception.InvalidLoggerException;
import fr.bepoisso.avaj.logger.Logger;

import java.beans.Expression;

public class Balloon extends Aircraft {
	public Balloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public  void updateConditions()
	throws InvalidAircraftException, InvalidLoggerException {
		String weather = weatherTower.getWeather(coordinates);

		switch (weather) {
			case "RAIN": {
				coordinates.decreaseHeight(5);
				Logger.getInstance().log(getHeader() + ": Nice weather, I’m floating peacefully.");
				break;
			}
			case "FOG": {
				coordinates.decreaseHeight(3);
				Logger.getInstance().log(getHeader() + ": Rain again... I’m basically a wet balloon now.");
				break;
			}
			case "SUN": {
				coordinates.increaseLongitude(2);
				coordinates.increaseHeight(4);
				Logger.getInstance().log(getHeader() + ": Fog everywhere, I can’t see anything, not even myself.");
				break;
			}
			case "SNOW": {
				coordinates.decreaseHeight(15);
				Logger.getInstance().log(getHeader() + ": Snow is falling, I think I’m becoming an ice cube.");
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
		return String.format("Balloon#%s(%d)", name, id);
	}
}
