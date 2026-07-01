package fr.bepoisso.avaj.weather;

import fr.bepoisso.avaj.simulator.Coordinates;

public class WeatherProvider {
	private static WeatherProvider instance;
	private final String[] weather;

	private WeatherProvider() {
		this.weather = new String[4];
		this.weather[0] = "RAIN";
		this.weather[1] = "FOG";
		this.weather[2] = "SUN";
		this.weather[3] = "SNOW";
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		int n = (p_coordinates.getHeight()
				+ p_coordinates.getLatitude()
				+ p_coordinates.getLongitude()) % 4;
		return weather[n];
	}

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}
}
