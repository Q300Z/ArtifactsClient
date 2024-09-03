package models;

public class BankGoldTransactionSchema {
    private CooldownSchema cooldown;
    private GoldSchema bank;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public GoldSchema getBank() {
        return bank;
    }

    public void setBank(GoldSchema bank) {
        this.bank = bank;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }

}
