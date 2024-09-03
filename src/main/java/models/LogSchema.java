package models;

public class LogSchema {
    private String characterName;
    private String accountCharacter;
    private String type;
    private String description;
    private Object content;
    private int cooldown;
    private String cooldownExpiration;
    private String createdAt;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getAccountCharacter() {
        return accountCharacter;
    }

    public void setAccountCharacter(String accountCharacter) {
        this.accountCharacter = accountCharacter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public String getCooldownExpiration() {
        return cooldownExpiration;
    }

    public void setCooldownExpiration(String cooldownExpiration) {
        this.cooldownExpiration = cooldownExpiration;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
