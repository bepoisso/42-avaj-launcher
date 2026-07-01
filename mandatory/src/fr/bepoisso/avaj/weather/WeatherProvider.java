package fr.bepoisso.avaj.weather;

import fr.bepoisso.avaj.coordinates.Coordinates;
import fr.bepoisso.avaj.exception.InvalidWeatherException;

public class WeatherProvider {
	private static WeatherProvider instance;
	private String[] weather;

	private WeatherProvider() {}

	public String getCurrentWeather(Coordinates p_coordinates)
	throws InvalidWeatherException {
		int weather = (p_coordinates.getHeight()
				+ p_coordinates.getLatitude()
				+ p_coordinates.getLongitude()) % 4;

		return switch (weather) {
			case 0 -> "RAIN";
			case 1 -> "FOG";
			case 2 -> "SUN";
			case 3 -> "SNOW";
			default -> throw new InvalidWeatherException("Invalid weather value");
		};
	}

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}
}
