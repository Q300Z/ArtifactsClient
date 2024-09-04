package models;

public class CharacterFightDataSchema extends CommunSchema {
    private FightSchema fight;

    public FightSchema getFight() {
        return fight;
    }

    public void setFight(FightSchema fight) {
        this.fight = fight;
    }

}
