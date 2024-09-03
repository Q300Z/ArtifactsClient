package models;

public class GETransactionListSchema {
    private CooldownSchema cooldown;
    private GETransactionSchema transaction;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public GETransactionSchema getTransaction() {
        return transaction;
    }

    public void setTransaction(GETransactionSchema transaction) {
        this.transaction = transaction;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }
}
