package models;

public class TaskDataSchema {
    private CooldownSchema cooldown;
    private TaskSchema task;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public TaskSchema getTask() {
        return task;
    }

    public void setTask(TaskSchema task) {
        this.task = task;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }
}
