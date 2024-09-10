package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeItem {
    CONSUMABLE, BODY_ARMOR, WEAPON, RESOURCE, LEG_ARMOR, HELMET, BOOTS, SHIELD, AMULET, RING, ARTIFACT, CURRENCY;

    @JsonCreator
    public static TypeItem fromValue(String value) {
        return TypeItem.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
	return name().toLowerCase();
    }
}
