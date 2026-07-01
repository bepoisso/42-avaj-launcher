package fr.bepoisso.avaj.weather;

import fr.bepoisso.avaj.aircraft.Flyable;
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
	throws InvalidLoggerException {
		if (!observers.contains(p_flyable))
			observers.add(p_flyable);
		Logger.getInstance().log("Tower says: " + p_flyable.getHeader() + " registered to weather tower.");
	}

	public void unregister(Flyable p_flyable) {
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
