import controllers.ApiArtifacts;
import io.github.cdimascio.dotenv.Dotenv;
import models.ContentType;
import models.LogLevel;
import models.characterMovement.MapSchema;
import models.commun.CharacterSchema;
import utils.Logger;
import utils.LoggerConfig;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Dotenv dotenv = Dotenv.load();

        String token = dotenv.get("API_KEY");

        // Initialiser le logger avec le chemin du fichier et le niveau de log
        LoggerConfig.initializeLogger("logs.txt", LogLevel.DEBUG);

        Logger logger = LoggerConfig.getLogger();

        ApiArtifacts api = new ApiArtifacts(token);
        api.status();

        CharacterSchema[] persos = api.myCharacters();

        CharacterSchema perso = persos[0];

//	TODO : Déplacer le personnage
//        api.Actions(perso).move(4, 1);

//	 TODO : Faire déséquiper un item
//	api.Actions(perso).unequip(Slot.WEAPON, 1);

//	 TODO : Faire équipé un item
//	api.Actions(perso).equip("wooden_stick", Slot.WEAPON, 1);

//	 TODO : Faire combattre le personnage
//	api.Actions(perso).fight();

        // TODO : Faire récolter une ressource
//	api.Actions(perso).gathering();

        // TODO :Fabriquer un item
//	api.Actions(perso).crafting("ash_plank", 1);

        // TODO : Déposer en banque un item
//        api.Actions(perso).bank("ash_wood", 1);

        // TODO : Déposer en banque du gold
//	api.Actions(perso).bank(1);
        // TODO : Recycler un item
//	api.Actions(perso).recycling("ash_plank", 1);
        // TODO : Récupérer un item de la banque

        // TODO : Récupérer de l'or de la banque

        // TODO : Acheté un item au grand marché

        // TODO : Vendre un item au grand marché

        // TODO : Acheter de l'espace de stockage dans la banque

        // TODO : Accepter une quête

        // TODO : Compléter une quête

        // TODO : Echanger une quête

        // TODO : Abandonner une quête  

        // TODO : Supprimer un item
        
        // TODO : Rechercher une ressource sur la carte
        MapSchema[] res =  api.Maps().Find(ContentType.RESOURCE, "copper");

        // Fermer le logger lors de la fin de l'application
        LoggerConfig.getLogger().close();
    }

}
