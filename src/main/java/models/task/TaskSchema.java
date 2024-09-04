package models.task;

import models.Type;

public class TaskSchema {
    private String code;
    private Type type;
    private int tolal;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getTolal() {
        return tolal;
    }

    public void setTolal(int tolal) {
        this.tolal = tolal;
    }
}
