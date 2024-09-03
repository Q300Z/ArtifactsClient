package models;

public class DeleteItemSchema {
    private CooldownSchema cooldown;
    private SimpleItemSchema item;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public SimpleItemSchema getItem() {
        return item;
    }

    public void setItem(SimpleItemSchema item) {
        this.item = item;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }
}
