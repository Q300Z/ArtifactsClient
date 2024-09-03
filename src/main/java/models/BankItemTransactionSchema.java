package models;

public class BankItemTransactionSchema {
    private CooldownSchema cooldown;
    private ItemSchema item;
    private SimpleItemSchema[] bank;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public ItemSchema getItem() {
        return item;
    }

    public void setItem(ItemSchema item) {
        this.item = item;
    }

    public SimpleItemSchema[] getBank() {
        return bank;
    }

    public void setBank(SimpleItemSchema[] bank) {
        this.bank = bank;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }

}
