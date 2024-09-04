package utils;

public class Sleep {
    public Sleep(int ms) {
        try {
            Logger logger = LoggerConfig.getLogger();
            logger.info("Attente de " + ms + " secondes");
            Thread.sleep(ms * 1000L);
            logger.info("Fin de l'attente - Prochaine action");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
