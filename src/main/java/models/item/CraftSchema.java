package models.item;

public class CraftSchema {
    private String skill;
    private int level;
    private SimpleItemSchema[] items;
    private int quantity;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public SimpleItemSchema[] getItems() {
        return items;
    }

    public void setItems(SimpleItemSchema[] items) {
        this.items = items;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
