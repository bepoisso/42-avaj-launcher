package fr.bepoisso.avaj.parser;

import fr.bepoisso.avaj.exception.InvalidScenarioException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	private Path path = null;

	public Parser(String p_filepath) {
		path = Path.of(p_filepath);
	}

	private List<String[]> parse()
	throws InvalidScenarioException {
		List<String[]> result = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(path);

			for (int i = 0; i < lines.size(); ++i) {
				String line = lines.get(i);
				String[] tokens = line.split("\\s+");
				if (i == 0) {
					if (tokens.length != 1)
						throw new InvalidScenarioException("Bad time simulation argument");
					if (Integer.parseInt(tokens[0]) <= 0)
						throw new InvalidScenarioException("Bad time simulation value");
				}
				else {
					if (!tokens[0].equals("Balloon") && !tokens[0].equals("JetPlane") && !tokens[0].equals("Helicopter"))
						throw new InvalidScenarioException("Unknown aircraft type");
					if (!tokens[1].matches("[a-zA-Z0-9]+"))
						throw new InvalidScenarioException("Bad name type");
					if (tokens.length != 5)
						throw new InvalidScenarioException("Bad number of arguments");
					if (Integer.parseInt(tokens[2]) < 0)
						throw new InvalidScenarioException("Bad longitude value");
					if (Integer.parseInt(tokens[3]) < 0)
						throw new InvalidScenarioException("Bad latitude value");
					if (Integer.parseInt(tokens[4]) < 0)
						throw new InvalidScenarioException("Bad height value");
				}
				result.add(tokens);
			}
		} catch (IOException e) {
			throw new InvalidScenarioException(e.getMessage());
		}
		return result;
	}
}
