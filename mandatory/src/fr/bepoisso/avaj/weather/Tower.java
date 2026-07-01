package fr.bepoisso.avaj.weather;

import fr.bepoisso.avaj.aircraft.Flyable;
import fr.bepoisso.avaj.exception.InvalidAircraftException;
import fr.bepoisso.avaj.exception.InvalidLoggerException;
import fr.bepoisso.avaj.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private final List<Flyable> observers;

	public Tower() {
		observers = new ArrayList<>();
	}

	public void register(Flyable p_flyable)
	throws InvalidLoggerException,  InvalidAircraftException {
		if (!observers.contains(p_flyable))
			observers.add(p_flyable);
		else
			throw new InvalidAircraftException("Flyable already registered");
		Logger.getInstance().log("Tower says: " + p_flyable.getHeader() + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable)
	throws InvalidAircraftException {
		if (!observers.contains(p_flyable))
			throw new InvalidAircraftException("Flyable not registered");
		observers.remove(p_flyable);
	}

	public void clear() {
		observers.clear();
	}

	protected void conditionChanged() {
		for (Flyable flyable : observers)
			flyable.updateConditions();
	}
}
