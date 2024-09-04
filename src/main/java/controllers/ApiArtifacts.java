package controllers;

import models.commun.CharacterSchema;
import models.status.StatusSchema;
import okhttp3.Response;
import services.Actions;
import utils.Caller;
import utils.JsonConverter;
import utils.Logger;
import utils.LoggerConfig;

import java.util.Objects;

public class ApiArtifacts {
    private final Logger logger = LoggerConfig.getLogger();
    private final String url;
    private final Caller caller;

    public ApiArtifacts(String token) {
        this.url = "https://api.artifactsmmo.com";
        this.caller = new Caller(this.url, token);
    }

    public ApiArtifacts(String token, String url) {
        this.url = url;
        this.caller = new Caller(this.url, token);
    }

    public Actions Actions(CharacterSchema character) {
        return new Actions(this.caller, character);
    }

    // Récupére l'état de l'api
    public boolean status() {
        try {
            logger.info("Status de l'API Artifacts : " + this.url);
            Response response = caller.get("/", false);

            StatusSchema status = JsonConverter.fromJson(Objects.requireNonNull(response.body()).string(), "data", StatusSchema.class);

            logger.info(Objects.requireNonNull(status).toString());
            return true;
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération du status de l'API Artifacts : " + e.getMessage());
            return false;
        }
    }

    // Récupére la liste de mes personnages
    public CharacterSchema[] myCharacters() {
        try {
            logger.info("Liste de mes personnages : " + this.url);
            Response response = caller.get("/my/characters");

            CharacterSchema[] persos = JsonConverter.fromJson(Objects.requireNonNull(response.body()).string(), "data",
                    CharacterSchema[].class);

            logger.info("Succès : " + Objects.requireNonNull(persos).length + " personnages récupérés");
            for (CharacterSchema perso : persos) {
                logger.info(perso.getName());
            }
            return persos;
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des personnages : " + e.getMessage());
            return null;
        }
    }
}
