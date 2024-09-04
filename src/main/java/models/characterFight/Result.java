package models.characterFight;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Result {
    WIN, LOSE;

    @JsonCreator
    public static Result fromValue(String value) {
        return Result.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }

}
