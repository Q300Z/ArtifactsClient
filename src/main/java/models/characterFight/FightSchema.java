package models.characterFight;

import models.commun.DropSchema;

public class FightSchema {
    private int xp;
    private int gold;
    private DropSchema[] drops;
    private int turns;
    private BlockedHitsSchema monster_blocked_hits;
    private BlockedHitsSchema player_blocked_hits;
    private String[] logs;
    private Result result;

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public DropSchema[] getDrops() {
        return drops;
    }

    public void setDrops(DropSchema[] drops) {
        this.drops = drops;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public BlockedHitsSchema getMonster_blocked_hits() {
        return monster_blocked_hits;
    }

    public void setMonster_blocked_hits(BlockedHitsSchema monster_blocked_hits) {
        this.monster_blocked_hits = monster_blocked_hits;
    }

    public BlockedHitsSchema getPlayer_blocked_hits() {
        return player_blocked_hits;
    }

    public void setPlayer_blocked_hits(BlockedHitsSchema player_blocked_hits) {
        this.player_blocked_hits = player_blocked_hits;
    }

    public String[] getLogs() {
        return logs;
    }

    public void setLogs(String[] logs) {
        this.logs = logs;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
