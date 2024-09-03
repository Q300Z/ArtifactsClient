package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Skin {
    MEN1, MEN2, MEN3, WOMEN1, WOMEN2, WOMEN3;

    @JsonCreator
    public static Skin fromValue(String value) {
        return Skin.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }
}
