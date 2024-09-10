package services;

import java.io.IOException;
import java.util.Objects;

import execptions.ApiException;
import models.CraftSkill;
import models.TypeItem;
import models.item.ItemSchema;
import okhttp3.Response;
import utils.Caller;
import utils.JsonConverter;
import utils.Logger;
import utils.LoggerConfig;

public class Items {
    private final Logger logger = LoggerConfig.getLogger();

    private final Caller caller;

    public Items(Caller caller) {
        this.caller = caller;
    }

    private String RequestAPI(String parms) throws ApiException, IOException {
	Response response = this.caller.get("/items?" + parms, false);
        return Objects.requireNonNull(response.body()).string();
    }
    
    /**
     * Find items
     * 
     * @param craft    String
     * @param skill    CraftSkill
     * @param minLevel int
     * @param maxLevel int
     * @param name     String
     * @param type     TypeItem
     * @return ItemSchema[]
     */
    public ItemSchema[] Find(String craft, CraftSkill skill, int minLevel, int maxLevel, String name, TypeItem type) {
        try {
	    String body = RequestAPI("min_level=" + minLevel + "&max_level=" + maxLevel + "&name=" + name + "&type="
		    + type + "&craft_skill=" + skill + "&craft_material=" + craft + "&page=1&size=100");

	    return JsonConverter.fromJson(body, "data", ItemSchema[].class);
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }
}
