package models.item;

public class ItemSchema {
    private String name;
    private String code;
    private int level;
    private String type;
    private String subtype;
    private String description;
    private ItemEffectSchema[] effects;
    private CraftSchema craft;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemEffectSchema[] getEffects() {
        return effects;
    }

    public void setEffects(ItemEffectSchema[] effects) {
        this.effects = effects;
    }

    public CraftSchema getCraft() {
        return craft;
    }

    public void setCraft(CraftSchema craft) {
        this.craft = craft;
    }

}
