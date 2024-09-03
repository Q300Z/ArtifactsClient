import controllers.ApiArtifacts;
import io.github.cdimascio.dotenv.Dotenv;
import models.CharacterSchema;
import models.LogLevel;
import utils.LoggerConfig;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Dotenv dotenv = Dotenv.load();
        
        String token = dotenv.get("API_KEY");

        // Initialiser le logger avec le chemin du fichier et le niveau de log
        LoggerConfig.initializeLogger("logs.txt", LogLevel.DEBUG);

        ApiArtifacts api = new ApiArtifacts(token);
        api.status();

        CharacterSchema[] persos = api.myCharacters();

        CharacterSchema perso = persos[0];

//	TODO : Déplacer le personnage
	api.Actions(perso).move(0, 0);

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
//	api.Actions(perso).bank("ash_plank", 1);

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

        // Fermer le logger lors de la fin de l'application
        LoggerConfig.getLogger().close();
    }

}
