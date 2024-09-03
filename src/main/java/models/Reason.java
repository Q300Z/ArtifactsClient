package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Reason {
    MOVEMENT, FIGHT, CRAFTING, GATHERING, BUY_GE, SELL_GE, DELETE_ITEM, DEPOSIT_BANK, WITHDRAW_BANK, EQUIP, UNEQUIP,
    TASK, RECYCLING;

    @JsonCreator
    public static Reason fromValue(String value) {
        return Reason.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }
}
