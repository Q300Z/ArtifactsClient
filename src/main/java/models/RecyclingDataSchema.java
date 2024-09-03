package models;

public class RecyclingDataSchema {
    private CooldownSchema cooldown;
    private RecyclingItemsSchema details;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public RecyclingItemsSchema getDetails() {
        return details;
    }

    public void setDetails(RecyclingItemsSchema details) {
        this.details = details;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }
}
