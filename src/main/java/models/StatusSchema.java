package models;

public class StatusSchema {
    private String status;
    private String version;
    private Integer max_level;
    private Integer characters_online;
    private String server_time;
    private AnnouncementSchema[] announcements;
    private String last_wipe;
    private String next_wipe;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getMax_level() {
        return max_level;
    }

    public void setMax_level(Integer max_level) {
        this.max_level = max_level;
    }

    public Integer getCharacters_online() {
        return characters_online;
    }

    public void setCharacters_online(Integer characters_online) {
        this.characters_online = characters_online;
    }

    public String getServer_time() {
        return server_time;
    }

    public void setServer_time(String server_time) {
        this.server_time = server_time;
    }

    public AnnouncementSchema[] getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(AnnouncementSchema[] announcements) {
        this.announcements = announcements;
    }

    public String getLast_wipe() {
        return last_wipe;
    }

    public void setLast_wipe(String last_wipe) {
        this.last_wipe = last_wipe;
    }

    public String getNext_wipe() {
        return next_wipe;
    }

    public void setNext_wipe(String next_wipe) {
        this.next_wipe = next_wipe;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StatusSchema {\n");
        sb.append("    status: ").append(this.status).append("\n");
        sb.append("    version: ").append(this.version).append("\n");
        sb.append("    charactersOnline: ").append(this.characters_online).append("\n");
        sb.append("    serverTime: ").append(this.server_time).append("\n");
        sb.append("    announcements: [").append("\n");
        for (AnnouncementSchema announcement : this.announcements) {
            sb.append("        ").append(announcement).append("\n");
        }
        sb.append("    ]\n");
        sb.append("    lastWipe: ").append(this.last_wipe).append("\n");
        sb.append("    nextWipe: ").append(this.next_wipe).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
