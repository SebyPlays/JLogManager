package de.github.sebyplays.logmanager.api;

import de.github.sebyplays.consoleprinterapi.api.ConsolePrinter;
import de.github.sebyplays.logmanager.utils.io.FileManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogManager {

    private static HashMap<String, LogManager> logManagers = new HashMap<>();
    private String logFile;

    public LogManager(String logFile) throws IOException {
        this.logFile = logFile;
        logManagers.put(logFile, this);
        FileManager fileManager = new FileManager();
        this.logFile = fileManager.initLogFile(logFile);
    }

    public void log(LogType logType, String message, boolean time, boolean print) throws IOException {
        FileManager fileManager = new FileManager();
        fileManager.log(logFile, ConsolePrinter.getString("[" + logType.toString() + "] -> " + message, false, time));
        if(print){
            ConsolePrinter.print("[" + logType.toString() + "] -> " + message, false, time);
        }
    }

    public static HashMap<String, LogManager> getLogManagers() {
        return logManagers;
    }

    public static LogManager getLogManager(String name) throws IOException {
        for (Map.Entry<String, LogManager> entry : LogManager.getLogManagers().entrySet()) {
            if (entry.getKey().equals(name)) return entry.getValue();
        }

        return new LogManager(name);
    }

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager("test").log(LogType.NORMAL, "Test1", true, true);
    }
}
