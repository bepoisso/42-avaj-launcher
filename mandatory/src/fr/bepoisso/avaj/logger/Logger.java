package fr.bepoisso.avaj.logger;

import fr.bepoisso.avaj.exception.InvalidLoggerException;

import java.io.FileWriter;
import java.io.IOException;

// TODO: Sigleton this class
public class Logger {

	FileWriter writer = null;

	public Logger()
	throws InvalidLoggerException {
		try {
			writer = new FileWriter("simulation.txt", true);
		} catch (IOException e) {
			throw new InvalidLoggerException(e.getMessage());
		}
	}

	public void log(String s)
	throws InvalidLoggerException {
		try {
			writer.write(s);
			writer.write("\n");
			writer.flush();
		} catch (IOException e) {
			throw new InvalidLoggerException(e.getMessage());
		}
	}

	public void close() throws InvalidLoggerException {
		try {
			writer.close();
		} catch (IOException e) {
			throw new InvalidLoggerException(e.getMessage());
		}
	}
}
