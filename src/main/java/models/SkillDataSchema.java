package models;

public class SkillDataSchema {
    private CooldownSchema cooldown;
    private SkillInfoSchema details;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public SkillInfoSchema getDetails() {
        return details;
    }

    public void setDetails(SkillInfoSchema details) {
        this.details = details;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }

}
