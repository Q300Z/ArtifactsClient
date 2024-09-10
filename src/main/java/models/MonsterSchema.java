package models;

public class MonsterSchema {
    private String name;
    private String code;
    private int level;
    private int hp;
    private int attack_fire;
    private int attack_earth;
    private int attack_water;
    private int attack_air;
    private int res_fire;
    private int res_earth;
    private int res_water;
    private int res_air;
    private int min_gold;
    private int max_gold;
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

    public int getLevel() {
	return level;
    }

    public void setLevel(int level) {
	this.level = level;
    }

    public int getHp() {
	return hp;
    }

    public void setHp(int hp) {
	this.hp = hp;
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

    public int getMin_gold() {
	return min_gold;
    }

    public void setMin_gold(int min_gold) {
	this.min_gold = min_gold;
    }

    public int getMax_gold() {
	return max_gold;
    }

    public void setMax_gold(int max_gold) {
	this.max_gold = max_gold;
    }

    public DropRateSchema[] getDrops() {
	return drops;
    }

    public void setDrops(DropRateSchema[] drops) {
	this.drops = drops;
    }

}
