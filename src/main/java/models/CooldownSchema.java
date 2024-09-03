package models;

public class CooldownSchema {
    private int total_seconds;
    private int remaining_seconds;
    private String started_at;
    private String expiration;
    private Reason reason;

    public int getTotal_seconds() {
        return total_seconds;
    }

    public void setTotal_seconds(int total_seconds) {
        this.total_seconds = total_seconds;
    }

    public int getRemaining_seconds() {
        return remaining_seconds;
    }

    public void setRemaining_seconds(int remaining_seconds) {
        this.remaining_seconds = remaining_seconds;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

}
