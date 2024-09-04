package models;

public class EquipRequestSchema extends CommunSchema {
    private Slot slot;
    private ItemSchema item;

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

}
