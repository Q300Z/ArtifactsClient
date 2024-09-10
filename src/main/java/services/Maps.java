package services;

import java.io.IOException;
import java.util.Objects;

import execptions.ApiException;
import models.ContentType;
import models.characterMovement.MapSchema;
import okhttp3.Response;
import utils.Caller;
import utils.JsonConverter;
import utils.Logger;
import utils.LoggerConfig;

public class Maps {
    private final Logger logger = LoggerConfig.getLogger();

    private final Caller caller;

    public Maps(Caller caller) {
        this.caller = caller;
    }

    private String RequestAPI(String parms) throws ApiException, IOException {
        Response response = this.caller.get("/maps?" + parms, false);
        return Objects.requireNonNull(response.body()).string();
    }
    
    /**
     * Find all maps
     * 
     * @param type        ContentType
     * @param contentCode String
     * @return MapSchema[]
     */
    public MapSchema[] Find(ContentType type, String contentCode) {
        try {
            String body = RequestAPI("content_type=" + type.toValue() + "&content_code=" + contentCode+ "&page=1&size=100");

            return JsonConverter.fromJson(body, "data", MapSchema[].class);
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }
}
