package services;

import java.io.IOException;
import java.util.Objects;

import org.json.JSONObject;

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
import models.item.DeleteItemSchema;
import models.recycling.RecyclingDataSchema;
import models.skill.SkillDataSchema;
import models.task.TaskCancelledSchema;
import models.task.TaskDataSchema;
import models.task.TaskRewardDataSchema;
import okhttp3.Response;
import utils.Caller;
import utils.JsonConverter;
import utils.Logger;
import utils.LoggerConfig;
import utils.Sleep;

public class Actions {
    private final Logger logger = LoggerConfig.getLogger();

    private final Caller caller;
    private final CharacterSchema character;

    public Actions(Caller caller, CharacterSchema character) {
        this.caller = caller;
        this.character = character;
    }

    private String RequestAPI(String action, String body) throws ApiException, IOException {
        Response response = this.caller.post("/my/" + this.character.getName() + "/action/" + action, body);
        return Objects.requireNonNull(response.body()).string();
    }

    /**
     * Déplace le personnage à la position x et y
     *
     * @param x int : position x
     * @param y int : position y
     */
    public CharacterMovementDataSchema move(int x, int y) {

        JSONObject obj = new JSONObject();
        obj.put("x", x);
        obj.put("y", y);

        try {
            String body = RequestAPI("move", obj.toString());

            CharacterMovementDataSchema res = JsonConverter.fromJson(body, "data", CharacterMovementDataSchema.class);

            logger.info("Déplacement de " + this.character.getName() + " en " + x + ":" + y + " dans "
                    + Objects.requireNonNull(res).getCooldown().getRemaining_seconds() + " secondes");

            new Sleep(res.getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Equipe un équipement
     *
     * @param code     String : code de l'item
     * @param slot     Slot : slot de l'inventaire
     * @param quantity int : quantité à équiper
     */
    public EquipRequestSchema equip(String code, Slot slot, int quantity) {

        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("slot", slot.toString());
        obj.put("quantity", quantity);

        try {
            String body = RequestAPI("equip", obj.toString());

            EquipRequestSchema res = JsonConverter.fromJson(body, "data", EquipRequestSchema.class);

            logger.info("Equipement de " + this.character.getName() + " avec " + code + " dans "
                    + Objects.requireNonNull(res).getCooldown().getRemaining_seconds() + " secondes");
            new Sleep(res.getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Déséquipe un équipement
     *
     * @param slot     Slot: slot de l'inventaire
     * @param quantity int: quantité à déséquiper
     */
    public EquipRequestSchema unequip(Slot slot, int quantity) {

        JSONObject obj = new JSONObject();
        obj.put("slot", slot.toString());
        obj.put("quantity", quantity);

        try {
            String body = RequestAPI("unequip", obj.toString());

            EquipRequestSchema res = JsonConverter.fromJson(body, "data", EquipRequestSchema.class);

            logger.info("Déséquipement de " + this.character.getName() + " avec " + slot + " dans "
                    + Objects.requireNonNull(res).getCooldown().getRemaining_seconds() + " secondes");
            new Sleep(res.getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Attaque un ennemi
     */
    public CharacterFightDataSchema fight() {
        try {
            String body = RequestAPI("fight", "");

            CharacterFightDataSchema res = JsonConverter.fromJson(body, "data", CharacterFightDataSchema.class);

            logger.info("Résultat du combat de " + this.character.getName() + " : "
                    + Objects.requireNonNull(res).getFight().getResult().toString() + " - Expérience : " + res.getFight().getXp());
            new Sleep(res.getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Récolte une ressource
     */
    public SkillDataSchema gathering() {
        try {
            String body = RequestAPI("gathering", "");

            SkillDataSchema res = JsonConverter.fromJson(body, "data", SkillDataSchema.class);

            logger.info("Résultat de la récolte de " + this.character.getName() + " : Expérience :"
                    + Objects.requireNonNull(res).getDetails().getXp());
            new Sleep(res.getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }


    /**
     * Fabrique un item
     *
     * @param code     String: code de l'item
     * @param quantity int: quantité à fabriquer
     */
    public SkillDataSchema crafting(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);

        try {
            String body = RequestAPI("crafting", obj.toString());

            SkillDataSchema res = JsonConverter.fromJson(body, "data", SkillDataSchema.class);

            logger.info("Résultat de la fabrication de " + this.character.getName() + " : Expérience :"
                    + Objects.requireNonNull(res).getDetails().getXp());
            new Sleep(res.getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }

    }

    /**
     * Dépose un item dans la banque
     *
     * @param code     String: code de l'item
     * @param quantity int: quantité à déposer
     */
    public BankItemTransactionSchema bank(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);

        try {
            String body = RequestAPI("bank/deposit", obj.toString());

            BankItemTransactionSchema res = JsonConverter.fromJson(body, "data", BankItemTransactionSchema.class);

            logger.info("Transaction d'Item de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }

    }

    /**
     * Dépose de l'or dans la banque
     *
     * @param quantity int: quantité à déposer
     */
    public BankGoldTransactionSchema bank(int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("quantity", quantity);

        try {
            String body = RequestAPI("bank/deposit/gold", obj.toString());

            BankGoldTransactionSchema res = JsonConverter.fromJson(body, "data", BankGoldTransactionSchema.class);

            logger.info("Transaction d'Or de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }

    }

    /**
     * Retire un item de la banque
     *
     * @param code     String: code de l'item
     * @param quantity int : quantité à retirer
     */
    public BankItemTransactionSchema takeInBank(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);

        try {
            String body = RequestAPI("bank/withdraw", obj.toString());

            BankItemTransactionSchema res = JsonConverter.fromJson(body, "data", BankItemTransactionSchema.class);

            logger.info("Transaction d'Item de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }

    }

    /**
     * Retire de l'or de la banque
     *
     * @param quantity int: quantité à retirer
     */
    public BankGoldTransactionSchema takeInBank(int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("quantity", quantity);

        try {
            String body = RequestAPI("bank/withdraw/gold", obj.toString());

            BankGoldTransactionSchema res = JsonConverter.fromJson(body, "data", BankGoldTransactionSchema.class);

            logger.info("Transaction d'Or de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }

    }

    /**
     * Recycle un item
     *
     * @param code     String: code de l'item
     * @param quantity int: quantité à recycler
     */
    public RecyclingDataSchema recycling(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);

        try {
            String body = RequestAPI("recycling", obj.toString());

            RecyclingDataSchema res = JsonConverter.fromJson(body, "data", RecyclingDataSchema.class);

            logger.info("Recyclage de l'item " + code + " de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Achète un item dans le grand marché
     *
     * @param code     String: code de l'item
     * @param quantity int: quantité à acheter
     * @param price    int: prix d'achat
     */
    public GETransactionListSchema buyItem(String code, int quantity, int price) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);
        obj.put("price", price);

        try {
            String body = RequestAPI("ge/buy", obj.toString());

            GETransactionListSchema res = JsonConverter.fromJson(body, "data", GETransactionListSchema.class);

            logger.info("Achat de l'item " + code + " de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Vend un item dans le grand marché
     *
     * @param code     String : code de l'item
     * @param quantity int: quantité à vendre
     * @param price    int : prix de vente
     */
    public GETransactionListSchema sellItem(String code, int quantity, int price) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);
        obj.put("price", price);

        try {
            String body = RequestAPI("ge/sell", obj.toString());

            GETransactionListSchema res = JsonConverter.fromJson(body, "data", GETransactionListSchema.class);

            logger.info("Vente de l'item " + code + " de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Achète une extension de banque
     */
    public BankExtensionTransactionSchema buyBankExpansion() {

        try {
            String body = RequestAPI("bank/buy_expansion", "");

            BankExtensionTransactionSchema res = JsonConverter.fromJson(body, "data", BankExtensionTransactionSchema.class);

            logger.info("Achat d'une extension de banque pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Accepte une nouvelle tâche
     */
    public TaskDataSchema newTask() {

        try {
            String body = RequestAPI("task/new", "");

            TaskDataSchema res = JsonConverter.fromJson(body, "data", TaskDataSchema.class);

            logger.info("Nouvelle tâche accepter pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Complète une tâche
     */
    public TaskRewardDataSchema completeTask() {

        try {
            String body = RequestAPI("task/complete", "");

            TaskRewardDataSchema res = JsonConverter.fromJson(body, "data", TaskRewardDataSchema.class);

            logger.info("Tâche complété pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Echange une tâche contre une récompense
     */
    public TaskRewardDataSchema exchangeTask() {

        try {
            String body = RequestAPI("task/exchange", "");

            TaskRewardDataSchema res = JsonConverter.fromJson(body, "data", TaskRewardDataSchema.class);

            logger.info("Tâche échanger pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Annule une tâche
     */
    public TaskCancelledSchema cancelTask() {

        try {
            String body = RequestAPI("task/cancel", "");

            TaskCancelledSchema res = JsonConverter.fromJson(body, "data", TaskCancelledSchema.class);

            logger.info("Tâche annulé pour " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

    /**
     * Supprime un item
     *
     * @param code     String: code de l'item
     * @param quantity int: quantité à supprimer
     */
    public DeleteItemSchema deleteItem(String code, int quantity) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("quantity", quantity);
        try {
            String body = RequestAPI("delete", obj.toString());

            DeleteItemSchema res = JsonConverter.fromJson(body, "data", DeleteItemSchema.class);

            logger.info("Suppression de l'item " + code + " de " + this.character.getName());
            new Sleep(Objects.requireNonNull(res).getCooldown().getRemaining_seconds());
            return res;
        } catch (IOException | ApiException e) {
            logger.warning("Erreur : " + e.getMessage());
            return null;
        }
    }

}
