package utils;

public class Sleep {
    public Sleep(int ms) {
        try {
            Logger logger = LoggerConfig.getLogger();
            logger.info("Attente de " + ms + " secondes");
            Thread.sleep(ms * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
