package com.github.sebyplays.logmanager.api;

import com.github.sebyplays.consoleprinterapi.api.ConsolePrinter;
import com.github.sebyplays.logmanager.utils.io.FileManager;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogManager {

    @Getter private static HashMap<String, LogManager> logManagers = new HashMap<>();
    private final FileManager fileManager = new FileManager();
    private String logFile;

    public LogManager(String logFile) throws IOException {
        this.logFile = logFile;
        logManagers.put(logFile, this);
        FileManager fileManager = new FileManager();
        this.logFile = fileManager.initLogFile(logFile);
    }

    public void log(LogType logType, String message, boolean colorize, boolean date, boolean time, boolean print) throws IOException {
        fileManager.log(logFile, ConsolePrinter.getString("[" + logType.getPrefix() + "] -> " + message, colorize, date, time));
        if(print) ConsolePrinter.print("[" + (colorize ? logType.getColor() : "") + logType.getPrefix() + (colorize ? "§r" : "") + "] -> " + message, colorize, date, time);
    }

    public static LogManager getLogManager(String name) throws IOException {
        for (Map.Entry<String, LogManager> entry : LogManager.getLogManagers().entrySet()) {
            if (entry.getKey().equals(name)) return entry.getValue();
        }

        return new LogManager(name);
    }

}
