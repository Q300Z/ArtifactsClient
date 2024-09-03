package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

public class JsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Méthode générique pour convertir une chaîne JSON en un objet de type T
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        Logger logger = LoggerConfig.getLogger();
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    // Méthode générique pour extraire un sous-objet JSON et le convertir en un
    // objet Java
    public static <T> T fromJson(String jsonString, String key, Class<T> clazz) {
        Logger logger = LoggerConfig.getLogger();
        try {
            // Convertit la chaîne JSON en objet JSONObject
            JSONObject json = new JSONObject(jsonString);
            // Récupère la sous-chaîne JSON correspondant à la clé donnée
            String jsonData = json.get(key).toString();
            // Convertit la sous-chaîne JSON en objet
            return objectMapper.readValue(jsonData, clazz);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    // Méthode générique pour extraire un sous-objet JSON et le convertir en un
    // objet Json
    public static JSONObject fromJson(String jsonString, String key) {
        Logger logger = LoggerConfig.getLogger();
        try {
            // Convertit la chaîne JSON en objet JSONObject
            JSONObject json = new JSONObject(jsonString);

            // Récupère la sous-chaîne JSON correspondant à la clé donnée
//            String jsonData = json.get(key).toString();
            // Convertit la sous-chaîne JSON en objet
            return json.optJSONObject(key);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    // Méthode générique pour convertir un objet en une chaîne JSON
    public static <T> String toJson(T object) {
        Logger logger = LoggerConfig.getLogger();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
