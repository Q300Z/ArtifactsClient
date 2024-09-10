package models;

public class ResourceSchema {
    private String name;
    private String code;
private CraftSkill skill;
private int level;
private DropRateSchema[] drops;

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

public CraftSkill getSkill() {
    return skill;
}

public void setSkill(CraftSkill skill) {
    this.skill = skill;
}

public int getLevel() {
    return level;
}

public void setLevel(int level) {
    this.level = level;
}

public DropRateSchema[] getDrops() {
    return drops;
}

public void setDrops(DropRateSchema[] drops) {
    this.drops = drops;
}

}
