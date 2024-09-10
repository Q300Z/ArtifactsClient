package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CraftSkill {
    WEAPONCRAFTING, GEARCRAFTING, JEWELRYCRAFTING, COOKING, WOODCUTTING, MINING;

    @JsonCreator
    public static CraftSkill fromValue(String value) {
        return CraftSkill.valueOf(value.toUpperCase());
    }

    @JsonValue
    public String toValue() {
	return name().toLowerCase();
    }
}
