package services;

import java.io.IOException;
import java.util.Objects;

import execptions.ApiException;
import models.MonsterSchema;
import okhttp3.Response;
import utils.Caller;
import utils.JsonConverter;
import utils.Logger;
import utils.LoggerConfig;

public class Monsters {
    private final Logger logger = LoggerConfig.getLogger();

    private final Caller caller;

    public Monsters(Caller caller) {
        this.caller = caller;
    }

    private String RequestAPI(String parms) throws ApiException, IOException {
	Response response = this.caller.get("/resources?" + parms, false);
        return Objects.requireNonNull(response.body()).string();
    }
    
    
    /**
     * Find monsters
     * 
     * @param String drop
     * @param int    minLevel
     * @param int    maxLevel
     * @return MonsterSchema[]
     */
    public MonsterSchema[] Find(String drop, int minLevel, int maxLevel) {
        try {
	    String body = RequestAPI(
		    "min_level=" + minLevel + "&max_level=" + maxLevel + "&drop=" + drop + "&page=1&size=100");

	    return JsonConverter.fromJson(body, "data", MonsterSchema[].class);
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }
}
