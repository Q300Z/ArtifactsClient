package models.equipRequest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Slot {
    WEAPON, SHIELD, HELMET, BODY_ARMOR, LEG_ARMOR, BOOTS, RING1, RING2, AMULET, ARTIFACT1, ARTIFACT2, ARTIFACT3,
    CONSUMABLE1, CONSUMABLE2;

    @JsonCreator
    public static Slot fromValue(String value) {
        return Slot.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
