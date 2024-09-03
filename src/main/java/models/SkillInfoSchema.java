package models;

public class SkillInfoSchema {
    private Integer xp;
    private DropSchema[] items;

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public DropSchema[] getItems() {
        return items;
    }

    public void setItems(DropSchema[] items) {
        this.items = items;
    }

}
