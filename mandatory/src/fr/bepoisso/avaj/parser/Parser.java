package fr.bepoisso.avaj.parser;

import fr.bepoisso.avaj.exception.InvalidScenarioException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Parser {
	private Path path = null;
	private Files files = null;

	public Parser(String p_filepath)
	throws InvalidScenarioException {
		path = Path.of(p_filepath);
		if (path == null)
			throw new InvalidScenarioException("Bad path");
	}

	private void checkFile()
	throws InvalidScenarioException {
		// TODO add throw handling
		List<String[]> result = null;
		List<String> lines = Files.readAllLines(path);

		for (int i = 0; i < lines.size(); ++i) {
			String line = lines.get(i);
			String[] tokens = line.split("\\s+");
			if (i == 0) {
				if (tokens.lenght != 1)
					throw new InvalidScenarioException("Bad time simulation argument");
				if (Integer.parseInt(tokens[0]) <= 0)
					throw new InvalidScenarioException("Bad time simulation value");
			}
			else {
				if (tokens.lenght != 4)
					throw new InvalidScenarioException("Bad number of arguments");
				if (Integer.parseInt(tokens[2]) < 0)
					throw new InvalidScenarioException("Bad longitude value");
				if (Integer.parseInt(tokens[3]) < 0)
					throw new InvalidScenarioException("Bad latitude value");
				if (Integer.parseInt(tokens[4]) < 0)
					throw new InvalidScenarioException("Bad height value");
			}
			line.add(tokens);
			// TODO fix the add and return it
		}
	}

	public void parse()
	throws InvalidScenarioException {
		checkFile();


	}
}
