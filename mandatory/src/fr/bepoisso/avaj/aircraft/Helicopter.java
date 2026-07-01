package fr.bepoisso.avaj.aircraft;

import fr.bepoisso.avaj.simulator.Coordinates;
import fr.bepoisso.avaj.exception.InvalidAircraftException;
import fr.bepoisso.avaj.exception.InvalidLoggerException;
import fr.bepoisso.avaj.logger.Logger;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions()
	throws InvalidAircraftException, InvalidLoggerException {
		String weather = weatherTower.getWeather(coordinates);

		switch (weather) {
			case "RAIN": {
				coordinates.increaseLongitude(5);
				Logger.getInstance().log(getHeader() + ": Sun’s out, rotors out, let’s fly.");
				break;
			}
			case "FOG": {
				coordinates.increaseLongitude(1);
				Logger.getInstance().log(getHeader() + ": Rain hitting hard, visibility is not great.");
				break;
			}
			case "SUN": {
				coordinates.increaseLongitude(10);
				coordinates.increaseHeight(2);
				Logger.getInstance().log(getHeader() + ": Fog is messing with my sensors, I’m guessing my way.");
				break;
			}
			case "SNOW": {
				coordinates.decreaseHeight(12);
				Logger.getInstance().log(getHeader() + ": Snow is freezing my rotor, this is painful.");
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
		return String.format("Helicopter#%s(%d)", name, id);
	}
}
