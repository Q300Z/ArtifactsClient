package utils;

import execptions.ApiException;
import models.ApiError;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class Caller {
    private final Logger logger = LoggerConfig.getLogger();
    private final String url;
    private final String token;
    private final OkHttpClient client;

    public Caller(String url, String token) {
        this.url = url;
        this.token = token;
        this.client = new OkHttpClient();
    }

    public Caller(String url) {
        this.url = url;
        this.token = null;
        this.client = new OkHttpClient();
    }

    // Crée une requête HTTP
    private Request createRequest(String href, boolean needToken, RequestBody body) {
        logger.debug("Créer une requête HTTP pour : " + this.url + href);
        Request.Builder builder = new Request.Builder().url(this.url + href).header("Accept", "application/json")
                .header("Content-Type", "application/json");

        if (needToken && this.token != null) {
            logger.debug("Ajout du token à la requète");
            builder.header("Authorization", "Bearer " + this.token);
        }
        if (body != null) {
            logger.debug("Ajout du body à la requète");
            builder.post(body);
        }
        return builder.build();
    }

    // Exécute une requête et retourne la réponse
    private Response executeRequest(Request request) throws IOException {
        logger.info("Exécution de la requête : " + request.url());
        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            logger.error("Échec de la requête : " + e.getMessage());
            throw e; // Relancer l'exception pour que l'appelant puisse gérer cette erreur
        }
    }

    // Crée le body d'une requête POST en format JSON
    public RequestBody createJsonBody(String json) {
        return RequestBody.create(json, MediaType.parse("application/json"));
    }

    // Exécute une requête HTTP avec un body
    private Response execute(String href, boolean needToken, RequestBody body) throws ApiException {
        Response res = null;
        try {
            res = executeRequest(createRequest(href, needToken, body));

            if (!res.isSuccessful()) {
                int statusCode = res.code();
                String responseBody = Objects.requireNonNull(res.body()).string();

                logger.debug("Contenu de la réponse : " + responseBody);
                ApiError error = JsonConverter.fromJson(responseBody, "error", ApiError.class);
                String errorMessage = String.format("Erreur de requête (%d) : %s", Objects.requireNonNull(error).getCode(), error.getMessage());
                throw new ApiException(statusCode, errorMessage);
            }
            return res;

        } catch (IOException e) {
            logger.error("Erreur lors de l'exécution de la requête");
            throw new ApiException(500, "Erreur interne du serveur lors de l'exécution de la requête.");
        } finally {
            if (res != null && !res.isSuccessful()) {
                res.close(); // Assurez-vous de fermer la réponse en cas d'erreur
            }
        }
    }

    // Méthode GET avec authentification par défaut
    public Response get(String href) throws ApiException {
        return get(href, true);
    }

    // Méthode GET avec option d'authentification
    public Response get(String href, boolean needAuth) throws ApiException {
        return execute(href, needAuth, null);
    }

    // Méthode POST avec option d'authentification
    public Response post(String href, String body) throws ApiException {
        RequestBody jsonBody = createJsonBody(body != null ? body : "");

        return execute(href, true, jsonBody);
    }
}
