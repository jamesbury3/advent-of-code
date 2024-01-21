package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class Day {

	private boolean printLogs = false;
	
	public abstract int solve(String filename);
	private static String workingDir = System.getProperty("user.dir") + "/src/";

	protected void info(Object s) {
		if (printLogs)
			System.out.println(getLogPrefix() + "INFO -- " + s);
	}

	protected void error(Object s) {
		if (printLogs)
			System.out.println(getLogPrefix() + "ERROR -- " + s);
	}

	private String getLogPrefix() {
		return getClass().getName() + "::";
	}

	protected List<String> readFile(String filename) {
		Path path = Paths.get(workingDir + filename);
		System.out.println(workingDir);
        try {
            return Files.readAllLines(path);
        } catch (IOException ex) {
            error(ex.toString());
        }
        return null;
	}

	public void enableLogging() {
		printLogs = true;
	}
}