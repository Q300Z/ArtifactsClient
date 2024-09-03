package models;

public class TaskRewardDataSchema {
    private CooldownSchema cooldown;
    private TaskRewardSchema reward;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public TaskRewardSchema getReward() {
        return reward;
    }

    public void setReward(TaskRewardSchema reward) {
        this.reward = reward;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }
}
