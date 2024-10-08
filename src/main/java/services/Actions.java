package services;

import execptions.ApiException;
import models.GETransaction.GETransactionListSchema;
import models.bankExtension.BankExtensionTransactionSchema;
import models.bankTransaction.BankGoldTransactionSchema;
import models.bankTransaction.BankItemTransactionSchema;
import models.characterFight.CharacterFightDataSchema;
import models.characterMovement.CharacterMovementDataSchema;
import models.commun.CharacterSchema;
import models.equipRequest.EquipRequestSchema;
import models.equipRequest.Slot;
import models.recycling.RecyclingDataSchema;
import models.skill.SkillDataSchema;
import models.task.TaskCancelledSchema;
import models.task.TaskDataSchema;
import models.task.TaskRewardDataSchema;
import okhttp3.Response;
import org.json.JSONObject;
import utils.*;

import java.io.IOException;
import java.util.Objects;

public class Actions {
    private final Logger logger = LoggerConfig.getLogger();

    private final Caller caller;
    private final CharacterSchema character;

    public Actions(Caller caller, CharacterSchema character) {
        this.caller = caller;
        this.character = character;
    }

    /**
     * Déplace le personnage à la position x et y
     *
     * @param x : position x
     * @param y : position y
     */
    public void move(int x, int y) {

        JSONObject obj = new JSONObject();
        obj.put("x", x);
        obj.put("y", y);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/move", obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            CharacterMovementDataSchema res = JsonConverter.fromJson(body, "data", CharacterMovementDataSchema.class);

            logger.info("Déplacement de " + this.character.getName() + " en " + x + ":" + y + " dans "
                    + Objects.requireNonNull(res).getCooldown().getRemaining_seconds() + " secondes");

            new Sleep(res.getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Equipe un équipement
     *
     * @param code     : code de l'item
     * @param slot     : slot de l'inventaire
     * @param quantity : quantité à équiper
     */
    public void equip(String code, Slot slot, int quantity) {

        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("slot", slot.toString());
        obj.put("quantity", quantity);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/equip", obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            EquipRequestSchema res = JsonConverter.fromJson(body, "data", EquipRequestSchema.class);

            logger.info("Equipement de " + this.character.getName() + " avec " + code + " dans "
                    + Objects.requireNonNull(res).getCooldown().getRemaining_seconds() + " secondes");
            new Sleep(res.getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Déséquipe un équipement
     *
     * @param slot     : slot de l'inventaire
     * @param quantity : quantité à déséquiper
     */
    public void unequip(Slot slot, int quantity) {

        JSONObject obj = new JSONObject();
        obj.put("slot", slot.toString());
        obj.put("quantity", quantity);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/unequip", obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            EquipRequestSchema res = JsonConverter.fromJson(body, "data", EquipRequestSchema.class);

            logger.info("Déséquipement de " + this.character.getName() + " avec " + slot + " dans "
                    + Objects.requireNonNull(res).getCooldown().getRemaining_seconds() + " secondes");
            new Sleep(res.getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Attaque un ennemi
     */
    public void fight() {
        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/fight", "");
            String body = Objects.requireNonNull(response.body()).string();

            CharacterFightDataSchema res = JsonConverter.fromJson(body, "data", CharacterFightDataSchema.class);

            logger.info("Résultat du combat de " + this.character.getName() + " : "
                    + Objects.requireNonNull(res).getFight().getResult().toString() + " - Expérience : " + res.getFight().getXp());
            new Sleep(res.getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Récolte une ressource
     */
    public void gathering() {
        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/gathering", "");
            String body = Objects.requireNonNull(response.body()).string();

            SkillDataSchema res = JsonConverter.fromJson(body, "data", SkillDataSchema.class);

            logger.info("Résultat de la récolte de " + this.character.getName() + " : Expérience :"
                    + Objects.requireNonNull(res).getDetails().getXp());
            new Sleep(res.getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }


    /**
     * Fabrique un item
     * @param code    : code de l'item
     * @param quantity : quantité à fabriquer
     */
    public void crafting(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/crafting",
                    obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            SkillDataSchema res = JsonConverter.fromJson(body, "data", SkillDataSchema.class);

            logger.info("Résultat de la fabrication de " + this.character.getName() + " : Expérience :"
                    + Objects.requireNonNull(res).getDetails().getXp());
            new Sleep(res.getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }

    }

    /**
     * Dépose un item dans la banque
     * @param code    : code de l'item
     * @param quantity : quantité à déposer
     */
    public void bank(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/bank/deposit",
                    obj.toString());
            String body = Objects.requireNonNull(response.body()).string();
            
            BankItemTransactionSchema res = JsonConverter.fromJson(body, "data", BankItemTransactionSchema.class);

            logger.info("Transaction d'Item de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }

    }

    /**
     * Dépose de l'or dans la banque
     * @param quantity : quantité à déposer
     */
    public void bank(int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("quantity", quantity);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/bank/deposit/gold",
                    obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            BankGoldTransactionSchema res = JsonConverter.fromJson(body, "data", BankGoldTransactionSchema.class);

            logger.info("Transaction d'Or de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }

    }

    /**
     * Retire un item de la banque
     * @param code : code de l'item
     * @param quantity : quantité à retirer
     */
    public void takeInBank(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/bank/withdraw",
                    obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            BankItemTransactionSchema res = JsonConverter.fromJson(body, "data", BankItemTransactionSchema.class);

            logger.info("Transaction d'Item de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }

    }

    /**
     * Retire de l'or de la banque
     * @param quantity : quantité à retirer
     */
    public void takeInBank(int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("quantity", quantity);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/bank/withdraw/gold",
                    obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            BankGoldTransactionSchema res = JsonConverter.fromJson(body, "data", BankGoldTransactionSchema.class);

            logger.info("Transaction d'Or de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }

    }

    /**
     * Recycle un item
     * @param code : code de l'item
     * @param quantity : quantité à recycler
     */
    public void recycling(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/recycling",
                    obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            RecyclingDataSchema res = JsonConverter.fromJson(body, "data", RecyclingDataSchema.class);

            logger.info("Recyclage de l'item " + code + " de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Achète un item dans le grand marché
     * @param code : code de l'item
     * @param quantity : quantité à acheter
     * @param price : prix d'achat
     */
    public void buyItem(String code, int quantity, int price) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);
        obj.put("price", price);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/ge/buy",
                    obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            GETransactionListSchema res = JsonConverter.fromJson(body, "data", GETransactionListSchema.class);

            logger.info("Achat de l'item " + code + " de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Vend un item dans le grand marché
     * @param code : code de l'item
     * @param quantity : quantité à vendre
     * @param price : prix de vente
     */
    public void sellItem(String code, int quantity, int price) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);
        obj.put("price", price);

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/ge/sell",
                    obj.toString());
            String body = Objects.requireNonNull(response.body()).string();

            GETransactionListSchema res = JsonConverter.fromJson(body, "data", GETransactionListSchema.class);

            logger.info("Vente de l'item " + code + " de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Achète une extension de banque
     */
    public void buyBankExpansion() {

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/bank/buy_expansion",
                    "");
            String body = Objects.requireNonNull(response.body()).string();

            BankExtensionTransactionSchema res = JsonConverter.fromJson(body, "data", BankExtensionTransactionSchema.class);

            logger.info("Achat d'une extension de banque pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Accepte une nouvelle tâche
     */
    public void newTask() {

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/task/new",
                    "");
            String body = Objects.requireNonNull(response.body()).string();

            TaskDataSchema res = JsonConverter.fromJson(body, "data", TaskDataSchema.class);

            logger.info("Nouvelle tâche accepter pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Complète une tâche
     */
    public void completeTask() {

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/task/complete",
                    "");
            String body = Objects.requireNonNull(response.body()).string();

            TaskRewardDataSchema res = JsonConverter.fromJson(body, "data", TaskRewardDataSchema.class);

            logger.info("Tâche complété pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Echange une tâche contre une récompense
     */
    public void exchangeTask() {

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/task/exchange",
                    "");
            String body = Objects.requireNonNull(response.body()).string();

            TaskRewardDataSchema res = JsonConverter.fromJson(body, "data", TaskRewardDataSchema.class);

            logger.info("Tâche échanger pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Annule une tâche
     */
    public void cancelTask() {

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/task/cancel",
                    "");
            String body = Objects.requireNonNull(response.body()).string();

            TaskCancelledSchema res = JsonConverter.fromJson(body, "data", TaskCancelledSchema.class);

            logger.info("Tâche annulé pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

    /**
     * Supprime un item
     * @param code : code de l'item
     * @param quantity : quantité à supprimer
     */
    public void deleteItem(String code, int quantity) {

        try {
            Response response = this.caller.post("/my/" + this.character.getName() + "/action/delete",
                    "");
            String body = Objects.requireNonNull(response.body()).string();

            TaskCancelledSchema res = JsonConverter.fromJson(body, "data", TaskCancelledSchema.class);

            logger.info("Suppression de l'item " + code + " de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
        }
    }

}
