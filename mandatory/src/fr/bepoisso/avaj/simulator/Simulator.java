package fr.bepoisso.avaj.simulator;

import fr.bepoisso.avaj.aircraft.AircraftFactory;
import fr.bepoisso.avaj.aircraft.Flyable;
import fr.bepoisso.avaj.exception.InvalidScenarioException;
import fr.bepoisso.avaj.logger.Logger;
import fr.bepoisso.avaj.parser.Parser;
import fr.bepoisso.avaj.weather.WeatherTower;

import java.util.List;

public class Simulator {
	private final String path;
	private List<String[]> scenario;
	private int step;
	private WeatherTower tower;

	public Simulator(String p_path) {
		path = p_path;
	}

	public void parse()
	throws Exception {
		System.out.println("\n--- Parsing Process ---");
		Parser parser = new Parser(path);
		scenario = parser.parse();
	}

	public void factory()
	throws  Exception {
		System.out.println("\n--- Factory Process ---");
		AircraftFactory factory = AircraftFactory.getInstance();
		tower = new WeatherTower();
		step = Integer.parseInt(scenario.get(0)[0]);
		if (step <= 0)
			throw new InvalidScenarioException("Bad time simulation value");

		for (int i = 1; i < scenario.size(); i++) {
			String[] args = scenario.get(i);
			Coordinates coords = new Coordinates(
					Integer.parseInt(args[2]),
					Integer.parseInt(args[3]),
					Integer.parseInt(args[4]));
			Flyable fly = factory.newAircraft(args[0], args[1], coords);
			if (coords.getHeight() > 0)
				fly.registerTower(tower);
		}
	}

	public void run()
	throws Exception {
		System.out.println("\n--- Simulation Process ---");
		for (int i = 0; i < step; ++i) {
			if (!tower.hasObservers())
				break;
			System.out.printf("--Step %d--\n", i + 1);
			tower.changeWeather();
			Logger.getInstance().log("");
		}
		tower.clear();
		Logger.getInstance().close();
	}
}
