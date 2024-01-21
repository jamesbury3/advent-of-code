package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class Day {

	private boolean printLogs;
	private final String WORKING_DIR;

	public Day() {
		WORKING_DIR = System.getProperty("user.dir") + "/src/";
		printLogs = false;
	}

	public abstract int solve(String filename);

	public void enableLogging() {
		printLogs = true;
	}

	protected List<String> readFile(String filename) {
		Path path = Paths.get(WORKING_DIR + getInputFileDir() + filename);
        try {
            return Files.readAllLines(path);
        } catch (IOException ex) {
            error(ex.toString());
        }
        return null;
	}

	protected void info(Object s) {
		if (printLogs)
			System.out.println(getLogPrefix() + "INFO -- " + s);
	}

	protected void error(Object s) {
		if (printLogs)
			System.out.println(getLogPrefix() + "ERROR -- " + s);
	}

	protected void logFinalValue(int i) {
		if (printLogs)
			System.out.println(getLogPrefix() + "FINAL_VALUE -- " + i);
	}

	private String getLogPrefix() {
		return getClass().getName() + "::";
	}

	private String getInputFileDir() {
		return getClass().getPackage().toString().replace("package ", "").replace(".", "/") + "/";
	}
}