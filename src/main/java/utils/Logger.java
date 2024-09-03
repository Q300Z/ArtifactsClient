package utils;

import models.LogLevel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private final LogLevel currentLogLevel;
    private final BufferedWriter writer;

    // Constructeur
    public Logger(String filePath, LogLevel logLevel) throws IOException {
        this.currentLogLevel = logLevel;
        this.writer = new BufferedWriter(new FileWriter(filePath, true)); // true pour append
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    // Méthode pour écrire des logs
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLogLevel.ordinal()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            // Obtient les informations sur l'appelant (classe et méthode)
            String className = stackTrace[3].getClassName();
            String methodName = stackTrace[3].getMethodName();

            try {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                String messageFormat = String.format("%s [%s] %s.%s: %s%n", timestamp, level.name(), className,
                        methodName, message);
                writer.write(messageFormat);
                System.out.printf(messageFormat);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Méthode pour fermer le writer
    public void close() {
        try {
            log(LogLevel.INFO, "Fermeture du programme");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
