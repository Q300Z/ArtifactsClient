package models;

public class BankExtensionTransactionSchema {
    private CooldownSchema cooldown;
    private BankExtensionSchema transaction;
    private CharacterSchema character;

    public BankExtensionSchema getTransaction() {
        return transaction;
    }

    public void setTransaction(BankExtensionSchema transaction) {
        this.transaction = transaction;
    }

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }
}
