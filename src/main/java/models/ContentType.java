package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ContentType {
    MONSTER,RESOURCE,WORKSHOP,BANK,GRAND_EXCHANGE,TASKS_MASTER;

    @JsonCreator
    public static ContentType fromValue(String value) {
        return ContentType.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name().toLowerCase();
    }
}