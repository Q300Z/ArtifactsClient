package models;

public class EquipRequestSchema {
    private CooldownSchema cooldown;
    private Slot slot;
    private ItemSchema item;
    private CharacterSchema character;

    public CooldownSchema getCooldown() {
        return cooldown;
    }

    public void setCooldown(CooldownSchema cooldown) {
        this.cooldown = cooldown;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public ItemSchema getItem() {
        return item;
    }

    public void setItem(ItemSchema item) {
        this.item = item;
    }

    public CharacterSchema getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSchema character) {
        this.character = character;
    }

}
