package fr.bepoisso.avaj.weather;

import fr.bepoisso.avaj.coordinates.Coordinates;

public class WeatherProvider {
	private static WeatherProvider instance;
	private String[] weather;

	private WeatherProvider() {}

	public String getCurrentWeather(Coordinates p_coordinates) {
		// TODO
	}

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}
}
