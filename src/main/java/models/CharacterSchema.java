package models;

public class CharacterSchema {

    private String name;
    private Skin skin;
    private int level;
    private int xp;
    private int max_xp;
    private int achievements_points;
    private int total_xp;
    private int gold;
    private int speed;
    private int mining_level;
    private int mining_xp;
    private int mining_max_xp;
    private int woodcutting_level;
    private int woodcutting_xp;
    private int woodcutting_max_xp;
    private int fishing_level;
    private int fishing_xp;
    private int fishing_max_xp;
    private int weaponcrafting_level;
    private int weaponcrafting_xp;
    private int weaponcrafting_max_xp;
    private int gearcrafting_level;
    private int gearcrafting_xp;
    private int gearcrafting_max_xp;
    private int jewelrycrafting_level;
    private int jewelrycrafting_xp;
    private int jewelrycrafting_max_xp;
    private int cooking_level;
    private int cooking_xp;
    private int cooking_max_xp;
    private int hp;
    private int haste;
    private int critical_strike;
    private int stamina;
    private int attack_fire;
    private int attack_earth;
    private int attack_water;
    private int attack_air;
    private int dmg_fire;
    private int dmg_earth;
    private int dmg_water;
    private int dmg_air;
    private int res_fire;
    private int res_earth;
    private int res_water;
    private int res_air;
    private int x;
    private int y;
    private int cooldown;
    private String cooldown_expiration;
    private String weapon_slot;
    private String shield_slot;
    private String helmet_slot;
    private String body_armor_slot;
    private String leg_armor_slot;
    private String boots_slot;
    private String ring1_slot;
    private String ring2_slot;
    private String amulet_slot;
    private String artifact1_slot;
    private String artifact2_slot;
    private String artifact3_slot;
    private String consumable1_slot;
    private int consumable1_slot_quantity;
    private String consumable2_slot;
    private int consumable2_slot_quantity;
    private String task;
    private String task_type;
    private int task_progress;
    private int task_total;
    private int inventory_max_items;
    private InventorySlot[] inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMax_xp() {
        return max_xp;
    }

    public void setMax_xp(int max_xp) {
        this.max_xp = max_xp;
    }

    public int getAchievements_points() {
        return achievements_points;
    }

    public void setAchievements_points(int achievements_points) {
        this.achievements_points = achievements_points;
    }

    public int getTotal_xp() {
        return total_xp;
    }

