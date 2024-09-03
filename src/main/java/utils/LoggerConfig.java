package utils;

import models.LogLevel;

import java.io.IOException;

public class LoggerConfig {
    private static Logger logger;

    // Méthode pour initialiser le logger
    public static void initializeLogger(String filePath, LogLevel logLevel) throws IOException {
        if (logger == null) {
            logger = new Logger(filePath, logLevel);
            logger.info("Logger initialliser");
        }
    }

    // Méthode pour obtenir l'instance du logger
    public static Logger getLogger() {
        if (logger == null) {
            throw new IllegalStateException("Logger is not initialized. Call initializeLogger() first.");
        }
        return logger;
    }
}
