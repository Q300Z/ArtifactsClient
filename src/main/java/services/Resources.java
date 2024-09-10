package services;

import java.io.IOException;
import java.util.Objects;

import execptions.ApiException;
import models.CraftSkill;
import models.ResourceSchema;
import okhttp3.Response;
import utils.Caller;
import utils.JsonConverter;
import utils.Logger;
import utils.LoggerConfig;

public class Resources {
    private final Logger logger = LoggerConfig.getLogger();

    private final Caller caller;

    public Resources(Caller caller) {
        this.caller = caller;
    }

    /**
     * Find resources
     * 
     * @param String drop
     * @param int    minLevel
     * @param int    maxLevel
     * @return ResourceSchema[]
     */
    private String RequestAPI(String parms) throws ApiException, IOException {
	Response response = this.caller.get("/resources?" + parms, false);
        return Objects.requireNonNull(response.body()).string();
    }
    
/**
 * Find resources
 * 
 * @param drop     String
 * @param minLevel int
 * @param maxLevel int
 * @param skill    CraftSkill : Allowed values: "mining", "woodcutting",
 *                 "fishing"
 * @return
 */
    public ResourceSchema[] Find(String drop, int minLevel, int maxLevel, CraftSkill skill) {
        try {
	    String body = RequestAPI(
		    "min_level=" + minLevel + "&max_level=" + maxLevel + "&skill=" + skill + "&drop=" + drop
			    + "&page=1&size=100");

	    return JsonConverter.fromJson(body, "data", ResourceSchema[].class);
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }
}