    public void setTotal_xp(int total_xp) {
        this.total_xp = total_xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMining_level() {
        return mining_level;
    }

    public void setMining_level(int mining_level) {
        this.mining_level = mining_level;
    }

    public int getMining_xp() {
        return mining_xp;
    }

    public void setMining_xp(int mining_xp) {
        this.mining_xp = mining_xp;
    }

    public int getMining_max_xp() {
        return mining_max_xp;
    }

    public void setMining_max_xp(int mining_max_xp) {
        this.mining_max_xp = mining_max_xp;
    }

    public int getWoodcutting_level() {
        return woodcutting_level;
    }

    public void setWoodcutting_level(int woodcutting_level) {
        this.woodcutting_level = woodcutting_level;
    }

    public int getWoodcutting_xp() {
        return woodcutting_xp;
    }

    public void setWoodcutting_xp(int woodcutting_xp) {
        this.woodcutting_xp = woodcutting_xp;
    }

    public int getWoodcutting_max_xp() {
        return woodcutting_max_xp;
    }

    public void setWoodcutting_max_xp(int woodcutting_max_xp) {
        this.woodcutting_max_xp = woodcutting_max_xp;
    }

    public int getFishing_level() {
        return fishing_level;
    }

    public void setFishing_level(int fishing_level) {
        this.fishing_level = fishing_level;
    }

    public int getFishing_xp() {
        return fishing_xp;
    }

    public void setFishing_xp(int fishing_xp) {
        this.fishing_xp = fishing_xp;
    }

    public int getFishing_max_xp() {
        return fishing_max_xp;
    }

    public void setFishing_max_xp(int fishing_max_xp) {
        this.fishing_max_xp = fishing_max_xp;
    }

    public int getWeaponcrafting_level() {
        return weaponcrafting_level;
    }

    public void setWeaponcrafting_level(int weaponcrafting_level) {
        this.weaponcrafting_level = weaponcrafting_level;
    }

    public int getWeaponcrafting_xp() {
        return weaponcrafting_xp;
    }

    public void setWeaponcrafting_xp(int weaponcrafting_xp) {
        this.weaponcrafting_xp = weaponcrafting_xp;
    }

    public int getWeaponcrafting_max_xp() {
        return weaponcrafting_max_xp;
    }

    public void setWeaponcrafting_max_xp(int weaponcrafting_max_xp) {
        this.weaponcrafting_max_xp = weaponcrafting_max_xp;
    }

    public int getGearcrafting_level() {
        return gearcrafting_level;
    }

    public void setGearcrafting_level(int gearcrafting_level) {
        this.gearcrafting_level = gearcrafting_level;
    }

    public int getGearcrafting_xp() {
        return gearcrafting_xp;
    }

    public void setGearcrafting_xp(int gearcrafting_xp) {
        this.gearcrafting_xp = gearcrafting_xp;
    }

    public int getGearcrafting_max_xp() {
        return gearcrafting_max_xp;
    }

    public void setGearcrafting_max_xp(int gearcrafting_max_xp) {
        this.gearcrafting_max_xp = gearcrafting_max_xp;
    }

    public int getJewelrycrafting_level() {
        return jewelrycrafting_level;
    }

    public void setJewelrycrafting_level(int jewelrycrafting_level) {
        this.jewelrycrafting_level = jewelrycrafting_level;
    }

    public int getJewelrycrafting_xp() {
        return jewelrycrafting_xp;
    }

    public void setJewelrycrafting_xp(int jewelrycrafting_xp) {
        this.jewelrycrafting_xp = jewelrycrafting_xp;
    }

    public int getJewelrycrafting_max_xp() {
        return jewelrycrafting_max_xp;
    }

    public void setJewelrycrafting_max_xp(int jewelrycrafting_max_xp) {
        this.jewelrycrafting_max_xp = jewelrycrafting_max_xp;
    }

    public int getCooking_level() {
        return cooking_level;
    }

    public void setCooking_level(int cooking_level) {
        this.cooking_level = cooking_level;
    }

    public int getCooking_xp() {
        return cooking_xp;
    }

    public void setCooking_xp(int cooking_xp) {
        this.cooking_xp = cooking_xp;
    }

    public int getCooking_max_xp() {
        return cooking_max_xp;
    }

    public void setCooking_max_xp(int cooking_max_xp) {
        this.cooking_max_xp = cooking_max_xp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHaste() {
        return haste;
    }

    public void setHaste(int haste) {
        this.haste = haste;
    }

    public int getCritical_strike() {
        return critical_strike;
    }

    public void setCritical_strike(int critical_strike) {
        this.critical_strike = critical_strike;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getAttack_fire() {
        return attack_fire;
    }

    public void setAttack_fire(int attack_fire) {
        this.attack_fire = attack_fire;
    }

    public int getAttack_earth() {
        return attack_earth;
    }

    public void setAttack_earth(int attack_earth) {
        this.attack_earth = attack_earth;
    }

    public int getAttack_water() {
        return attack_water;
    }

    public void setAttack_water(int attack_water) {
        this.attack_water = attack_water;
    }

    public int getAttack_air() {
        return attack_air;
    }

    public void setAttack_air(int attack_air) {
        this.attack_air = attack_air;
    }

    public int getDmg_fire() {
        return dmg_fire;
    }

    public void setDmg_fire(int dmg_fire) {
        this.dmg_fire = dmg_fire;
    }

    public int getDmg_earth() {
        return dmg_earth;
    }

    public void setDmg_earth(int dmg_earth) {
        this.dmg_earth = dmg_earth;
    }

    public int getDmg_water() {
        return dmg_water;
    }

    public void setDmg_water(int dmg_water) {
        this.dmg_water = dmg_water;
    }

    public int getDmg_air() {
        return dmg_air;
    }

    public void setDmg_air(int dmg_air) {
        this.dmg_air = dmg_air;
    }

    public int getRes_fire() {
        return res_fire;
    }

    public void setRes_fire(int res_fire) {
        this.res_fire = res_fire;
    }

    public int getRes_earth() {
        return res_earth;
    }

    public void setRes_earth(int res_earth) {
        this.res_earth = res_earth;
    }

    public int getRes_water() {
        return res_water;
    }

    public void setRes_water(int res_water) {
        this.res_water = res_water;
    }

    public int getRes_air() {
        return res_air;
    }

    public void setRes_air(int res_air) {
        this.res_air = res_air;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public String getCooldown_expiration() {
        return cooldown_expiration;
    }

    public void setCooldown_expiration(String cooldown_expiration) {
        this.cooldown_expiration = cooldown_expiration;
    }

    public String getWeapon_slot() {
        return weapon_slot;
    }

    public void setWeapon_slot(String weapon_slot) {
        this.weapon_slot = weapon_slot;
    }

    public String getShield_slot() {
        return shield_slot;
    }

    public void setShield_slot(String shield_slot) {
        this.shield_slot = shield_slot;
    }

    public String getHelmet_slot() {
        return helmet_slot;
    }

    public void setHelmet_slot(String helmet_slot) {
        this.helmet_slot = helmet_slot;
    }

    public String getBody_armor_slot() {
        return body_armor_slot;
    }

    public void setBody_armor_slot(String body_armor_slot) {
        this.body_armor_slot = body_armor_slot;
    }

    public String getLeg_armor_slot() {
        return leg_armor_slot;
    }

    public void setLeg_armor_slot(String leg_armor_slot) {
        this.leg_armor_slot = leg_armor_slot;
    }

    public String getBoots_slot() {
        return boots_slot;
    }

    public void setBoots_slot(String boots_slot) {
        this.boots_slot = boots_slot;
    }

    public String getRing1_slot() {
        return ring1_slot;
    }

    public void setRing1_slot(String ring1_slot) {
        this.ring1_slot = ring1_slot;
    }

    public String getRing2_slot() {
        return ring2_slot;
    }

    public void setRing2_slot(String ring2_slot) {
        this.ring2_slot = ring2_slot;
    }

    public String getAmulet_slot() {
        return amulet_slot;
    }

    public void setAmulet_slot(String amulet_slot) {
        this.amulet_slot = amulet_slot;
    }

    public String getArtifact1_slot() {
        return artifact1_slot;
    }

    public void setArtifact1_slot(String artifact1_slot) {
        this.artifact1_slot = artifact1_slot;
    }

    public String getArtifact2_slot() {
        return artifact2_slot;
    }

    public void setArtifact2_slot(String artifact2_slot) {
        this.artifact2_slot = artifact2_slot;
    }

    public String getArtifact3_slot() {
        return artifact3_slot;
    }

    public void setArtifact3_slot(String artifact3_slot) {
        this.artifact3_slot = artifact3_slot;
    }

    public String getConsumable1_slot() {
        return consumable1_slot;
    }

    public void setConsumable1_slot(String consumable1_slot) {
        this.consumable1_slot = consumable1_slot;
    }

    public int getConsumable1_slot_quantity() {
        return consumable1_slot_quantity;
    }

    public void setConsumable1_slot_quantity(int consumable1_slot_quantity) {
        this.consumable1_slot_quantity = consumable1_slot_quantity;
    }

    public String getConsumable2_slot() {
        return consumable2_slot;
    }

    public void setConsumable2_slot(String consumable2_slot) {
        this.consumable2_slot = consumable2_slot;
    }

    public int getConsumable2_slot_quantity() {
        return consumable2_slot_quantity;
    }

    public void setConsumable2_slot_quantity(int consumable2_slot_quantity) {
        this.consumable2_slot_quantity = consumable2_slot_quantity;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }

    public int getTask_progress() {
        return task_progress;
    }

    public void setTask_progress(int task_progress) {
        this.task_progress = task_progress;
    }

    public int getTask_total() {
        return task_total;
    }

    public void setTask_total(int task_total) {
        this.task_total = task_total;
    }

    public int getInventory_max_items() {
        return inventory_max_items;
    }

    public void setInventory_max_items(int inventory_max_items) {
        this.inventory_max_items = inventory_max_items;
    }

    public InventorySlot[] getInventory() {
        return inventory;
    }

    public void setInventory(InventorySlot[] inventory) {
        this.inventory = inventory;
    }

}
