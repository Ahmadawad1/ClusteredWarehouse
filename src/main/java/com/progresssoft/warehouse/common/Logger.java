package com.progresssoft.warehouse.common;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private PrintWriter logFile;

    private Logger() {
        try {
            logFile = new PrintWriter(new FileWriter("application.log", true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logFile.println(timestamp + " - " + message);
    }

    public void close() {
        if (logFile != null) {
            logFile.close();
        }
    }
}
