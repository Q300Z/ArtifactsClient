package models.skill;

import models.CommunSchema;

public class SkillDataSchema extends CommunSchema {
    private SkillInfoSchema details;

    public SkillInfoSchema getDetails() {
        return details;
    }

    public void setDetails(SkillInfoSchema details) {
        this.details = details;
    }

}
