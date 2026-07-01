package fr.bepoisso.avaj.parser;

import fr.bepoisso.avaj.exception.InvalidAircraftException;
import fr.bepoisso.avaj.exception.InvalidScenarioException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	private final Path path;

	public Parser(String p_filepath) {
		path = Path.of(p_filepath);
	}

	public List<String[]> parse()
	throws InvalidScenarioException, InvalidAircraftException {
		List<String[]> result = new ArrayList<>();
		try {
				List<String> lines = null;
			try {
				lines = Files.readAllLines(path);
			} catch (Exception e) {
				throw new InvalidScenarioException("fail to open file " + e.getMessage());
			}
			if (lines.isEmpty())
				throw new InvalidScenarioException("scenario file empty");

			for (int i = 0; i < lines.size(); ++i) {
				String line = lines.get(i);
				String[] tokens = line.split("\\s+");
				if (i == 0) {
					if (tokens.length != 1)
						throw new InvalidScenarioException("bad time simulation argument");
					if (Integer.parseInt(tokens[0]) <= 0)
						throw new InvalidScenarioException("bad time simulation value");
				}
				else if (i == lines.size() - 1 && tokens.length == 1) {
					break;
				}
				else {
					if (tokens.length != 5)
						throw new InvalidScenarioException("bad number of arguments");
					if (!tokens[0].equals("Balloon") && !tokens[0].equals("JetPlane") && !tokens[0].equals("Helicopter"))
						throw new InvalidAircraftException("unknown aircraft type");
					if (!tokens[1].matches("[a-zA-Z0-9]+"))
						throw new InvalidScenarioException("bad name type");
				}
				result.add(tokens);
			}
		} catch (Exception e) {
			throw new InvalidScenarioException(e.getMessage());
		}
		return result;
	}
}
