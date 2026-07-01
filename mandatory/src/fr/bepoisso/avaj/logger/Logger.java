package fr.bepoisso.avaj.logger;

import fr.bepoisso.avaj.exception.InvalidLoggerException;

import java.io.FileWriter;

public class Logger {
	private static Logger instance;
	private FileWriter writer = null;

	private Logger()
	throws InvalidLoggerException {
		try {
			writer = new FileWriter("simulation.txt", false);
		} catch (Exception e) {
			throw new InvalidLoggerException("logger: " + e.getMessage());
		}
	}

	public void log(String s)
	throws InvalidLoggerException {
		try {
			writer.write(s);
			writer.write("\n");
			writer.flush();
		} catch (Exception e) {
			throw new InvalidLoggerException("logger: " + e.getMessage());
		}
	}

	public void close() throws InvalidLoggerException {
		try {
			writer.close();
		} catch (Exception e) {
			throw new InvalidLoggerException("logger: " + e.getMessage());
		}
	}

	public static Logger getInstance()
	throws InvalidLoggerException {
		if (instance == null)
			instance = new Logger();
		return instance;
	}
}
