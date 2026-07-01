package fr.bepoisso.avaj.coordinates;

import fr.bepoisso.avaj.aircraft.AircraftFactory;
import fr.bepoisso.avaj.aircraft.Flyable;
import fr.bepoisso.avaj.parser.Parser;

import java.util.List;

public class Simulator {
	private final String path;
	private List<String[]> scenario;
	private List<Flyable> flyables;

	public Simulator(String p_path) {
		path = p_path;
	}

	public void parse()
	throws Exception {
		Parser parser = new Parser(path);
		scenario = parser.parse();
	}

	public void factory()
	throws  Exception {
		AircraftFactory factory = AircraftFactory.getInstance();
		for (int i = 1; i < scenario.size(); i++) {
			String[] ss = scenario.get(i);
			Coordinates coords = new Coordinates(
					Integer.parseInt(ss[2]),
					Integer.parseInt(ss[3]),
					Integer.parseInt(ss[4]));
			flyables.add(factory.newAircraft(ss[0], ss[1], coords));
		}
	}

	public void run()
	throws Exception {

	}
}
