package models;

public class CharacterFightDataSchema {
    private CooldownSchema cooldown;
    private FightSchema fight;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public FightSchema getFight() {
        return fight;
    }

    public void setFight(FightSchema fight) {
        this.fight = fight;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }

}
