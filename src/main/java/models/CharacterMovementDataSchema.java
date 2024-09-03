package models;

public class CharacterMovementDataSchema {
    private CooldownSchema cooldown;
    private MapSchema destination;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public MapSchema getDestination() {
        return destination;
    }

    public void setDestination(MapSchema destination) {
        this.destination = destination;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }

}
