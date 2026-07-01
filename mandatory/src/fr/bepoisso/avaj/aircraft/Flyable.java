package fr.bepoisso.avaj.aircraft;

import fr.bepoisso.avaj.exception.InvalidAircraftException;
import fr.bepoisso.avaj.exception.InvalidLoggerException;
import fr.bepoisso.avaj.weather.WeatherTower;

public abstract class Flyable {
	protected WeatherTower weatherTower;

	public void registerTower(WeatherTower p_tower)
	throws InvalidAircraftException, InvalidLoggerException {
		this.weatherTower = p_tower;
		p_tower.register(this);
	}

	public abstract void updateConditions();
	public abstract String getHeader();
}
